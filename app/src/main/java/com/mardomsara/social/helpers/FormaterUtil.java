package com.mardomsara.social.helpers;

import com.mardomsara.social.app.Config;
import com.mardomsara.social.lib.PersianDateTime;
import com.mardomsara.social.models_old.AppModel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.annotation.Nullable;

/**
 * Created by Hamid on 5/9/2016.
 */
public class FormaterUtil {
	private static char halfSpace = '\u200A'
		;
    private static String[] suffix = new String[]{"", "k", "m", "b", "t"};
    private static int MAX_LENGTH = 5;

    /**
     * addStart post fix to any long digit like 10k for 10000
     *
     * @param args any digit
     * @return it will return "", "k", "m", "b", "t" with addStart post fix to digit.
     */
    public static String postFixForDigits(long args/* , TextView mTextView */) {
        long[] numbers = new long[]{args};
        long numb = 0;
        for (long number : numbers) {
            numb = number;
        }
        return format(numb);
    }

    private static String format(double number) {
        String r = new DecimalFormat("##0E0").format(number);
        r = r.replaceAll("E[0-9]",
                suffix[Character.getNumericValue(r.charAt(r.length() - 1)) / 3]);
        while (r.length() > MAX_LENGTH || r.matches("[0-9]+\\.[a-z]")) {
            r = r.substring(0, r.length() - 2) + r.substring(r.length() - 1);
        }
        return r;
    }

    static SimpleDateFormat dailyTime = new SimpleDateFormat("h:m");
    //returns "2:45 AM"
    public static String timeToClockTimeMs(long milisconds){
        Date d = new Date(milisconds);
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(milisconds);
        String format =dailyTime.format(d);// "2:44"
        if(cal.get(Calendar.HOUR_OF_DAY)<12){
//            format = format+"\u200Aق.ظ" ;
            format = format+"\u200Aق.ظ" ;
        }else {
            format = format+"ب.ظ ";
        }
         return format;
//        return DateFormat.getDateInstance().format(d);
    }

	public static String timeToClockTimeSec(long sec){
		return timeToClockTimeMs(sec*1000);
	}

    public static String timeToDayTime(long seconds){
        return timeToClockTimeMs(seconds*1000);
    }

    //returns "22 خرداد"
    public static String timeToMontlyDay(long milisconds) {
        Rooz r = Rooz.fromTimeMs(milisconds);
        return ""+r.getDay()+ " " + r.getMonthName();
    }

    public static String friendlyTimeClockOrDayMs(long milisconds) {
        long sec = milisconds/1000;
        long now = new Date().getTime()/1000;
        if(Math.abs(now-sec)< 86400){
              return timeToClockTimeMs(milisconds);
        }//else{
//        Rooz r = Rooz.fromTimeMs(milisconds);
		PersianDateTime pd  = PersianDateTime.valueOf(milisconds);
        return ""+pd.getDay()+ halfSpace + pd.getMonthName();
    }

    @Nullable
	public static String friendlyMsgSeprationTime(long thisMsgSec , long befoerSec) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeInMillis(thisMsgSec*1000);
		int dayMsg = calendar.get(Calendar.DAY_OF_YEAR);

		calendar.setTimeInMillis(befoerSec*1000);
		int dayOlder = calendar.get(Calendar.DAY_OF_YEAR);

