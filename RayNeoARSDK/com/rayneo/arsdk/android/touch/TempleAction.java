package com.rayneo.arsdk.android.touch;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0011\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0082\u0001\n\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"},
   d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction;", "", "consumed", "", "(Z)V", "getConsumed", "()Z", "setConsumed", "ActionUp", "Click", "DoubleClick", "Idle", "LongClick", "MoveUp", "SlideBackward", "SlideContinuous", "SlideForward", "TripleClick", "Lcom/rayneo/arsdk/android/touch/TempleAction$ActionUp;", "Lcom/rayneo/arsdk/android/touch/TempleAction$Click;", "Lcom/rayneo/arsdk/android/touch/TempleAction$DoubleClick;", "Lcom/rayneo/arsdk/android/touch/TempleAction$Idle;", "Lcom/rayneo/arsdk/android/touch/TempleAction$LongClick;", "Lcom/rayneo/arsdk/android/touch/TempleAction$MoveUp;", "Lcom/rayneo/arsdk/android/touch/TempleAction$SlideBackward;", "Lcom/rayneo/arsdk/android/touch/TempleAction$SlideContinuous;", "Lcom/rayneo/arsdk/android/touch/TempleAction$SlideForward;", "Lcom/rayneo/arsdk/android/touch/TempleAction$TripleClick;", "MercurySDK_release"}
)
public abstract class TempleAction {
   private boolean consumed;

   private TempleAction(boolean consumed) {
      this.consumed = consumed;
   }

   // $FF: synthetic method
   public TempleAction(boolean var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = false;
      }

