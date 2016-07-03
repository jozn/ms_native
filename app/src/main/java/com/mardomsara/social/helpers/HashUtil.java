package com.mardomsara.social.helpers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Hamid on 7/2/2016.
 */
public class HashUtil {
    public static String toMD5(byte[] input){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] byteData = md.digest(input);
        return toHex(byteData);
    }



    public static String toSha256(byte[] input){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] byteData = md.digest(input);
        return toHex(byteData);
    }

    static String toHex(byte[] digested){
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<digested.length;i++) {
            String hex=Integer.toHexString(0xff & digested[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