		if(dayOlder !=  dayMsg){
			Date now = new Date();
			calendar.setTime(now);
			int dayToday = calendar.get(Calendar.DAY_OF_YEAR);
			if(Math.abs((now.getTime()/1000) - thisMsgSec) < 86400){
				if(dayToday ==  dayMsg){
					return "امروز";
				}
				return "دیروز";
			}
			return justDayAndMonth(thisMsgSec);
		}
		return null;
	}

    static String justDayAndMonth(long sec){
		PersianDateTime pd  = PersianDateTime.valueOf(((long)sec)*1000);
		return ""+pd.getDay()+ halfSpace + pd.getMonthName();
	}

    public static String fullyDayMonthYear(long milisconds){
       PersianDateTime pd  = PersianDateTime.valueOf(milisconds);
		String r = pd.getDay() + " " + pd.getMonthName()  + " " + pd.getYear();
        return r;
    }

	@Deprecated
	public static String timeJalaiDayMs_DEP(long milisconds){
		Date d = new Date(milisconds);
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(milisconds);
		Rooz rooz = new Rooz();
		rooz.gregorianToPersian(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));

		String r = rooz.getFormatedWithMonthName(" ");
		if(Config.IS_DEBUG) {
			AppUtil.log("date: Year: " + cal.get(Calendar.YEAR) + " Month: "+ cal.get(Calendar.MONTH)+ " Day: "+cal.get(Calendar.DAY_OF_MONTH) +  " Shamsi: "+ r);
		}
		return r;
	}
    //returns: "1395-4-25_17:05:24
    public static String getFullyYearToSecondsSolarName(){
        Date d = new Date();//1424123123000l);
        String rooz = Rooz.fromTimeMs(d.getTime()).getFormatedForFoldersName("-");
        String houersFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(d);
        String fileName = rooz + "_" + houersFormat ;
        return fileName;
    }

	public static String getFullyYearToSecondsSolarNameFrom(long miliSecond){
		Date d = new Date(miliSecond);//1424123123000l);
		String rooz = Rooz.fromTimeMs(d.getTime()).getFormatedForFoldersName("-");
		String houersFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(d);
		String fileName = rooz + "_" + houersFormat ;
		return fileName;
	}

	public static String timeAgo(long seconds){
		long diff = (AppModel.getRealGlobalTimestampMs()/1000) - seconds;
//		AppUtil.log("Time diff sec:" +diff);
		String res = "";
		if(diff < 1){
			res =  "همین لحظه";
		}else if(diff < 60*1){//60second
			res =  diff + " ثانیه قبل";
		}else if(diff < 60*60) {
			res =  (diff/60) + " دقیقه قبل";
		}else if (diff < 3600*24) {//1 day
			res = (diff/3600) + " ساعت قبل";
		}else{
			res =  friendlyTimeClockOrDayMs(seconds*1000);
		}

		return res.replace(' ',halfSpace);
	}

	public static String timeAgoWithDateForTooFar(long seconds){
		long diff = (AppModel.getRealGlobalTimestampMs()/1000) - seconds;
//		AppUtil.log("Time diff sec:" +diff);
		String res = "";
		if(diff < 1){
			res =  "همین لحظه";
		}else if(diff < 60*1){//60second
			res =  diff + " ثانیه قبل";
		}else if(diff < 60*60) {
			res =  (diff/60) + " دقیقه قبل";
		}else if (diff < 3600*24) {//1 day
			res = (diff/3600) + " ساعت قبل";
		}else if (diff < 3600*24*30) {//30 day
			res = (diff/(3600*24)) + " روز قبل";
		} else{
			res =  friendlyTimeClockOrDayMs(seconds*1000);
		}

		return res.replace(' ',halfSpace);
	}

	public static String play_FullyYeraMonthDayNow(long mili){
		Date d = new Date(mili);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(mili)
		;
		PersianDateTime pd = PersianDateTime.valueOf(mili);
		return pd.toDateString() ;
	}



    ///////////////////////////////////////////////
    ///////////// For Time Ago ///////////////////

//    public static String timeAgo(long milisconds){
//        return "";
//    }


}

/*
    public static String fullyDayMonthYear(long milisconds){
        Date d = new Date(milisconds);
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(milisconds);
        Rooz rooz = new Rooz();
//        rooz.gregorianToPersian(d.getYear(),d.getIndexMonth(),d.getDate());
        rooz.gregorianToPersian(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));

        int year,month,day;
        year = rooz.getYear();
        month= rooz.getIndexMonth()+1;//zero index
        day = rooz.getDay();
        return rooz.getFormatedWithMonthName(" ");

//        return ""  + rooz.getYear() + "/"+rooz.getIndexMonth()+"/"+rooz.getDay();
//        return "" + year + "/"+ rooz.getMonthName() +"/"+ day;
//        return rooz.toString();
    }
*/
