package com.bcs.tja.utils;

import org.apache.ibatis.jdbc.SQL;

public class SQLGenerator {

	public static void main(String[] args) {
		final String username = "xiaoxin";
		
		String s = new SQL() {
			{
				SELECT ("u.username,u.password,u.age");
				FROM("USER u");
				if(username != null) {
					WHERE("u.username=#{username}");
				}
			}
		}.toString();
		
		System.out.println(s);
	}
}
