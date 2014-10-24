package com.blog.common.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 登录上下文
 * @author kongqingyu
 * @Time 2013-4-1 下午4:34:59
 */

public class LoginContext {
	
    private final static ThreadLocal<LoginContext> holder = new ThreadLocal<LoginContext>();

    private final static Log log = LogFactory.getLog(LoginContext.class);


    /**
     * 用户ID
     */
    private long userId;
    
    /**
     * 登录名称
     */
    private String userName;


	/**
     * 昵称
     */
    private String nick;
    
	/**
     * passport cookie的checksum
     */
    private int checksum;
    /**
     * 创建时间 默认为当前时间
     */
    private long created = System.currentTimeMillis();
    /**
     * 过期时间 如果没有指定，就使用拦截器默认的
     */
    private long expires;

	/**
     * 是否持久化
     */
    private boolean persistent;

    /**
     * 实际上是将loginContext放到了actionContext中
     * 
     * @param loginContext
     *            对象
     */
    public static void setLoginContext(LoginContext loginContext) {
        holder.set(loginContext);
    }

    /**
     * 取出登录的上下文
     * 
     * @return null 如果没有的话
     */
    public static LoginContext getLoginContext() {
        return holder.get();
    }

    /**
     * 删除上下文、其实一般不用删除
     */
    public static void remove() {
        holder.remove();
    }
    
    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	 public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getChecksum() {
		return checksum;
	}

	public void setChecksum(int checksum) {
		this.checksum = checksum;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public boolean isPersistent() {
		return persistent;
	}

	public void setPersistent(boolean persistent) {
		this.persistent = persistent;
	}


}