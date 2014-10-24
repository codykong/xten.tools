package com.blog.common.utils;

import java.io.*;
import java.security.MessageDigest;

public class MD5 {

	/**
	 * Constructs the MD5 object and sets the string whose MD5 is to be
	 * computed.
	 * 
	 * @param inStr
	 *            the <code>String</code> whose MD5 is to be computed
	 */
	public MD5() {
	}
	
	/**
	 * Computes the MD5 fingerprint of a string.
	 * 
	 * @return the MD5 digest of the input <code>String</code>
	 */
	public static byte[] compute(String inStr) {
		if(inStr == null) return null;
		
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		return compute(byteArray);
	}
	
	public static byte[] compute(Object obj){
		ObjectOutputStream oos = null;
		byte[] obj_bytes = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			obj_bytes = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(oos != null){
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return compute(obj_bytes);
	}
	
	public static byte[] compute(byte[] byteArray){
		if(byteArray == null) return null;
		
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return null;
		}
		byte[] md5Bytes = md5.digest(byteArray);
		return md5Bytes;
	}
	
	/**
     * 
     * @param file
     * @return
	 * @throws Exception 
     */
	public static String getFileMD5(File file) throws Exception {
		FileInputStream fis = null;
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		fis = new FileInputStream(file);
		byte[] buffer = new byte[8192];
		int length = -1;
		while ((length = fis.read(buffer)) != -1) {
			md5.update(buffer, 0, length);
		}
		byte[] md5Bytes = md5.digest();

		StringBuilder hexValue = new StringBuilder();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
}
