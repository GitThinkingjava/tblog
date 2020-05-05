package com.tao.blog.s.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 生成随机 uuid
 * 
 * @author tao
 *
 */
public class UUIDUtil {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static String getUUID32() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < 10000; i++) {
			set.add(UUIDUtil.getUUID());
		}
		System.out.println(getUUID32());

	}
}
