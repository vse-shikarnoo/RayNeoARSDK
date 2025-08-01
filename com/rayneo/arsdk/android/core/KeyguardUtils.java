package com.rayneo.arsdk.android.core;

import kotlin.Metadata;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"},
   d2 = {"Lcom/rayneo/arsdk/android/core/KeyguardUtils;", "", "()V", "SCREEN_OFF", "", "SCREEN_ON", "USER_PRESENT", "state", "getState", "()I", "setState", "(I)V", "MercurySDK_release"}
)
public final class KeyguardUtils {
   public static final KeyguardUtils INSTANCE = new KeyguardUtils();
   public static final int SCREEN_ON = 0;
   public static final int SCREEN_OFF = 1;
   public static final int USER_PRESENT = 2;
   private static int state = 2;

   private KeyguardUtils() {
   }

   public final int getState() {
      return state;
   }

   public final void setState(int var1) {
      state = var1;
   }
}
