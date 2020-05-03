package com.demoapp.util;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class TokenUtil {
	
	public static String generateToken() {
		String ts = String.valueOf(System.currentTimeMillis());
	    String rand = UUID.randomUUID().toString();
	   
	    return DigestUtils.sha1Hex(ts + rand);
	}

}
