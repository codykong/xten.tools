package com.blog.dao;

import com.blog.dao.provider.CommentSqlProvider;
import com.blog.domain.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-23
 * Time: 下午3:23
 * To change this template use File | Settings | File Templates.
 */
public interface CommentDAO {

    /**
     * 保存评论
     * @param comment
     */
    @SelectKey(before=false,keyProperty="id",resultType=Long.class,statementType= StatementType.STATEMENT,
            statement="SELECT LAST_INSERT_ID() AS id")
    @Insert("INSERT INTO ch_comment (uid,source_id,ancestor_id,content,type,create_time,update_time,status,level,user_name) " +
            "VALUES (#{uid},#{source_id},#{ancestor_id},#{content},#{type},#{create_time},#{update_time},#{status},#{level},#{user_name})")
    void save(Comment comment);

    /**
     * 查询对该微博的所有评论
     * @param sourceId
     * @return
     */
    @Select("SELECT * FROM ch_comment WHERE source_id=#{source_id} AND type=1 AND status=0 ORDER BY create_time " +
            "ASC LIMIT #{offset},#{size}")
    List<Comment> getComments(@Param("source_id") long sourceId,@Param("offset") int offset, @Param("size") int size);


    @SelectProvider(type=CommentSqlProvider.class, method="getCommentsByIds")
    List<Comment> getCommentsByIds(@Param("ids") List<Long> commentIds);

    /**
     * 查询对该微博的所有直接评论数
     * @param sourceId
     * @param type
     * @return
     */
    @Select("SELECT count(*) FROM ch_comment WHERE source_id=#{source_id} AND type=#{type} AND status=0 ORDER BY " +
            "create_time ASC LIMIT #{offset},#{size}")
    int getTotalNum(@Param("source_id") long sourceId,@Param("type") int type);

    /**
     * 增加支持数量
     * @param CommentId
     */
    @Select("UPDATE ch_comment SET support_count=support_count+1 WHERE id=#{id}")
    void addSupportCount(@Param("id") Long CommentId);

    /**
     * 增加评论数量
     * @param CommentId
     */
    @Select("UPDATE ch_comment SET comment_count=comment_count+1 WHERE id=#{id}")
    void addCommentCount(@Param("id") Long CommentId);
}
