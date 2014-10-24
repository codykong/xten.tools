package com.blog.common.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;


public class IDGeneratorUtil {
    private Map<String, IDGen> map = new HashMap<String, IDGen>();
    private DataSource dataSource;
    /**
     * 每次去数据库中获取的值
     */
    private long fecthValue = 10;

    private void init(String key) {
        synchronized (this) {
            if (map.get(key) == null) {
                map.put(key, new IDGen(key, dataSource, fecthValue));
            }
        }
    }

    /**
     * 生成主键
     * 
     * @param key
     *            生成主键的key值，对应于数据库中id_generate的name的值
     * @return 最新的主键值
     * @author yfyangzhen
     * @version 2013-5-16
     */
    public long generateID(String key) {
        IDGen idGen = map.get(key);
        if (idGen == null) {
            init(key);
            idGen = map.get(key);
        }
        return idGen.generateID();
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long getFecthValue() {
        return fecthValue;
    }

    public void setFecthValue(long fecthValue) {
        this.fecthValue = fecthValue;
    }

    private class IDGen {
        private byte[] blockByte = new byte[1];

        private DataSource dataSource;

        /**
         * 初始值
         */
        private long initValue;

        /**
         * 每次去数据库中获取的值
         */
        private long fecthValue = 1000;

        /**
         * 最大值
         */
        private long maxValue;

        private AtomicLong id;

        /**
         * 生成主键的表名
         */
        private String defaultTableName = "id_generate";

        /**
         * 生成主键的表中的name列的默认值
         */
        private String nameColumeDefaultValue = "common";

        public IDGen(String nameColumeValue, DataSource dataSource, long fecthValue) {
            this.nameColumeDefaultValue = nameColumeValue;
            this.dataSource = dataSource;
            this.fecthValue = fecthValue;
            init();
        }

        /**
         * 初始化方法 初始时就去数据库中加载数据，并更新数据库中的最大值，并设置本类中的初始值和最大值
         */
        private void init() {
            Connection conn = getConn();
            // statement用来执行SQL语句
            ResultSet rs = null;
            Statement statement = null;
            try {
                //TODO
//                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                conn.setAutoCommit(false);

                statement = conn.createStatement();
                String sql = populateGetCurrentIdSql();
                rs = statement.executeQuery(sql);

                long newValue;
                long initValueTemp;
                if (rs.next()) {
                    initValueTemp = rs.getLong(1);
                    newValue = setNewMaxValue(statement, initValueTemp, false);

                } else {
//                    initValueTemp = 0l;
//                    newValue = setNewMaxValue(statement, initValueTemp, true);
                    throw new RuntimeException("数据库中不存在name为:"
                            + this.nameColumeDefaultValue + "的值");
                }

                conn.commit();

                // 设置最大值放在事务提交之后，防止事务失败，最大值被设置上
                maxValue = newValue;
                initValue = initValueTemp;
                id = new AtomicLong(initValue);
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
                throw new RuntimeException(e);
            } finally {
                closeCon(conn, rs, statement);
            }
        }

        /**
         * 生成id
         * 
         * @return
         * @throws SQLException
         * @throws ClassNotFoundException
         */
        public long generateID() {
            return nextLong();

        }

        /**
         * 获取下一个id值
         * 
         * @return
         */
        public long nextLong() {
            long newID = id.incrementAndGet();
            if (newID >= maxValue) {
                synchronized (blockByte) {
                    /*
                     * long oldID = id.get(); long newID = oldID + 1;
                     */
                    newID = id.incrementAndGet();// 再获取一次
                    if (newID >= maxValue) {
                        Connection conn = getConn();
                        // statement用来执行SQL语句
                        ResultSet rs = null;
                        Statement statement = null;

                        try {
                            //TODO
//                            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                            conn.setAutoCommit(false);
                            statement = conn.createStatement();
                            String sql = populateGetCurrentIdSql();
                            rs = statement.executeQuery(sql);
                            rs.next();
                            newID = rs.getLong(1);

                            long newValue = setNewMaxValue(statement, newID, false);
                            conn.commit();

                            // 设置最大值放在事务提交之后，防止事务失败，最大值被设置上
                            maxValue = newValue;
                            id.set(newID);
                        } catch (SQLException e) {
                            try {
                                conn.rollback();
                            } catch (SQLException e1) {
                                throw new RuntimeException(e1);
                            }
                            throw new RuntimeException(e);
                        } finally {
                            closeCon(conn, rs, statement);

                        }
                    }
                    /*
                     * id.set(newID); return newID;
                     */
                }
            }
            return newID;
        }

        /**
         * 生成最新的最大值，并插入或更新到数据库中
         * 
         * @param statement
         * @return
         * @throws SQLException
         */
        private long setNewMaxValue(Statement statement, long oldValue, boolean isInsert) throws SQLException {
            StringBuffer sql = new StringBuffer();
            long newValue = oldValue + fecthValue;
            if (isInsert) {
                sql.append("insert into ").append(defaultTableName).append("(id, name) values (").append(newValue)
                        .append(",'").append(nameColumeDefaultValue).append("')");
            } else {
                sql.append("update ").append(defaultTableName).append(" set id=").append(newValue)
                        .append(" where name='").append(nameColumeDefaultValue).append("'");
            }
            statement.execute(sql.toString());
            return newValue;
        }

        /**
         * 获取数据库连接
         * 
         * @return
         * @throws ClassNotFoundException
         * @throws SQLException
         */
        private Connection getConn() {
            // 连续数据库
            Connection conn = null;
            try {
                conn = dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return conn;
        }

        /**
         * 关闭连接。
         * 
         * @param conn
         * @param rs
         * @param statement
         */
        private void closeCon(Connection conn, ResultSet rs, Statement statement) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        /**
         * 拼装获取数据库中当前id的sql
         * 
         * @return
         */
        private String populateGetCurrentIdSql() {
            String sql = new StringBuffer("select id from ").append(defaultTableName).append(" where name='")
                    .append(nameColumeDefaultValue).append("'").append(" for update ").toString();
            return sql;
        }
    }
}
