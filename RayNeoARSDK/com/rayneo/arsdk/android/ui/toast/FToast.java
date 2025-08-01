package com.rayneo.arsdk.android.ui.toast;

import android.app.Application;
import android.widget.Toast;
import androidx.viewbinding.ViewBinding;
import com.rayneo.arsdk.android.MercurySDK;
import com.rayneo.arsdk.android.core.BindingPair;
import com.rayneo.arsdk.android.databinding.FfalconToastBinding;
import com.rayneo.arsdk.android.ext.ViewExtensionKt;
import com.rayneo.arsdk.android.ui.wiget.MirrorContainerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007J\\\u0010\u000e\u001a\u00020\u0006\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122\u001e\u0010\u0013\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u0014H\u0007J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/toast/FToast;", "", "()V", "mApp", "Landroid/app/Application;", "show", "", "msgResId", "", "short", "", "yOffset", "msg", "", "showCustom", "T", "Landroidx/viewbinding/ViewBinding;", "bindingClz", "Ljava/lang/Class;", "initViewBlock", "Lkotlin/Function2;", "Lcom/rayneo/arsdk/android/core/BindingPair;", "showToast", "toastView", "Lcom/rayneo/arsdk/android/ui/wiget/MirrorContainerView;", "MercurySDK_release"}
)
public final class FToast {
   public static final FToast INSTANCE = new FToast();
   private static final Application mApp;

   private FToast() {
   }

   // $FF: synthetic method
   public static void show$default(FToast var0, String var1, boolean var2, int var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = true;
      }

      if ((var4 & 4) != 0) {
         var3 = ViewExtensionKt.getDp(200);
      }

      var0.show(var1, var2, var3);
   }

   private final void showToast(MirrorContainerView toastView, boolean var2, int yOffset) {
      Toast var4;
      Toast var10000 = var4 = new Toast;
      var4.<init>(mApp);
      var4.setView(toastView);
      var10000.setDuration(var2 ^ 1);
      var10000.setGravity(55, 0, yOffset);
      var10000.show();
   }

   // $FF: synthetic method
   public static void show$default(FToast var0, int var1, boolean var2, int var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = true;
      }

      if ((var4 & 4) != 0) {
         var3 = ViewExtensionKt.getDp(200);
      }

      var0.show(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void showCustom$default(FToast var0, String var1, boolean var2, int var3, Class var4, Function2 var5, int var6, Object var7) {
      if ((var6 & 2) != 0) {
         var2 = true;
      }

      if ((var6 & 4) != 0) {
         var3 = ViewExtensionKt.getDp(200);
      }

      var0.showCustom(var1, var2, var3, var4, var5);
   }

   static {
      mApp = MercurySDK.INSTANCE.getMApplication();
   }

   public final void show(String msg, boolean var2, int yOffset) {
      FToast var10000 = this;
      Intrinsics.checkNotNullParameter(msg, "msg");
      <undefinedtype> var4 = null.INSTANCE;
      var10000.showCustom(msg, var2, yOffset, FfalconToastBinding.class, var4);
   }

   public final void show(int msgResId, boolean var2, int yOffset) {
      String var10001 = mApp.getString(msgResId);
      Intrinsics.checkNotNullExpressionValue(var10001, "mApp.getString(msgResId)");
      this.show(var10001, var2, yOffset);
   }

   public final <T extends ViewBinding> void showCustom(String msg, boolean var2, int yOffset, Class<T> bindingClz, Function2<? super BindingPair<T>, ? super String, Unit> initViewBlock) {
      FToast var10000 = this;
      Intrinsics.checkNotNullParameter(msg, "msg");
      Intrinsics.checkNotNullParameter(bindingClz, "bindingClz");
      Intrinsics.checkNotNullParameter(initViewBlock, "initViewBlock");
      MirrorContainerView var6;
      MirrorContainerView var10002 = var6 = new MirrorContainerView;
      var6.<init>(mApp);
      initViewBlock.invoke(var10002.bindTo(bindingClz), msg);
      var10000.showToast(var6, var2, yOffset);
   }

   public final void show(String msg, boolean var2) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      show$default(this, msg, var2, 0, 4, (Object)null);
   }

   public final void show(String msg) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      show$default(this, msg, false, 0, 6, (Object)null);
   }

   public final void show(int msgResId, boolean var2) {
      show$default(this, msgResId, var2, 0, 4, (Object)null);
   }

   public final void show(int msgResId) {
      show$default(this, msgResId, false, 0, 6, (Object)null);
   }

   public final <T extends ViewBinding> void showCustom(String msg, boolean var2, Class<T> bindingClz, Function2<? super BindingPair<T>, ? super String, Unit> initViewBlock) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      Intrinsics.checkNotNullParameter(bindingClz, "bindingClz");
      Intrinsics.checkNotNullParameter(initViewBlock, "initViewBlock");
      showCustom$default(this, msg, var2, 0, bindingClz, initViewBlock, 4, (Object)null);
   }

   public final <T extends ViewBinding> void showCustom(String msg, Class<T> bindingClz, Function2<? super BindingPair<T>, ? super String, Unit> initViewBlock) {
      Intrinsics.checkNotNullParameter(msg, "msg");
      Intrinsics.checkNotNullParameter(bindingClz, "bindingClz");
      Intrinsics.checkNotNullParameter(initViewBlock, "initViewBlock");
      showCustom$default(this, msg, false, 0, bindingClz, initViewBlock, 6, (Object)null);
   }
}
