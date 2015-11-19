package com.ming.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.greedc.wy.sys.model.SysResource;
//import com.greedc.wy.sys.model.SysUser;
//import com.greedc.wy.sys.model.UserStatus;

public class ShiroDbRealm extends AuthorizingRealm {
	
	private static final Logger log = LoggerFactory.getLogger(ShiroDbRealm.class);

	@Override
	public void setCacheManager(CacheManager cacheManager) {
		super.setCacheManager(cacheManager);
		ShiroCache.setCacheManager(cacheManager);
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		SysUser user = SysUser.getByAccount(token.getUsername());
//
//		if (user == null)
//			throw new UnknownAccountException();// 没找到帐号
//		if (user.getUserStatus() == UserStatus.Locked) {
//			throw new LockedAccountException("User '" + token.getUsername() + "' has bean locked");
//		} else {
//			return new SimpleAuthenticationInfo(user.getStr("account"), user.getStr("password"), getName());
//		}
	    return null;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String loginName = (String) principals.fromRealm(getName()).iterator().next();
//		SysUser user = SysUser.getByAccount(loginName);
//		if (user == null) {
//			return null;
//		}
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addRoles(user.getRoleIdList());
//		for (String role : info.getRoles()) {
//			List<String> resourcelist = SysResource.findResourcePatternByRole(role);
//			info.addStringPermissions(resourcelist);
//		}
//		log.debug("info: {}",info);
//		return info;
	    return null;
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());

		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();

		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
}
