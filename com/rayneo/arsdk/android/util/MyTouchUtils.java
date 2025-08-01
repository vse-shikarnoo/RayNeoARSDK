package com.rayneo.arsdk.android.util;

import android.app.ActivityManager;
import android.view.InputEvent;
import android.view.MotionEvent;

public class MyTouchUtils {
   public static final String LEFT_NAME = "iqs7211a";
   public static final String RIGHT_NAME = "iqs7211b";
   public static final String VIRTUAL_NAME = "Virtual";

   public static boolean isRight(InputEvent event) {
      if (isMonkey()) {
         return ((MotionEvent)event).getY() == 300.0F;
      } else {
         return event.getDevice() == null ? true : event.getDevice().getName().equals("iqs7211a") ^ true;
      }
   }

   public static boolean isMonkey() {
      boolean var10000 = ActivityManager.isUserAMonkey();
      FLogger.d("MyTouchUtils === isMonkey =" + var10000);
      return var10000;
   }

   public static boolean isLeft(InputEvent event) {
      if (isMonkey()) {
         return ((MotionEvent)event).getY() == 400.0F;
      } else {
         return event.getDevice() == null ? false : event.getDevice().getName().equals("iqs7211a");
      }
   }

   public static boolean isVirtual(InputEvent event) {
      return event.getDevice().getName().equals("Virtual");
   }
}
