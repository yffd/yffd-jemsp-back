package com.yffd.jemsp.module.support.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 函数工具类：加密、解密
 */
public class MyEncryptUtils {

    /**
     * 私有构造方法,将该工具类设为单例模式.
     */
    private MyEncryptUtils() {
    }

    /**
     * encodeMD5String:用MD5算法进行加密. <br/>
     * @param str       需要加密的字符串
     * @return          MD5加密后的结果
     */
    public static String encodeMD5String(String str) {
        return encode(str, "MD5");
    }

    /**
     * encodeSHAString:用SHA算法进行加密. <br/>
     * @param str       需要加密的字符串
     * @return          SHA加密后的结果
     */
    public static String encodeSHAString(String str) {
        return encode(str, "SHA");
    }

    /**
     * encodeBase64String:用base64算法进行加密. <br/>
     * @param str       需要加密的字符串
     * @return          base64加密后的结果
     */
    public static String encodeBase64String(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(str.getBytes());
    }

    /**
     * decodeBase64String:用base64算法进行解密. <br/>
     * @param str           需要解密的字符串
     * @return              base64解密后的结果
     * @throws IOException
     */
    public static String decodeBase64String(String str) throws IOException {
        BASE64Decoder encoder = new BASE64Decoder();
        return new String(encoder.decodeBuffer(str));
    }

    private static String encode(String str, String method) {
        MessageDigest mdInst = null;
        // 把密文转换成十六进制的字符串形式
        StringBuilder dstr = new StringBuilder();
        try {
            // 获得摘要算法的 MessageDigest对象
            mdInst = MessageDigest.getInstance(method);
            // 使用指定的字节更新摘要
            mdInst.update(str.getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            for (int i = 0; i < md.length; i++) {
                int tmp = md[i];
                if (tmp < 0) {
                    tmp += 256;
                }
                if (tmp < 16) {
                    dstr.append("0");
                }
                dstr.append(Integer.toHexString(tmp));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(method + " 算法不合法", e);
        }
        return dstr.toString();
    }
    
    public static void main(String[] args) {
		String str = "1";
		String sha = MyEncryptUtils.encodeSHAString(str);
		System.out.println(sha);
		System.out.println(sha.length());
		
		String md5 = MyEncryptUtils.encodeMD5String(str);
		System.out.println(md5);
		System.out.println(md5.length());
	}
}

