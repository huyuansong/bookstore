package cn.synu.test;

import org.junit.Test;

import cn.synu.utils.PasswordUtils;

public class MyTest {
	@Test
	public void aaa(){
		String name = "张三";
		String pwd = "7777777";
		pwd = PasswordUtils.encodePassword(name, pwd);
		System.err.println(pwd);
	}
}
