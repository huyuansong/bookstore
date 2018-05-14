package cn.synu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 生成uuid时间
 * 
 * @author huyuansong
 * 
 */
public class BookStoreUtils {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String order(Object o) {
		return "" + o.hashCode();
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String date() {
		return sdf.format(new Date());
	}
}
