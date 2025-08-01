package com.rayneo.arsdk.android.touch;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"},
   d2 = {"Lcom/rayneo/arsdk/android/touch/FlingArgs;", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)V", "getE1", "()Landroid/view/MotionEvent;", "getE2", "getVelocityX", "()F", "getVelocityY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "MercurySDK_release"}
)
public final class FlingArgs {
   private final MotionEvent e1;
   private final MotionEvent e2;
   private final float velocityX;
   private final float velocityY;

   public FlingArgs(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
      Intrinsics.checkNotNullParameter(e1, "e1");
      Intrinsics.checkNotNullParameter(e2, "e2");
      super();
      this.e1 = e1;
      this.e2 = e2;
      this.velocityX = velocityX;
      this.velocityY = velocityY;
   }

   // $FF: synthetic method
   public static FlingArgs copy$default(FlingArgs var0, MotionEvent var1, MotionEvent var2, float var3, float var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.e1;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.e2;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.velocityX;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.velocityY;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final MotionEvent getE1() {
      return this.e1;
   }

   public final MotionEvent getE2() {
      return this.e2;
   }

   public final float getVelocityX() {
      return this.velocityX;
   }

   public final float getVelocityY() {
      return this.velocityY;
   }

   public final MotionEvent component1() {
      return this.e1;
   }

   public final MotionEvent component2() {
      return this.e2;
   }

   public final float component3() {
      return this.velocityX;
   }

   public final float component4() {
      return this.velocityY;
   }

   public final FlingArgs copy(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
      Intrinsics.checkNotNullParameter(e1, "e1");
      Intrinsics.checkNotNullParameter(e2, "e2");
      return new FlingArgs(e1, e2, velocityX, velocityY);
   }

   public String toString() {
      return a.a("FlingArgs(e1=").append(this.e1).append(", e2=").append(this.e2).append(", velocityX=").append(this.velocityX).append(", velocityY=").append(this.velocityY).append(')').toString();
   }

   public int hashCode() {
      FlingArgs var10000 = this;
      FlingArgs var10001 = this;
      FlingArgs var10002 = this;
      int var1 = this.e1.hashCode() * 31;
      var1 = (var10002.e2.hashCode() + var1) * 31;
      var1 = (Float.hashCode(var10001.velocityX) + var1) * 31;
      return Float.hashCode(var10000.velocityY) + var1;
   }

   public boolean equals(Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof FlingArgs)) {
         return false;
      } else {
         FlingArgs other1 = (FlingArgs)other;
         if (!Intrinsics.areEqual(this.e1, other1.e1)) {
            return false;
         } else if (!Intrinsics.areEqual(this.e2, other1.e2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.velocityX, other1.velocityX)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.velocityY, other1.velocityY);
         }
      }
   }
}
