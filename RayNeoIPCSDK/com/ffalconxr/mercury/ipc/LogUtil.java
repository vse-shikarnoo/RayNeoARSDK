package com.ffalconxr.mercury.ipc;

import android.util.Log;

public class LogUtil {
   private static boolean enableLog;

   public static void disableLog() {
      enableLog = false;
   }

   public static void enableLog() {
      enableLog = true;
   }

   public static void e(String var0, String var1) {
      if (enableLog) {
         Log.e(var0, var1);
      }

   }

   public static void w(String var0, String var1) {
      if (enableLog) {
         Log.w(var0, var1);
      }

   }

   public static void d(String var0, String var1) {
      if (enableLog) {
         Log.d(var0, var1);
      }

   }

   public static void i(String var0, String var1) {
      if (enableLog) {
         Log.i(var0, var1);
      }

   }
}
