package com.rayneo.arsdk.android.ui.dialog;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000bj\b\u0012\u0004\u0012\u00020\u0006`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/dialog/FocusTracker;", "", "loop", "", "(Z)V", "<set-?>", "Lcom/rayneo/arsdk/android/ui/dialog/TrackInfo;", "currentFocusItem", "getCurrentFocusItem", "()Lcom/rayneo/arsdk/android/ui/dialog/TrackInfo;", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addFocusTarget", "", "trackInfoList", "", "([Lcom/rayneo/arsdk/android/ui/dialog/TrackInfo;)V", "currentFocus", "target", "next", "previous", "swapFocus", "newCurrent", "current", "MercurySDK_release"}
)
public final class FocusTracker {
   private final boolean loop;
   private final ArrayList<TrackInfo> list;
   private TrackInfo currentFocusItem;

   public FocusTracker(boolean loop) {
      FocusTracker var10000 = this;
      super();
      this.loop = loop;
      ArrayList var2;
      var2 = new ArrayList.<init>();
      var10000.list = var2;
   }

   private final void swapFocus(TrackInfo newCurrent, TrackInfo current) {
      if (!Intrinsics.areEqual(newCurrent, current)) {
         current.releaseFocus();
         newCurrent.fetchFocus();
         this.currentFocusItem = newCurrent;
      }

   }

   public final TrackInfo getCurrentFocusItem() {
      TrackInfo var1;
      if ((var1 = this.currentFocusItem) != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("currentFocusItem");
         return null;
      }
   }

   public final void addFocusTarget(TrackInfo... trackInfoList) {
      Intrinsics.checkNotNullParameter(trackInfoList, "trackInfoList");
      int var2 = 0;

      for(int var3 = trackInfoList.length; var2 < var3; ++var2) {
         TrackInfo var4 = trackInfoList[var2];
         this.list.add(var4);
      }

   }

   public final void currentFocus(Object target) {
      Intrinsics.checkNotNullParameter(target, "target");
      Iterator var2 = this.list.iterator();

      while(var2.hasNext()) {
         TrackInfo var3;
         if ((var3 = (TrackInfo)var2.next()).getTarget() == target) {
            var3.fetchFocus();
            this.currentFocusItem = var3;
         }
      }

   }

   public final void next() {
      int var1 = this.list.indexOf(this.getCurrentFocusItem());
      TrackInfo var2 = this.getCurrentFocusItem();
      ++var1;
      if (this.loop) {
         var1 %= this.list.size();
      }

      if (var1 < this.list.size()) {
         Object var10001 = this.list.get(var1);
         Intrinsics.checkNotNullExpressionValue(var10001, "list[index]");
         this.swapFocus((TrackInfo)var10001, var2);
      }

   }

   public final void previous() {
      int var1 = this.list.indexOf(this.getCurrentFocusItem());
      TrackInfo var2 = this.getCurrentFocusItem();
      --var1;
      if (this.loop && var1 < 0) {
         var1 = this.list.size() - 1;
      }

      if (var1 >= 0) {
         Object var10001 = this.list.get(var1);
         Intrinsics.checkNotNullExpressionValue(var10001, "list[index]");
         this.swapFocus((TrackInfo)var10001, var2);
      }

   }
}
