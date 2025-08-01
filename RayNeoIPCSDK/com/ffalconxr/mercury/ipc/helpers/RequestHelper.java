package com.ffalconxr.mercury.ipc.helpers;

import android.content.Context;
import com.ffalconxr.mercury.ipc.Launcher;

public class RequestHelper {
   public static void request(Context var0, String var1) {
      Launcher var3;
      if (!(var3 = Launcher.getInstance(var0)).isReady()) {
         Launcher var10000 = var3;
         Launcher.OnConnectionStateListener[] var2;
         Launcher.OnConnectionStateListener[] var10001 = var2 = new Launcher.OnConnectionStateListener[1];
         Launcher.OnConnectionStateListener var4 = (var3x) -> {
            if (var3.isReady()) {
               var3.request(var1);
               var3.removeOnConnectionStateListener(var2[0]);
            }

         };
         var10001[0] = var4;
         var10000.addOnConnectionState(var4);
      } else {
         var3.request(var1);
      }

   }
}
