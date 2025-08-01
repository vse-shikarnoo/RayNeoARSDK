package com.rayneo.arsdk.android.core;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.rayneo.arsdk.android.util.FLogger;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0019*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0019B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J=\u0010\u000b\u001a\u00020\f\"\b\b\u0001\u0010\u0001*\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000f\"\u0002H\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\f2\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\u0002\b\u0018R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lcom/rayneo/arsdk/android/core/BindingPair;", "T", "Landroidx/viewbinding/ViewBinding;", "Lcom/rayneo/arsdk/android/core/BaseMirrorAction;", "left", "right", "(Landroidx/viewbinding/ViewBinding;Landroidx/viewbinding/ViewBinding;)V", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "enable3DEffect", "", "Landroid/view/View;", "leftViews", "", "enable", "", "parallax", "", "([Landroid/view/View;ZF)V", "updateView", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Companion", "MercurySDK_release"}
)
public final class BindingPair<T extends ViewBinding> extends BaseMirrorAction<T> {
   public static final BindingPair.Companion Companion = new BindingPair.Companion((DefaultConstructorMarker)null);
   public static final float PARALLAX = 3.0F;
   private final HashMap<Object, Object> map;

   public BindingPair(T left, T right) {
      Intrinsics.checkNotNullParameter(left, "left");
      Intrinsics.checkNotNullParameter(right, "right");
      super(left, right);
      this.map = new HashMap();
      Field[] var3;
      Field[] var10000 = var3 = left.getClass().getDeclaredFields();
      Intrinsics.checkNotNullExpressionValue(var10000, "fields");
      int var4 = 0;

      for(int var5 = var10000.length; var4 < var5; ++var4) {
         Field var6;
         (var6 = var3[var4]).setAccessible(true);
         HashMap var8 = this.map;
         Object var9;
         Intrinsics.checkNotNullExpressionValue(var9 = var6.get(left), "field.get(left)");
         Object var7 = var6.get(right);
         Intrinsics.checkNotNullExpressionValue(var7, "field.get(right)");
         var8.put(var9, var7);
      }

   }

   // $FF: synthetic method
   public static void enable3DEffect$default(BindingPair var0, View[] var1, boolean var2, float var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = true;
      }

      if ((var4 & 4) != 0) {
         var3 = 3.0F;
      }

      var0.enable3DEffect(var1, var2, var3);
   }

   public final <T extends View> void enable3DEffect(T[] leftViews, boolean enable, float parallax) {
      Intrinsics.checkNotNullParameter(leftViews, "leftViews");
      int var4 = 0;

      for(int var5 = leftViews.length; var4 < var5; ++var4) {
         View var6;
         View var10000 = var6 = leftViews[var4];
         Object var10001 = this.map.get(var6);
         FLogger.i("BindingPair", "enable3DEffect1 left: " + var6 + ",right: " + var10001 + ' ');
         Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type T of com.rayneo.arsdk.android.core.BindingPair.enable3DEffect$lambda-1");
         BindingPairKt.make3DEffect(var10000, (View)var10001, enable, parallax);
      }

   }

   public final void updateView(Function1<? super T, Unit> block) {
      Intrinsics.checkNotNullParameter(block, "block");
      this.update(block);
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"},
      d2 = {"Lcom/rayneo/arsdk/android/core/BindingPair$Companion;", "", "()V", "PARALLAX", "", "MercurySDK_release"}
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
