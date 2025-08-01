package com.rayneo.arsdk.android.core;

import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u0013\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\u0002\b\u0019J\u001f\u0010\u001a\u001a\u00020\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\u0002\b\u0019J\u001f\u0010\u001b\u001a\u00020\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\u0002\b\u0019R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"},
   d2 = {"Lcom/rayneo/arsdk/android/core/HolderPair;", "B", "Landroidx/viewbinding/ViewBinding;", "T", "Lcom/rayneo/arsdk/android/core/BaseScreenHolder;", "", "leftHolder", "rightHolder", "(Lcom/rayneo/arsdk/android/core/BaseScreenHolder;Lcom/rayneo/arsdk/android/core/BaseScreenHolder;)V", "bindingPair", "Lcom/rayneo/arsdk/android/core/BindingPair;", "getBindingPair", "()Lcom/rayneo/arsdk/android/core/BindingPair;", "getLeftHolder", "()Lcom/rayneo/arsdk/android/core/BaseScreenHolder;", "Lcom/rayneo/arsdk/android/core/BaseScreenHolder;", "getRightHolder", "checkIsLeft", "", "b", "(Landroidx/viewbinding/ViewBinding;)Z", "setLeft", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updateHolder", "updateView", "MercurySDK_release"}
)
public final class HolderPair<B extends ViewBinding, T extends BaseScreenHolder<B>> {
   private final T leftHolder;
   private final T rightHolder;
   private final BindingPair<B> bindingPair;

   public HolderPair(T leftHolder, T rightHolder) {
      HolderPair var10000 = this;
      Intrinsics.checkNotNullParameter(leftHolder, "leftHolder");
      Intrinsics.checkNotNullParameter(rightHolder, "rightHolder");
      super();
      this.leftHolder = leftHolder;
      this.rightHolder = rightHolder;
      BindingPair var3;
      BindingPair var10001 = var3 = new BindingPair;
      ViewBinding leftHolder1 = leftHolder.getBinding();
      var10001.<init>(leftHolder1, rightHolder.getBinding());
      var10000.bindingPair = var3;
   }

   public final T getLeftHolder() {
      return this.leftHolder;
   }

   public final T getRightHolder() {
      return this.rightHolder;
   }

   public final BindingPair<B> getBindingPair() {
      return this.bindingPair;
   }

   public final void updateView(Function1<? super B, Unit> block) {
      Intrinsics.checkNotNullParameter(block, "block");
      this.bindingPair.updateView(block);
   }

   public final boolean checkIsLeft(B b) {
      Intrinsics.checkNotNullParameter(b, "b");
      return this.bindingPair.checkIsLeft(b);
   }

   public final void setLeft(Function1<? super B, Unit> block) {
      Intrinsics.checkNotNullParameter(block, "block");
      this.bindingPair.setLeft(block);
   }

   public final void updateHolder(Function1<? super T, Unit> block) {
      Intrinsics.checkNotNullParameter(block, "block");
      block.invoke(this.leftHolder);
      block.invoke(this.rightHolder);
   }
}
