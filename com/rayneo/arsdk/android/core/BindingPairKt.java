package com.rayneo.arsdk.android.core;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a,\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\f"},
   d2 = {"make3DEffect", "", "leftView", "Landroid/view/View;", "rightView", "enable", "", "parallax", "", "make3DEffectForSide", "view", "isLeft", "MercurySDK_release"}
)
public final class BindingPairKt {
   public static final void make3DEffect(View leftView, View rightView, boolean enable, float parallax) {
      Intrinsics.checkNotNullParameter(leftView, "leftView");
      Intrinsics.checkNotNullParameter(rightView, "rightView");
      if (enable) {
         leftView.setTranslationX(parallax);
         rightView.setTranslationX(-parallax);
      } else {
         rightView.setTranslationX(0.0F);
         leftView.setTranslationX(0.0F);
      }

   }

   // $FF: synthetic method
   public static void make3DEffect$default(View var0, View var1, boolean var2, float var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var2 = true;
      }

      if ((var4 & 8) != 0) {
         var3 = 3.0F;
      }

      make3DEffect(var0, var1, var2, var3);
   }

   public static final void make3DEffectForSide(View view, boolean isLeft, boolean enable, float parallax) {
      Intrinsics.checkNotNullParameter(view, "view");
      if (enable) {
         if (!isLeft) {
            parallax = -parallax;
         }
      } else {
         parallax = 0.0F;
      }

      view.setTranslationX(parallax);
   }

   // $FF: synthetic method
   public static void make3DEffectForSide$default(View var0, boolean var1, boolean var2, float var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var2 = true;
      }

      if ((var4 & 8) != 0) {
         var3 = 3.0F;
      }

      make3DEffectForSide(var0, var1, var2, var3);
   }

   public static final void make3DEffect(View leftView, View rightView, boolean enable) {
      Intrinsics.checkNotNullParameter(leftView, "leftView");
      Intrinsics.checkNotNullParameter(rightView, "rightView");
      make3DEffect$default(leftView, rightView, enable, 0.0F, 8, (Object)null);
   }

   public static final void make3DEffect(View leftView, View rightView) {
      Intrinsics.checkNotNullParameter(leftView, "leftView");
      Intrinsics.checkNotNullParameter(rightView, "rightView");
      make3DEffect$default(leftView, rightView, false, 0.0F, 12, (Object)null);
   }

   public static final void make3DEffectForSide(View view, boolean isLeft, boolean enable) {
      Intrinsics.checkNotNullParameter(view, "view");
      make3DEffectForSide$default(view, isLeft, enable, 0.0F, 8, (Object)null);
   }

   public static final void make3DEffectForSide(View view, boolean isLeft) {
      Intrinsics.checkNotNullParameter(view, "view");
      make3DEffectForSide$default(view, isLeft, false, 0.0F, 12, (Object)null);
   }
}
