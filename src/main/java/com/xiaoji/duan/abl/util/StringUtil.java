package com.xiaoji.duan.abl.util;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Clob;
import java.sql.SQLException;

public class StringUtil {
    public static String stringToSha(String plainText,String format) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance(format).digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
    public static String toString(Object o) {
        if (o != null) {
            if (o instanceof Clob) {
                try {
                    return ClobToString((Clob) o);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            } else if(o instanceof JSONArray){
                JSONArray array = (JSONArray) o;
                if(array.size() > 0){
                    return toString(array.get(0));
                }
            }
            return o.toString();
        }
        return "";
    }

    public static String toString(Object o, int length) {
        String s = toString(o);
        if(s != null && s.length() > length){
            return s.substring(0, length);
        } else {
            return s;
        }
    }

    public static String addQuote(String s){
        return "\"" + s + "\"";
    }

    public static boolean isEmpty(String s){
        return s == null || s.trim().length() == 0;
    }

    public static String ClobToString(Clob clob) throws SQLException, IOException {

        String reString = "";
        Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING
            sb.append(s);
            s = br.readLine();
        }
        reString = sb.toString();
        return reString;
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
}

