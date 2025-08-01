package com.rayneo.arsdk.android.ui.util;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.rayneo.arsdk.android.core.ViewPair;
import com.rayneo.arsdk.android.focus.IFocusable;
import com.rayneo.arsdk.android.touch.TempleAction;
import com.rayneo.arsdk.android.touch.a;
import com.rayneo.arsdk.android.util.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 @2\u00020\u0001:\u0001@B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\bH\u0002J\u000e\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0006J\u0006\u0010-\u001a\u00020\u0006J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0002J\"\u00101\u001a\u00020/2\u0006\u00102\u001a\u0002032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020/05J\u0006\u00106\u001a\u00020/J\b\u00107\u001a\u00020/H\u0002J\u0010\u00108\u001a\u00020/2\u0006\u0010,\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020/H\u0002J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0013H\u0002J\u000e\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\u0006J\u0012\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020\bH\u0002R\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006A"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/util/RecyclerViewFocusTracker;", "", "mPair", "Lcom/rayneo/arsdk/android/core/ViewPair;", "Landroidx/recyclerview/widget/RecyclerView;", "ignoreDelta", "", "loop", "", "(Lcom/rayneo/arsdk/android/core/ViewPair;IZ)V", "<set-?>", "currentSelectPos", "getCurrentSelectPos", "()I", "focusObj", "Lcom/rayneo/arsdk/android/focus/IFocusable;", "getFocusObj", "()Lcom/rayneo/arsdk/android/focus/IFocusable;", "lastValidDelta", "", "getMPair", "()Lcom/rayneo/arsdk/android/core/ViewPair;", "onFocusChangeListener", "Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;", "getOnFocusChangeListener", "()Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;", "setOnFocusChangeListener", "(Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;)V", "onItemFocusListener", "Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;", "getOnItemFocusListener", "()Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;", "setOnItemFocusListener", "(Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;)V", "refreshListener", "Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;", "getRefreshListener", "()Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;", "setRefreshListener", "(Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;)V", "checkNeedScrollBy", "prePos", "toPre", "checkPosSelected", "pos", "checkedSelectPos", "doOnNext", "", "doOnPrevious", "handleActionEvent", "it", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "block", "Lkotlin/Function1;", "notifyDataSetChanged", "notifyFocusChanged", "notifyItemChanged", "onInternalActionUp", "onInternalSlideContinuous", "delta", "setCurrentSelectPos", "index", "smoothScrollToPosition", "smoothScroll", "Companion", "MercurySDK_release"}
)
public final class RecyclerViewFocusTracker {
   public static final RecyclerViewFocusTracker.Companion Companion = new RecyclerViewFocusTracker.Companion((DefaultConstructorMarker)null);
   public static final String TAG = "RecyclerViewFocusTracker";
   private final ViewPair<RecyclerView> mPair;
   private final int ignoreDelta;
   private final boolean loop;
   private final IFocusable focusObj;
   private float lastValidDelta;
   private int currentSelectPos;
   private OnItemFocusListener onItemFocusListener;
   private PullToRefreshListener refreshListener;
   private OnTrackerFocusChangeListener onFocusChangeListener;

