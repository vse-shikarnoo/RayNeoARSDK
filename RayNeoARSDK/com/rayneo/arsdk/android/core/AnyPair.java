package com.rayneo.arsdk.android.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"},
   d2 = {"Lcom/rayneo/arsdk/android/core/AnyPair;", "T", "", "Lcom/rayneo/arsdk/android/core/BaseMirrorAction;", "left", "right", "(Ljava/lang/Object;Ljava/lang/Object;)V", "MercurySDK_release"}
)
public final class AnyPair<T> extends BaseMirrorAction<T> {
   public AnyPair(T left, T right) {
      Intrinsics.checkNotNullParameter(left, "left");
      Intrinsics.checkNotNullParameter(right, "right");
      super(left, right);
   }
}
