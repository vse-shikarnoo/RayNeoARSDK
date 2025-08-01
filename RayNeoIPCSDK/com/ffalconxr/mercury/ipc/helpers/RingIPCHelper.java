package com.ffalconxr.mercury.ipc.helpers;

import android.content.Context;
import org.json.JSONObject;

public class RingIPCHelper {
   private static final String TAG = "RingIPCHelper";
   public static final String ACTION_RING_INFO_REGISTER = "register_ring_info";
   public static final String ACTION_RING_INFO_UNREGISTER = "unregister_ring_info";
   public static final String ACTION_RING_ABLE_IMU = "able_ring_imu";
   public static final String ACTION_RING_ENABLE_IMU = "enable_ring_imu";
   public static final String ACTION_RING_DISABLE_IMU = "disable_ring_imu";
   public static final String ACTION_RING_SEND_LOGIN_QR = "send_login_qr";
   public static final String ACTION_RING_LONG_CLICK_ABLE = "able_ring_long_click";
   public static final String ACTION_RING_LONG_CLICK_DISABLE = "disable_ring_long_click";
   public static final String ACTION_RING_LONG_CLICK_ENABLE = "enable_ring_long_click";
   public static final String ACTION_RING_SEPARATE_BUTTON = "separate_button";
   public static final String ACTION_RING_NOT_SEPARATE_BUTTON = "notseparate_button";
   public static final String DATA_TYPE_KEY = "datatype";
   public static final String DATA_TYPE_RING_QUATERNION = "ring_quaternion";
   public static final String DATA_TYPE_RING_INFO = "ring_info";
   public static final String RING_CONNECTED_KEY = "ring_connected";
   public static final String RING_IMU_STATUS_KEY = "ring_imu_status";
   public static final String RING_ACTION_KEY = "action";

   public static void registerRingInfo(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static void unRegisterRingInfo(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static void sendLoginQRCode(Context var0, String var1) {
      Exception var10000;
      label31: {
         boolean var10001;
         JSONObject var10002;
         Context var5;
         JSONObject var6;
         try {
            var5 = var0;
            var6 = new JSONObject;
            var10002 = var6;
            var6.<init>();
            var6.put("action", "send_login_qr");
         } catch (Exception var4) {
            var10000 = var4;
            var10001 = false;
            break label31;
         }

         try {
            var10002.put("qr", var1);
         } catch (Exception var3) {
            var10000 = var3;
            var10001 = false;
            break label31;
         }

         try {
            RequestHelper.request(var5, var6.toString());
            return;
         } catch (Exception var2) {
            var10000 = var2;
            var10001 = false;
         }
      }

      var10000.printStackTrace();
   }

   public static void setRingIMU(Context param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public static void setRingLongClick(Context param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public static void setRingSeparateButton(Context param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }
}
