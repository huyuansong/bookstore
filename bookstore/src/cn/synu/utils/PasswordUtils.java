package cn.synu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class PasswordUtils {
	public static String encodePassword(String userName,String password){
		//声明加密以后密码值
		String pwd = "";
		try {
			int nameHash = userName.hashCode();//用户名的hash值
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bs= md.digest(password.getBytes());
			for(byte b:bs){
				int res = b+nameHash;
				int a = res & 0xff;
				if(a<16){
					a+=16;
				}
				String hex = Integer.toHexString(a);
				pwd+=hex;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}
	
	
	
	

	/**
	 * 以下只是基本算法
	 * 对于相同 的密码加密以后值也一样
	 * 32位
	 * e11adc3949ba59abbe56e057f21f883e
	 * e11adc3949ba59abbe56e057f21f883e
	 */
	@Test
	public void encode() throws Exception{
		String pwd="123456";
		//声明加密算法类
		MessageDigest md = MessageDigest.getInstance("MD5");
		//返回加密以后字节娄组
		byte[] bs= md.digest(pwd.getBytes());
		//并输出固定长度的哈希值
		//System.err.println(bs.length);
		String password = "";
		for(byte b:bs){
			System.err.println(b);//-127~128
			String hex = Integer.toHexString(b);
			System.err.println(hex);
			int a = b & 0xff;
			if(a<16){
				a+=16;
			}
			String hex2 = Integer.toHexString(a);
			password+=hex2;
			System.err.println(hex2);
			System.err.println("----");
		}
		System.err.println("====================");
		System.err.println("密码为:"+password);
		
	}
	/**
	 * 由于所有用户名都不相同
	 * 所以就用用户名的hash值，与密码的hash值进行加运算，对结果再进行取值
	 * e019db3848b958aabd55df56f11e873d
	 * 50794ba8b829c81a2dc54fc6617ef7ad
	 * 80db9ada51cf4cc1ff35dad7303dcf54
	 */
	@Test
	public void encode2() throws Exception{
		String name = "Jack";//盐值
		//根据name获取name的hash值
		int nameHash = name.hashCode();
		//以下是密码
		String pwd="1234";
		//声明加密算法类
		MessageDigest md = MessageDigest.getInstance("MD5");
		//返回加密以后字节娄组
		byte[] bs= md.digest(pwd.getBytes());
		//并输出固定长度的哈希值
		//System.err.println(bs.length);
		String password = "";
		for(byte b:bs){
			int res = b+nameHash;
			System.err.println(res);
			int a = res & 0xff;
			System.err.println(a);
			if(a<16){
				a+=16;
			}
			String hex = Integer.toHexString(a);
			System.err.println(hex);
			password+=hex;
			System.err.println("----");
		}
		System.err.println("====================");
		System.err.println("密码为:"+password);
		
	}
}
