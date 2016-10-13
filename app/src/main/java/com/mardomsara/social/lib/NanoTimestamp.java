package com.mardomsara.social.lib;

import java.text.SimpleDateFormat;

/**
 * Class to generate timestamps with microsecond precision
 * For example: MicroTimestamp.INSTANCE.get() = "2012-10-21 19:13:45.267128"
 */ 
public class NanoTimestamp {
   static NanoTimestamp INSTANCE = new NanoTimestamp() ;

   private long startMillis;
   private long              startNanoseconds ;
   private SimpleDateFormat dateFormat ;

   private NanoTimestamp()
   {  this.startMillis = System.currentTimeMillis() ;
      this.startNanoseconds = System.nanoTime() ;
      this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") ;
   }

   //old for microscond
   private String get() {
      long microSeconds = (System.nanoTime() - this.startNanoseconds) / 1000 ;
      long date = this.startMillis + (microSeconds/1000) ;
      return this.dateFormat.format(date) + String.format("%03d", microSeconds % 1000) ;
   }

   final long MILI_TO_NANO = 1000000;
   private long getNano1() {
      long nanoSeconds = (System.nanoTime() - this.startNanoseconds)  ;
      long date = (System.currentTimeMillis() * MILI_TO_NANO+ (nanoSeconds%MILI_TO_NANO)) ; //1000000 : microseovd 3 + nansecond 3 digit
//      Long.getLong("this.startMillis)
      return date;
   }

   public static long getNano() {
      return INSTANCE.getNano1();
   }
}