   public RecyclerViewFocusTracker(ViewPair<RecyclerView> mPair, int ignoreDelta, boolean loop) {
      Intrinsics.checkNotNullParameter(mPair, "mPair");
      super();
      this.mPair = mPair;
      this.ignoreDelta = ignoreDelta;
      this.loop = loop;
      this.focusObj = new IFocusable() {
         private boolean hasFocus;
         private IFocusable focusParent;

         public boolean getHasFocus() {
            return this.hasFocus;
         }

         public void setHasFocus(boolean value) {
            boolean var2;
            if (this.hasFocus != value) {
               var2 = true;
            } else {
               var2 = false;
            }

            if (var2) {
               this.hasFocus = value;
            }

            if (var2) {
               RecyclerViewFocusTracker.this.notifyFocusChanged();
               OnTrackerFocusChangeListener var3;
               if ((var3 = RecyclerViewFocusTracker.this.getOnFocusChangeListener()) != null) {
                  var3.onFocusChange(value);
               }
            }

         }

         public IFocusable getFocusParent() {
            return this.focusParent;
         }

         public void setFocusParent(IFocusable var1) {
            this.focusParent = var1;
         }
      };
      this.currentSelectPos = -1;
      ((RecyclerView)mPair.getLeft()).addOnScrollListener(new OnScrollListener() {
         public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
               RecyclerViewFocusTracker.this.notifyFocusChanged();
            }

         }
      });
   }

   // $FF: synthetic method
   public RecyclerViewFocusTracker(ViewPair var1, int var2, boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = 50;
      }

      if ((var4 & 4) != 0) {
         var3 = false;
      }

      this(var1, var2, var3);
   }

   private final void onInternalSlideContinuous(float delta) {
      float var2;
      int var3;
      if ((var2 = delta - this.lastValidDelta) > (float)(var3 = this.ignoreDelta)) {
         this.doOnNext();
         this.lastValidDelta = delta;
      } else if (var2 < (float)(-var3)) {
         this.doOnPrevious();
         this.lastValidDelta = delta;
      }

   }

   private final void doOnPrevious() {
      this.notifyItemChanged(this.currentSelectPos);
      int var1 = this.currentSelectPos;
      if (this.loop) {
         if ((this.currentSelectPos = var1 + -1) < 0) {
            Adapter var10001 = ((RecyclerView)this.mPair.getLeft()).getAdapter();
            Intrinsics.checkNotNull(var10001);
            this.currentSelectPos = var10001.getItemCount() - 1;
         }
      } else if (var1 > 0) {
         this.currentSelectPos = var1 + -1;
      } else {
         PullToRefreshListener var2;
         if ((var2 = this.refreshListener) != null) {
            var2.onRefresh();
         }
      }

      if (!this.checkNeedScrollBy(var1, true)) {
         smoothScrollToPosition$default(this, false, 1, (Object)null);
      }

   }

   private final void doOnNext() {
      this.notifyItemChanged(this.currentSelectPos);
      int var1 = this.currentSelectPos;
      if (this.loop) {
         int var2;
         int var10001 = var2 = var1 + 1;
         this.currentSelectPos = var2;
         Adapter var10002 = ((RecyclerView)this.mPair.getLeft()).getAdapter();
         Intrinsics.checkNotNull(var10002);
         this.currentSelectPos = var10001 % var10002.getItemCount();
      } else {
         Adapter var3 = ((RecyclerView)this.mPair.getLeft()).getAdapter();
         Intrinsics.checkNotNull(var3);
         if (var1 < var3.getItemCount() - 1) {
            ++this.currentSelectPos;
         }
      }

      if (!this.checkNeedScrollBy(var1, false)) {
         smoothScrollToPosition$default(this, false, 1, (Object)null);
      }

   }

   private final void onInternalActionUp() {
      this.lastValidDelta = 0.0F;
   }

   private final boolean checkNeedScrollBy(final int prePos, final boolean toPre) {
      final BooleanRef var3;
      var3 = new BooleanRef.<init>();
      if (this.currentSelectPos != prePos) {
         this.mPair.update(new Function1<RecyclerView, Unit>() {
            public final void invoke(RecyclerView $this$update) {
               Intrinsics.checkNotNullParameter($this$update, "$this$update");
               LayoutManager var10001 = $this$update.getLayoutManager();
               Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
               LinearLayoutManager var2;
               LinearLayoutManager var11 = var2 = (LinearLayoutManager)var10001;
               int var3x = var11.findFirstVisibleItemPosition();
               var3x = (var11.findLastVisibleItemPosition() + var3x) / 2;
               boolean var4;
               if ((var4 = toPre) && prePos <= var3x || !var4 && prePos >= var3x) {
                  LinearLayoutManager var10000 = var2;
                  boolean var7 = var2.canScrollHorizontally();
                  View var9;
                  if ((var9 = var10000.findViewByPosition(RecyclerViewFocusTracker.this.getCurrentSelectPos())) != null) {
                     boolean var10 = var7;
                     <undefinedtype> var10002 = this;
                     boolean var5 = toPre;
                     BooleanRef var8 = var3;
                     var3x = var9.getHeight();
                     FLogger.i("targetView h = " + var3x);
                     if (var10) {
                        if (var5) {
                           var3x = -var3x;
                        }

                        $this$update.smoothScrollBy(var3x, 0);
                     } else {
                        var10 = var5;
                        byte var6 = 0;
                        if (var10) {
                           var3x = -var3x;
                        }

                        $this$update.smoothScrollBy(var6, var3x);
                     }

                     var8.element = true;
                  }
               }

            }
         });
      }

      return var3.element;
   }

   private final void smoothScrollToPosition(boolean smoothScroll) {
      FLogger.i("rilke", a.a("smoothScrollToPosition, currentPos = ").append(this.currentSelectPos).toString());
      int smoothScroll1;
      if ((smoothScroll1 = this.currentSelectPos) != -1) {
         this.notifyItemChanged(smoothScroll1);
         this.mPair.update(new Function1<RecyclerView, Unit>() {
            public final void invoke(RecyclerView $this$update) {
               Intrinsics.checkNotNullParameter($this$update, "$this$update");
               $this$update.smoothScrollToPosition(RecyclerViewFocusTracker.this.getCurrentSelectPos());
               OnItemFocusListener var2;
               if (Intrinsics.areEqual(RecyclerViewFocusTracker.this.getMPair().getLeft(), $this$update) && (var2 = RecyclerViewFocusTracker.this.getOnItemFocusListener()) != null) {
                  var2.OnItemFocus(RecyclerViewFocusTracker.this.getCurrentSelectPos(), $this$update);
               }

            }
         });
      }
   }

   // $FF: synthetic method
   public static void smoothScrollToPosition$default(RecyclerViewFocusTracker var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = true;
      }

      var0.smoothScrollToPosition(var1);
   }

   private final void notifyItemChanged(final int pos) {
      this.mPair.update(new Function1<RecyclerView, Unit>() {
         public final void invoke(RecyclerView $this$update) {
            Intrinsics.checkNotNullParameter($this$update, "$this$update");
            Adapter $this$update1;
            if (($this$update1 = $this$update.getAdapter()) != null) {
               $this$update1.notifyItemChanged(pos);
            }

         }
      });
   }

   private final void notifyFocusChanged() {
      this.notifyItemChanged(this.currentSelectPos);
   }

   public final ViewPair<RecyclerView> getMPair() {
      return this.mPair;
   }

   public final IFocusable getFocusObj() {
      return this.focusObj;
   }

   public final int getCurrentSelectPos() {
      return this.currentSelectPos;
   }

   public final OnItemFocusListener getOnItemFocusListener() {
      return this.onItemFocusListener;
   }

   public final void setOnItemFocusListener(OnItemFocusListener var1) {
      this.onItemFocusListener = var1;
   }

   public final PullToRefreshListener getRefreshListener() {
      return this.refreshListener;
   }

   public final void setRefreshListener(PullToRefreshListener var1) {
      this.refreshListener = var1;
   }

   public final OnTrackerFocusChangeListener getOnFocusChangeListener() {
      return this.onFocusChangeListener;
   }

   public final void setOnFocusChangeListener(OnTrackerFocusChangeListener var1) {
      this.onFocusChangeListener = var1;
   }

   public final void setCurrentSelectPos(int index) {
      this.currentSelectPos = index;
   }

   public final void handleActionEvent(TempleAction it, Function1<? super TempleAction, Unit> block) {
      Intrinsics.checkNotNullParameter(it, "it");
      Intrinsics.checkNotNullParameter(block, "block");
      if (this.focusObj.getHasFocus()) {
         if (it instanceof TempleAction.SlideContinuous) {
            this.onInternalSlideContinuous(((TempleAction.SlideContinuous)it).getDelta());
         } else if (it instanceof TempleAction.ActionUp) {
            this.onInternalActionUp();
         } else if (it instanceof TempleAction.DoubleClick || it instanceof TempleAction.Click) {
            block.invoke(it);
            it.setConsumed(true);
         }

      }
   }

   public final int checkedSelectPos() {
      return this.focusObj.getHasFocus() ? this.currentSelectPos : -1;
   }

   public final boolean checkPosSelected(int pos) {
      return this.currentSelectPos == pos && this.focusObj.getHasFocus();
   }

   public final void notifyDataSetChanged() {
      this.mPair.update(null.INSTANCE);
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"},
      d2 = {"Lcom/rayneo/arsdk/android/ui/util/RecyclerViewFocusTracker$Companion;", "", "()V", "TAG", "", "MercurySDK_release"}
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
