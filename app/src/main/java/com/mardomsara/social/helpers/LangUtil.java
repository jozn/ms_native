package com.mardomsara.social.helpers;

import android.util.Patterns;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Hamid on 5/9/2016.
 */
public class LangUtil {

    public static <K,V> Map listToHashMap(List<V> list, KeyGen<K,V> keyGen){
        Map<K,V> map = new HashMap<>();
        for (V val : list){
            map.put(keyGen.gen(val),val);
        }
        return map;
    }

    public static String limitText(String txt, int maxSize){
        if(txt == null) return "";
        int len = txt.length();
        if(len>maxSize){
            return txt.substring(0,maxSize);
        }else {
            return txt.substring(0,len);
        }
    }

    public interface  KeyGen<K,V> {
        public K gen(V val);
    }
    /**
     * get random number from your boundary
     *
     * @param number max number till you want get random.
     * @return random number
     */
    public static int getRandom(int number) {
        Random rand = new Random();
        return rand.nextInt(number);
    }

    public static long getRandomLong(long number) {
        Random rand = new Random();
        return (long)(rand.nextDouble()*number);
    }


    /**
     * make arraylist from "," separated string
     *
     * @param string "," separated string
     * @return array list
     */
    public static ArrayList<String> stringToArrayList(String string) {
        ArrayList<String> strValueList = new ArrayList<String>(
                Arrays.asList(string.split(",")));
        return strValueList;
    }

	public static int stringToInt(String s,int defult){
		try {
			defult = NumberUtils.createInteger(s);
		}catch (Exception e){
			e.printStackTrace();
		}
		return defult;
	}

    /**
     * convert array list to "," separated string
     *
     * @param list array list
     * @return "," separated string
     */
    public static String arrayListToString(ArrayList<String> list) {
        String strValue = null;
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + ",");
            strValue = sb.toString();
        }

        if (strValue.length() > 0
                && strValue.charAt(strValue.length() - 1) == ',') {
            strValue = strValue.substring(0, strValue.length() - 1);
        }
        return strValue;
    }

    public static boolean isWebsiteUrlValid(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }

    public static char getRandomCharacter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');

        return c;
    }

    static String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String getRandomString(int size) {
        StringBuffer sb = new StringBuffer(size);
        for (int i =0;i<size;i++){
            sb.append(letters.charAt(getRandom(letters.length())));
        }
        return sb.toString();
    }

    public static String beautyHexString(String hexString) {
        if (hexString.length() < 2) {
            return "0".concat(hexString);
        } else {
            return hexString;
        }
    }
}
