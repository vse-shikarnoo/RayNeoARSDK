package com.rayneo.arsdk.android.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0012J\u001f\u0010\u0013\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0012R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"},
   d2 = {"Lcom/rayneo/arsdk/android/core/BaseMirrorAction;", "T", "", "left", "right", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getLeft", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getRight", "checkIsLeft", "", "t", "(Ljava/lang/Object;)Z", "setLeft", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "update", "MercurySDK_release"}
)
public abstract class BaseMirrorAction<T> {
   private final T left;
   private final T right;

   public BaseMirrorAction(T left, T right) {
      this.left = left;
      this.right = right;
   }

   public final T getLeft() {
      return this.left;
   }

   public final T getRight() {
      return this.right;
   }

   public final void update(Function1<? super T, Unit> block) {
      Intrinsics.checkNotNullParameter(block, "block");
      block.invoke(this.left);
      block.invoke(this.right);
   }

   public final void setLeft(Function1<? super T, Unit> block) {
      Intrinsics.checkNotNullParameter(block, "block");
      block.invoke(this.left);
   }

   public final boolean checkIsLeft(T t) {
      return Intrinsics.areEqual(this.left, t);
   }
}
