package com.demoapp.util;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class TokenUtil {

	public static String generateToken() {
		String ts = String.valueOf(System.currentTimeMillis());
		String rand = UUID.randomUUID().toString();

		return DigestUtils.sha1Hex(ts + rand);
	}

	public static String generateUserCode() {

		StringBuilder sb = new StringBuilder("u");
		sb.append(DigestUtils.sha1Hex(String.valueOf(System.currentTimeMillis()) + UUID.randomUUID().toString())
				.substring(0, 10));
		return sb.toString();
	}

}
