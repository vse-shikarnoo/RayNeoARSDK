package com.rayneo.arsdk.android.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u001a\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J&\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0014\u0010\u0015\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0007J\u0006\u0010\u001d\u001a\u00020\u0013J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u001a\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "},
   d2 = {"Lcom/rayneo/arsdk/android/util/FLogger;", "", "()V", "DEBUG", "", "ERROR", "INFO", "TAG", "", "VERBOSE", "WARN", "<set-?>", "", "isDebug", "()Z", "createLog", "tag", "log", "d", "", "msg", "e", "t", "", "format", "level", "i", "printLog", "printStack", "updateLogSwitch", "v", "w", "MercurySDK_release"}
)
public final class FLogger {
   public static final FLogger INSTANCE = new FLogger();
   private static final String TAG = "MercurySDK";
   private static boolean isDebug = Log.isLoggable("MercurySDK", 3);
   private static final int VERBOSE = 2;
   private static final int DEBUG = 3;
   private static final int INFO = 4;
   private static final int WARN = 5;
   private static final int ERROR = 6;

   private FLogger() {
   }

   @JvmStatic
   public static final void v(String tag, String msg) {
      Intrinsics.checkNotNullParameter(tag, "tag");
      Intrinsics.checkNotNullParameter(msg, "msg");
      FLogger var2 = INSTANCE;
      if (isDebug) {
         var2.format(2, var2.createLog(tag, msg));
      }

   }

