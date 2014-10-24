package com.blog.common.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 类说明：复写权限和登陆验证方法
 * @author kongqingyu
 * Email:cody1990@yeah.net
 * date:2013-7-16 下午3:26:27
 *
 */
public class CHRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(CHRealm.class);
	
    
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
	    Set<String> permissions = new HashSet<String>();
	    try {
	        //permissions =authorityClient.loadAuthorityUriFromRedis((String) principals.getPrimaryPrincipal());
	    } catch (Exception e) {
	        logger.error(e.getMessage(), e);
        }
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//基于Permission的权限信息
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		
		
		
		return new SimpleAuthenticationInfo(token.getUsername(), "", getName());
	}

}
