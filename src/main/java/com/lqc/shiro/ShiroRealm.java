package com.lqc.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.lqc.entity.User;
import com.lqc.service.UserService;

public class ShiroRealm extends AuthorizingRealm {
	
	@Resource(name = "userServiceImpl")
	private UserService userService;

	//用于认证的方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("ShiroRealm's AuthenticationInfo");
		
		//1.把AuthenticationToken转换为UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		
		//2.从UsernamePasswordToken中来获取username
		String mobile = upToken.getUsername();
		
		//3.调用数据库的方法，从数据库中查询username对应的用户记录
		User user = userService.findByMobile(mobile);
		
		//4.若用户不存在，则可以抛出UnknownAccountException异常
		if (user == null) {
			throw new UnknownAccountException("用户不存在！");
		}
		
		//5.根据用户信息的情况，决定是否要抛出AuthenticationException异常
		
		//6.根据用户的情况，来构建AuthenticationInfo对象并返回
		//1).principal（身份） : 即主体的标识属性，可以是任何东西，如用户名、邮箱等，唯一即可
		Object principal = mobile;//18826230693
		//2).credentials（证明 /凭证）: 即只有主体知道的安全值，如密码 / 数字证书等
		Object hashedCredentials = user.getPassword();//e38c083352dbca4f0257b5c2aeb1d7c2
		//3).realmName: 当前realm对象的name,调用父类的getName方法即可
		String realmName = getName();
		//4).盐值.
		ByteSource credentialsSalt = ByteSource.Util.bytes(mobile);
		AuthenticationInfo info = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
		return info;
	}
	
	public static void main(String[] args) {
		String algorithmName = "MD5";
		Object credentials = "123456";
		Object salt = ByteSource.Util.bytes("18826230693");
		System.out.println(salt);//MTg4MjYyMzA2OTM=
		int hashIterations = 1024;
		Object result = new SimpleHash(algorithmName, credentials, salt, hashIterations);
		System.out.println(result);//e38c083352dbca4f0257b5c2aeb1d7c2
	}

	//用于授权的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1.从PrincipalCollection中来获取登录用户的信息
		Object principal = principals.getPrimaryPrincipal();
		//2.利用登录的用户信息来获取当前用户的角色或权限（可能需要查询数据库）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//角色
		Set<String> roles = new HashSet<>();
		roles.add(String.valueOf(principal));
		info.addRoles(roles);
		//权限
		List<String> permissions = new ArrayList<>();
		permissions.add("user:add");
		info.addStringPermissions(permissions);
		return info;
	}

}
