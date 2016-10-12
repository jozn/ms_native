package com.mardomsara.social.helpers;

import com.mardomsara.social.lib.NanoTimestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hamid on 5/9/2016.
 */
public class TimeUtil {

    public static long getTimeMs(){
        return new Date().getTime();
    }

    public static long getNormilizedTimeMs(){
        return new Date().getTime();
    }

    public static long getTime(){
        return (new Date().getTime())/1000;
    }

	public static int getTimeInt(){
		return (int) (new Date().getTime()/1000);
	}

    public static long getTimeU(){
        return System.nanoTime()/1000;
    }

    public static long getTimeNano(){
        return NanoTimestamp.getNano();
    }

    public static int timeMsToSec(long time){
        return (int) (time/1000);
    }

    /**
     * calculate difference form two dates Note: both dates are in same format.
     *
     * @param mDate1 date 1
     * @param mDate2 date 2
     * @return date difference in long
     */
    public static long calculateDays(Date mDate1, Date mDate2) {
        return Math.abs((mDate1.getTime() - mDate2.getTime()) / (24 * 60 * 60 * 1000) + 1);
    }

    /**
     * Convert date in string format to Date format
     *
     * @param strdate which you have to convert in Date format
     * @param format  of the date like "yyyy-MM-dd"
     * @return date in Date format
     */
    public static Date stringToDate(String strdate, String format) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            date = formatter.parse(strdate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

}