   @JvmStatic
   public static final void v(String msg) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      v("", msg);
   }

   @JvmStatic
   public static final void i(String tag, String msg) {
      Intrinsics.checkNotNullParameter(tag, "tag");
      Intrinsics.checkNotNullParameter(msg, "msg");
      FLogger var2 = INSTANCE;
      if (isDebug) {
         var2.format(4, var2.createLog(tag, msg));
      }

   }

   @JvmStatic
   public static final void i(String msg) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      i("", msg);
   }

   @JvmStatic
   public static final void w(String tag, String msg) {
      Intrinsics.checkNotNullParameter(tag, "tag");
      Intrinsics.checkNotNullParameter(msg, "msg");
      FLogger var2 = INSTANCE;
      if (isDebug) {
         var2.printLog(5, var2.createLog(tag, msg));
      }

   }

   // $FF: synthetic method
   public static void w$default(String var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var0 = "";
      }

      w(var0, var1);
   }

   @JvmStatic
   public static final void w(String msg) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      w("", msg);
   }

   @JvmStatic
   public static final void d(String tag, String msg) {
      Intrinsics.checkNotNullParameter(tag, "tag");
      Intrinsics.checkNotNullParameter(msg, "msg");
      FLogger var2 = INSTANCE;
      if (isDebug) {
         var2.format(3, var2.createLog(tag, msg));
      }

   }

   // $FF: synthetic method
   public static void d$default(String var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var0 = "";
      }

      d(var0, var1);
   }

   @JvmStatic
   public static final void d(String msg) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      d("", msg);
   }

   @JvmStatic
   public static final void e(String tag, String msg, Throwable t) {
      Intrinsics.checkNotNullParameter(tag, "tag");
      Intrinsics.checkNotNullParameter(msg, "msg");
      FLogger var3 = INSTANCE;
      if (isDebug) {
         String t1;
         String var10000 = t1 = Log.getStackTraceString(t);
         Intrinsics.checkNotNullExpressionValue(var10000, "getStackTraceString(t)");
         if (var10000.length() == 0) {
            t1 = "";
         } else {
            t1 = "\n " + t1;
         }

         StringBuilder var4;
         StringBuilder var10001 = var4 = new StringBuilder;
         var4.<init>();
         var3.printLog(6, var10001.append(var3.createLog(tag, msg)).append(' ').append(t1).toString());
      }

   }

   // $FF: synthetic method
   public static void e$default(String var0, String var1, Throwable var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var0 = "";
      }

      if ((var3 & 4) != 0) {
         var2 = null;
      }

      e(var0, var1, var2);
   }

   @JvmStatic
   public static final void e(String msg) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      e$default("", msg, (Throwable)null, 4, (Object)null);
   }

   @JvmStatic
   public static final void e(Throwable t) {
      FLogger var1 = INSTANCE;
      if (isDebug) {
         String t1;
         Intrinsics.checkNotNullExpressionValue(t1 = Log.getStackTraceString(t), "getStackTraceString(t)");
         var1.printLog(6, "error: " + t1);
      }

   }

   // $FF: synthetic method
   public static void e$default(Throwable var0, int var1, Object var2) {
      if ((var1 & 1) != 0) {
         var0 = null;
      }

      e(var0);
   }

   private final void printLog(int level, String msg) {
      switch(level) {
      case 2:
         Log.v("MercurySDK", msg);
         break;
      case 3:
         Log.d("MercurySDK", msg);
         break;
      case 4:
         Log.i("MercurySDK", msg);
         break;
      case 5:
         Log.w("MercurySDK", msg);
         break;
      case 6:
         Log.e("MercurySDK", msg);
      }

   }

   private final String createLog(String tag, String log) {
      StackTraceElement[] var8;
      StackTraceElement[] var10000 = var8 = Thread.currentThread().getStackTrace();
      Intrinsics.checkNotNullExpressionValue(var10000, "currentThread().stackTrace");
      ArrayList var3;
      var3 = new ArrayList.<init>();
      int var4 = 0;

      int var5;
      for(var5 = var10000.length; var4 < var5; ++var4) {
         StackTraceElement var6;
         if (!TextUtils.equals((var6 = var8[var4]).getClassName(), "dalvik.system.VMStack") && !TextUtils.equals(var6.getClassName(), "java.lang.Thread") && !TextUtils.equals(var6.getClassName(), "com.rayneo.arsdk.android.util.FLogger")) {
            var3.add(var6);
         }
      }

      StackTraceElement var10001 = (StackTraceElement)CollectionsKt.first(var3);
      String var10004 = var10001.getClassName();
      Intrinsics.checkNotNullExpressionValue(var10004, "fullClassName");
      String var9;
      Intrinsics.checkNotNullExpressionValue(var9 = var10004.substring(StringsKt.lastIndexOf$default(var10004, ".", 0, false, 6, (Object)null) + 1), "this as java.lang.String).substring(startIndex)");
      String var10 = var10001.getMethodName();
      String var11 = var10001.getFileName();
      var5 = var10001.getLineNumber();
      StringBuilder var12;
      var12 = new StringBuilder.<init>();
      if (!TextUtils.isEmpty(tag) && !TextUtils.equals(tag, var9)) {
         var12.append(tag + "=>>");
      }

      var12.append("at[" + var9 + '.' + var10 + '(' + var11 + ':' + var5 + ")]>> " + log);
      String var13 = var12.toString();
      Intrinsics.checkNotNullExpressionValue(var13, "buffer.toString()");
      return var13;
   }

   private final void format(int level, String msg) {
      int var4;
      if (msg.length() > 4000) {
         for(int var3 = 0; var3 < msg.length(); var3 = var4) {
            String var5;
            if ((var4 = var3 + 4000) < msg.length()) {
               Intrinsics.checkNotNullExpressionValue(var5 = msg.substring(var3, var4), "this as java.lang.String…ing(startIndex, endIndex)");
               this.printLog(level, var5);
            } else {
               Intrinsics.checkNotNullExpressionValue(var5 = msg.substring(var3), "this as java.lang.String).substring(startIndex)");
               this.printLog(level, var5);
            }
         }
      } else {
         this.printLog(level, msg);
      }

   }

   @JvmStatic
   public static final void printStack() {
      if (isDebug) {
         Exception var0;
         var0 = new Exception.<init>();
         Log.e("MercurySDK", "调用堆栈", var0);
      }

   }

   @JvmStatic
   public static final void e() {
      e$default((Throwable)null, 1, (Object)null);
   }

   public final boolean isDebug() {
      return isDebug;
   }

   public final void updateLogSwitch() {
      isDebug = Log.isLoggable("MercurySDK", 3);
   }
}
