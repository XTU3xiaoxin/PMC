package com.bcs.tja.utils;

import java.util.UUID;

public class UUIDGenerator {
	
	public static String getId() {
		 String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		    return uuid;
	}

}
