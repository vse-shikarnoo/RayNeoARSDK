package com.ffalconxr.mercury.ipc;

import android.content.Context;
import com.ffalconxr.mercury.ipc.helpers.RequestHelper;

public class TopPackageHelper {
   public static final String ACTION_TOP_PACKAGE = "top_package";
   public static final String ACTION_ADD_TOP_PACKAGE = "add_top_package";
   public static final String ACTION_REMOVE_TOP_PACKAGE = "remove_top_package";

   public static void addTopPackage(Context var0) {
      try {
         RequestHelper.request(var0, "add_top_package");
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }

   public static void removeTopPackage(Context var0) {
      try {
         RequestHelper.request(var0, "remove_top_package");
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }
}