      this(var1, (DefaultConstructorMarker)null);
   }

   // $FF: synthetic method
   public TempleAction(boolean consumed, DefaultConstructorMarker $constructor_marker) {
      this(consumed);
   }

   public boolean getConsumed() {
      return this.consumed;
   }

   public void setConsumed(boolean var1) {
      this.consumed = var1;
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$Idle;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "()V", "MercurySDK_release"}
   )
   public static final class Idle extends TempleAction {
      public static final TempleAction.Idle INSTANCE = new TempleAction.Idle();

      private Idle() {
         super(false, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$LongClick;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "consumed", "", "id", "", "(ZJ)V", "getConsumed", "()Z", "setConsumed", "(Z)V", "getId", "()J", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class LongClick extends TempleAction {
      private boolean consumed;
      private final long id;

      public LongClick(boolean consumed, long id) {
         super(false, 1, (DefaultConstructorMarker)null);
         this.consumed = consumed;
         this.id = id;
      }

      // $FF: synthetic method
      public LongClick(boolean var1, long var2, int var4, DefaultConstructorMarker var5) {
         if ((var4 & 1) != 0) {
            var1 = false;
         }

         if ((var4 & 2) != 0) {
            var2 = SystemClock.uptimeMillis();
         }

         this(var1, var2);
      }

      // $FF: synthetic method
      public static TempleAction.LongClick copy$default(TempleAction.LongClick var0, boolean var1, long var2, int var4, Object var5) {
         if ((var4 & 1) != 0) {
            var1 = var0.getConsumed();
         }

         if ((var4 & 2) != 0) {
            var2 = var0.id;
         }

         return var0.copy(var1, var2);
      }

      public LongClick() {
         this(false, 0L, 3, (DefaultConstructorMarker)null);
      }

      public boolean getConsumed() {
         return this.consumed;
      }

      public void setConsumed(boolean var1) {
         this.consumed = var1;
      }

      public final long getId() {
         return this.id;
      }

      public final boolean component1() {
         return this.getConsumed();
      }

      public final long component2() {
         return this.id;
      }

      public final TempleAction.LongClick copy(boolean consumed, long id) {
         return new TempleAction.LongClick(consumed, id);
      }

      public String toString() {
         return a.a("LongClick(consumed=").append(this.getConsumed()).append(", id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         byte var1;
         if ((var1 = this.getConsumed()) != 0) {
            var1 = 1;
         }

         TempleAction.LongClick var10000 = this;
         int var2 = var1 * 31;
         return Long.hashCode(var10000.id) + var2;
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.LongClick)) {
            return false;
         } else {
            TempleAction.LongClick other1 = (TempleAction.LongClick)other;
            if (this.getConsumed() != other1.getConsumed()) {
               return false;
            } else {
               return this.id == other1.id;
            }
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$Click;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "consumed", "", "id", "", "(ZJ)V", "getConsumed", "()Z", "setConsumed", "(Z)V", "getId", "()J", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class Click extends TempleAction {
      private boolean consumed;
      private final long id;

      public Click(boolean consumed, long id) {
         super(false, 1, (DefaultConstructorMarker)null);
         this.consumed = consumed;
         this.id = id;
      }

      // $FF: synthetic method
      public Click(boolean var1, long var2, int var4, DefaultConstructorMarker var5) {
         if ((var4 & 1) != 0) {
            var1 = false;
         }

         if ((var4 & 2) != 0) {
            var2 = SystemClock.uptimeMillis();
         }

         this(var1, var2);
      }

      // $FF: synthetic method
      public static TempleAction.Click copy$default(TempleAction.Click var0, boolean var1, long var2, int var4, Object var5) {
         if ((var4 & 1) != 0) {
            var1 = var0.getConsumed();
         }

         if ((var4 & 2) != 0) {
            var2 = var0.id;
         }

         return var0.copy(var1, var2);
      }

      public Click() {
         this(false, 0L, 3, (DefaultConstructorMarker)null);
      }

      public boolean getConsumed() {
         return this.consumed;
      }

      public void setConsumed(boolean var1) {
         this.consumed = var1;
      }

      public final long getId() {
         return this.id;
      }

      public final boolean component1() {
         return this.getConsumed();
      }

      public final long component2() {
         return this.id;
      }

      public final TempleAction.Click copy(boolean consumed, long id) {
         return new TempleAction.Click(consumed, id);
      }

      public String toString() {
         return a.a("Click(consumed=").append(this.getConsumed()).append(", id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         byte var1;
         if ((var1 = this.getConsumed()) != 0) {
            var1 = 1;
         }

         TempleAction.Click var10000 = this;
         int var2 = var1 * 31;
         return Long.hashCode(var10000.id) + var2;
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.Click)) {
            return false;
         } else {
            TempleAction.Click other1 = (TempleAction.Click)other;
            if (this.getConsumed() != other1.getConsumed()) {
               return false;
            } else {
               return this.id == other1.id;
            }
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$DoubleClick;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "consumed", "", "id", "", "(ZJ)V", "getConsumed", "()Z", "setConsumed", "(Z)V", "getId", "()J", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class DoubleClick extends TempleAction {
      private boolean consumed;
      private final long id;

      public DoubleClick(boolean consumed, long id) {
         super(false, 1, (DefaultConstructorMarker)null);
         this.consumed = consumed;
         this.id = id;
      }

      // $FF: synthetic method
      public DoubleClick(boolean var1, long var2, int var4, DefaultConstructorMarker var5) {
         if ((var4 & 1) != 0) {
            var1 = false;
         }

         if ((var4 & 2) != 0) {
            var2 = SystemClock.uptimeMillis();
         }

         this(var1, var2);
      }

      // $FF: synthetic method
      public static TempleAction.DoubleClick copy$default(TempleAction.DoubleClick var0, boolean var1, long var2, int var4, Object var5) {
         if ((var4 & 1) != 0) {
            var1 = var0.getConsumed();
         }

         if ((var4 & 2) != 0) {
            var2 = var0.id;
         }

         return var0.copy(var1, var2);
      }

      public DoubleClick() {
         this(false, 0L, 3, (DefaultConstructorMarker)null);
      }

      public boolean getConsumed() {
         return this.consumed;
      }

      public void setConsumed(boolean var1) {
         this.consumed = var1;
      }

      public final long getId() {
         return this.id;
      }

      public final boolean component1() {
         return this.getConsumed();
      }

      public final long component2() {
         return this.id;
      }

      public final TempleAction.DoubleClick copy(boolean consumed, long id) {
         return new TempleAction.DoubleClick(consumed, id);
      }

      public String toString() {
         return a.a("DoubleClick(consumed=").append(this.getConsumed()).append(", id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         byte var1;
         if ((var1 = this.getConsumed()) != 0) {
            var1 = 1;
         }

         TempleAction.DoubleClick var10000 = this;
         int var2 = var1 * 31;
         return Long.hashCode(var10000.id) + var2;
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.DoubleClick)) {
            return false;
         } else {
            TempleAction.DoubleClick other1 = (TempleAction.DoubleClick)other;
            if (this.getConsumed() != other1.getConsumed()) {
               return false;
            } else {
               return this.id == other1.id;
            }
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$TripleClick;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "consumed", "", "id", "", "(ZJ)V", "getConsumed", "()Z", "setConsumed", "(Z)V", "getId", "()J", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class TripleClick extends TempleAction {
      private boolean consumed;
      private final long id;

      public TripleClick(boolean consumed, long id) {
         super(false, 1, (DefaultConstructorMarker)null);
         this.consumed = consumed;
         this.id = id;
      }

      // $FF: synthetic method
      public TripleClick(boolean var1, long var2, int var4, DefaultConstructorMarker var5) {
         if ((var4 & 1) != 0) {
            var1 = false;
         }

         if ((var4 & 2) != 0) {
            var2 = SystemClock.uptimeMillis();
         }

         this(var1, var2);
      }

      // $FF: synthetic method
      public static TempleAction.TripleClick copy$default(TempleAction.TripleClick var0, boolean var1, long var2, int var4, Object var5) {
         if ((var4 & 1) != 0) {
            var1 = var0.getConsumed();
         }

         if ((var4 & 2) != 0) {
            var2 = var0.id;
         }

         return var0.copy(var1, var2);
      }

      public TripleClick() {
         this(false, 0L, 3, (DefaultConstructorMarker)null);
      }

      public boolean getConsumed() {
         return this.consumed;
      }

      public void setConsumed(boolean var1) {
         this.consumed = var1;
      }

      public final long getId() {
         return this.id;
      }

      public final boolean component1() {
         return this.getConsumed();
      }

      public final long component2() {
         return this.id;
      }

      public final TempleAction.TripleClick copy(boolean consumed, long id) {
         return new TempleAction.TripleClick(consumed, id);
      }

      public String toString() {
         return a.a("TripleClick(consumed=").append(this.getConsumed()).append(", id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         byte var1;
         if ((var1 = this.getConsumed()) != 0) {
            var1 = 1;
         }

         TempleAction.TripleClick var10000 = this;
         int var2 = var1 * 31;
         return Long.hashCode(var10000.id) + var2;
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.TripleClick)) {
            return false;
         } else {
            TempleAction.TripleClick other1 = (TempleAction.TripleClick)other;
            if (this.getConsumed() != other1.getConsumed()) {
               return false;
            } else {
               return this.id == other1.id;
            }
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$SlideBackward;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "args", "Lcom/rayneo/arsdk/android/touch/FlingArgs;", "consumed", "", "id", "", "(Lcom/rayneo/arsdk/android/touch/FlingArgs;ZJ)V", "getArgs", "()Lcom/rayneo/arsdk/android/touch/FlingArgs;", "getConsumed", "()Z", "setConsumed", "(Z)V", "getId", "()J", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class SlideBackward extends TempleAction {
      private final FlingArgs args;
      private boolean consumed;
      private final long id;

      public SlideBackward(FlingArgs args, boolean consumed, long id) {
         Intrinsics.checkNotNullParameter(args, "args");
         super(false, 1, (DefaultConstructorMarker)null);
         this.args = args;
         this.consumed = consumed;
         this.id = id;
      }

      // $FF: synthetic method
      public SlideBackward(FlingArgs var1, boolean var2, long var3, int var5, DefaultConstructorMarker var6) {
         if ((var5 & 2) != 0) {
            var2 = false;
         }

         if ((var5 & 4) != 0) {
            var3 = SystemClock.uptimeMillis();
         }

         this(var1, var2, var3);
      }

      // $FF: synthetic method
      public static TempleAction.SlideBackward copy$default(TempleAction.SlideBackward var0, FlingArgs var1, boolean var2, long var3, int var5, Object var6) {
         if ((var5 & 1) != 0) {
            var1 = var0.args;
         }

         if ((var5 & 2) != 0) {
            var2 = var0.getConsumed();
         }

         if ((var5 & 4) != 0) {
            var3 = var0.id;
         }

         return var0.copy(var1, var2, var3);
      }

      public final FlingArgs getArgs() {
         return this.args;
      }

      public boolean getConsumed() {
         return this.consumed;
      }

      public void setConsumed(boolean var1) {
         this.consumed = var1;
      }

      public final long getId() {
         return this.id;
      }

      public final FlingArgs component1() {
         return this.args;
      }

      public final boolean component2() {
         return this.getConsumed();
      }

      public final long component3() {
         return this.id;
      }

      public final TempleAction.SlideBackward copy(FlingArgs args, boolean consumed, long id) {
         Intrinsics.checkNotNullParameter(args, "args");
         return new TempleAction.SlideBackward(args, consumed, id);
      }

      public String toString() {
         return a.a("SlideBackward(args=").append(this.args).append(", consumed=").append(this.getConsumed()).append(", id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         int var1 = this.args.hashCode() * 31;
         byte var2;
         if ((var2 = this.getConsumed()) != 0) {
            var2 = 1;
         }

         TempleAction.SlideBackward var10000 = this;
         int var3 = (var1 + var2) * 31;
         return Long.hashCode(var10000.id) + var3;
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.SlideBackward)) {
            return false;
         } else {
            TempleAction.SlideBackward other1 = (TempleAction.SlideBackward)other;
            if (!Intrinsics.areEqual(this.args, other1.args)) {
               return false;
            } else if (this.getConsumed() != other1.getConsumed()) {
               return false;
            } else {
               return this.id == other1.id;
            }
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$SlideForward;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "args", "Lcom/rayneo/arsdk/android/touch/FlingArgs;", "consumed", "", "id", "", "(Lcom/rayneo/arsdk/android/touch/FlingArgs;ZJ)V", "getArgs", "()Lcom/rayneo/arsdk/android/touch/FlingArgs;", "getConsumed", "()Z", "setConsumed", "(Z)V", "getId", "()J", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class SlideForward extends TempleAction {
      private final FlingArgs args;
      private boolean consumed;
      private final long id;

      public SlideForward(FlingArgs args, boolean consumed, long id) {
         Intrinsics.checkNotNullParameter(args, "args");
         super(false, 1, (DefaultConstructorMarker)null);
         this.args = args;
         this.consumed = consumed;
         this.id = id;
      }

      // $FF: synthetic method
      public SlideForward(FlingArgs var1, boolean var2, long var3, int var5, DefaultConstructorMarker var6) {
         if ((var5 & 2) != 0) {
            var2 = false;
         }

         if ((var5 & 4) != 0) {
            var3 = SystemClock.uptimeMillis();
         }

         this(var1, var2, var3);
      }

      // $FF: synthetic method
      public static TempleAction.SlideForward copy$default(TempleAction.SlideForward var0, FlingArgs var1, boolean var2, long var3, int var5, Object var6) {
         if ((var5 & 1) != 0) {
            var1 = var0.args;
         }

         if ((var5 & 2) != 0) {
            var2 = var0.getConsumed();
         }

         if ((var5 & 4) != 0) {
            var3 = var0.id;
         }

         return var0.copy(var1, var2, var3);
      }

      public final FlingArgs getArgs() {
         return this.args;
      }

      public boolean getConsumed() {
         return this.consumed;
      }

      public void setConsumed(boolean var1) {
         this.consumed = var1;
      }

      public final long getId() {
         return this.id;
      }

      public final FlingArgs component1() {
         return this.args;
      }

      public final boolean component2() {
         return this.getConsumed();
      }

      public final long component3() {
         return this.id;
      }

      public final TempleAction.SlideForward copy(FlingArgs args, boolean consumed, long id) {
         Intrinsics.checkNotNullParameter(args, "args");
         return new TempleAction.SlideForward(args, consumed, id);
      }

      public String toString() {
         return a.a("SlideForward(args=").append(this.args).append(", consumed=").append(this.getConsumed()).append(", id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         int var1 = this.args.hashCode() * 31;
         byte var2;
         if ((var2 = this.getConsumed()) != 0) {
            var2 = 1;
         }

         TempleAction.SlideForward var10000 = this;
         int var3 = (var1 + var2) * 31;
         return Long.hashCode(var10000.id) + var3;
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.SlideForward)) {
            return false;
         } else {
            TempleAction.SlideForward other1 = (TempleAction.SlideForward)other;
            if (!Intrinsics.areEqual(this.args, other1.args)) {
               return false;
            } else if (this.getConsumed() != other1.getConsumed()) {
               return false;
            } else {
               return this.id == other1.id;
            }
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$SlideContinuous;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "delta", "", "longClick", "", "id", "", "(FZJ)V", "getDelta", "()F", "getId", "()J", "getLongClick", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class SlideContinuous extends TempleAction {
      private final float delta;
      private final boolean longClick;
      private final long id;

      public SlideContinuous(float delta, boolean longClick, long id) {
         super(false, 1, (DefaultConstructorMarker)null);
         this.delta = delta;
         this.longClick = longClick;
         this.id = id;
      }

      // $FF: synthetic method
      public SlideContinuous(float var1, boolean var2, long var3, int var5, DefaultConstructorMarker var6) {
         if ((var5 & 4) != 0) {
            var3 = SystemClock.uptimeMillis();
         }

         this(var1, var2, var3);
      }

      // $FF: synthetic method
      public static TempleAction.SlideContinuous copy$default(TempleAction.SlideContinuous var0, float var1, boolean var2, long var3, int var5, Object var6) {
         if ((var5 & 1) != 0) {
            var1 = var0.delta;
         }

         if ((var5 & 2) != 0) {
            var2 = var0.longClick;
         }

         if ((var5 & 4) != 0) {
            var3 = var0.id;
         }

         return var0.copy(var1, var2, var3);
      }

      public final float getDelta() {
         return this.delta;
      }

      public final boolean getLongClick() {
         return this.longClick;
      }

      public final long getId() {
         return this.id;
      }

      public final float component1() {
         return this.delta;
      }

      public final boolean component2() {
         return this.longClick;
      }

      public final long component3() {
         return this.id;
      }

      public final TempleAction.SlideContinuous copy(float delta, boolean longClick, long id) {
         return new TempleAction.SlideContinuous(delta, longClick, id);
      }

      public String toString() {
         return a.a("SlideContinuous(delta=").append(this.delta).append(", longClick=").append(this.longClick).append(", id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         int var1 = Float.hashCode(this.delta) * 31;
         byte var2;
         if ((var2 = this.longClick) != 0) {
            var2 = 1;
         }

         TempleAction.SlideContinuous var10000 = this;
         int var3 = (var1 + var2) * 31;
         return Long.hashCode(var10000.id) + var3;
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.SlideContinuous)) {
            return false;
         } else {
            TempleAction.SlideContinuous other1 = (TempleAction.SlideContinuous)other;
            if (!Intrinsics.areEqual(this.delta, other1.delta)) {
               return false;
            } else if (this.longClick != other1.longClick) {
               return false;
            } else {
               return this.id == other1.id;
            }
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0014"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$MoveUp;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "isLongClick", "", "id", "", "(ZJ)V", "getId", "()J", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class MoveUp extends TempleAction {
      private final boolean isLongClick;
      private final long id;

      public MoveUp(boolean isLongClick, long id) {
         super(false, 1, (DefaultConstructorMarker)null);
         this.isLongClick = isLongClick;
         this.id = id;
      }

      // $FF: synthetic method
      public MoveUp(boolean var1, long var2, int var4, DefaultConstructorMarker var5) {
         if ((var4 & 2) != 0) {
            var2 = SystemClock.uptimeMillis();
         }

         this(var1, var2);
      }

      // $FF: synthetic method
      public static TempleAction.MoveUp copy$default(TempleAction.MoveUp var0, boolean var1, long var2, int var4, Object var5) {
         if ((var4 & 1) != 0) {
            var1 = var0.isLongClick;
         }

         if ((var4 & 2) != 0) {
            var2 = var0.id;
         }

         return var0.copy(var1, var2);
      }

      public final boolean isLongClick() {
         return this.isLongClick;
      }

      public final long getId() {
         return this.id;
      }

      public final boolean component1() {
         return this.isLongClick;
      }

      public final long component2() {
         return this.id;
      }

      public final TempleAction.MoveUp copy(boolean isLongClick, long id) {
         return new TempleAction.MoveUp(isLongClick, id);
      }

      public String toString() {
         return a.a("MoveUp(isLongClick=").append(this.isLongClick).append(", id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         byte var1;
         if ((var1 = this.isLongClick) != 0) {
            var1 = 1;
         }

         TempleAction.MoveUp var10000 = this;
         int var2 = var1 * 31;
         return Long.hashCode(var10000.id) + var2;
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.MoveUp)) {
            return false;
         } else {
            TempleAction.MoveUp other1 = (TempleAction.MoveUp)other;
            if (this.isLongClick != other1.isLongClick) {
               return false;
            } else {
               return this.id == other1.id;
            }
         }
      }
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"},
      d2 = {"Lcom/rayneo/arsdk/android/touch/TempleAction$ActionUp;", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "MercurySDK_release"}
   )
   public static final class ActionUp extends TempleAction {
      private final long id;

      public ActionUp(long id) {
         super(false, 1, (DefaultConstructorMarker)null);
         this.id = id;
      }

      // $FF: synthetic method
      public ActionUp(long var1, int var3, DefaultConstructorMarker var4) {
         if ((var3 & 1) != 0) {
            var1 = SystemClock.uptimeMillis();
         }

         this(var1);
      }

      // $FF: synthetic method
      public static TempleAction.ActionUp copy$default(TempleAction.ActionUp var0, long var1, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.id;
         }

         return var0.copy(var1);
      }

      public ActionUp() {
         this(0L, 1, (DefaultConstructorMarker)null);
      }

      public final long getId() {
         return this.id;
      }

      public final long component1() {
         return this.id;
      }

      public final TempleAction.ActionUp copy(long id) {
         return new TempleAction.ActionUp(id);
      }

      public String toString() {
         return a.a("ActionUp(id=").append(this.id).append(')').toString();
      }

      public int hashCode() {
         return Long.hashCode(this.id);
      }

      public boolean equals(Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof TempleAction.ActionUp)) {
            return false;
         } else {
            TempleAction.ActionUp var10000 = this;
            TempleAction.ActionUp var2 = (TempleAction.ActionUp)other;
            return var10000.id == var2.id;
         }
      }
   }
}
