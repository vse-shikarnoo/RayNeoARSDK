package com.ffalconxr.mercury.ipc.helpers;

import android.content.Context;

public class GPSIPCHelper {
   private static final String NAV_STREAM_PUSHING_START = "start_location_stream_pushing";
   private static final String NAV_STREAM_PUSHING_STOP = "stop_location_stream_pushing";

   public static void registerGPSInfo(Context var0) {
      try {
         RequestHelper.request(var0, "start_location_stream_pushing");
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }

   public static void unRegisterGPSInfo(Context var0) {
      try {
         RequestHelper.request(var0, "stop_location_stream_pushing");
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }
}
