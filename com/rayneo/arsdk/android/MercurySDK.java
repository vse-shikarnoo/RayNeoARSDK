package com.rayneo.arsdk.android;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"},
   d2 = {"Lcom/rayneo/arsdk/android/MercurySDK;", "", "()V", "<set-?>", "Landroid/app/Application;", "mApplication", "getMApplication", "()Landroid/app/Application;", "init", "", "application", "MercurySDK_release"}
)
public final class MercurySDK {
   public static final MercurySDK INSTANCE = new MercurySDK();
   private static Application mApplication;

   private MercurySDK() {
   }

   public final Application getMApplication() {
      Application var1;
      if ((var1 = mApplication) != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("mApplication");
         return null;
      }
   }

   public final void init(Application application) {
      Intrinsics.checkNotNullParameter(application, "application");
      mApplication = application;
   }
}
