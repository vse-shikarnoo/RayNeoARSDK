package com.rayneo.arsdk.android.ui.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.rayneo.arsdk.android.core.ViewPair;
import com.rayneo.arsdk.android.ext.ViewExtensionKt;
import com.rayneo.arsdk.android.focus.IFocusable;
import com.rayneo.arsdk.android.touch.FlingArgs;
import com.rayneo.arsdk.android.touch.TempleAction;
import com.rayneo.arsdk.android.touch.a;
import com.rayneo.arsdk.android.util.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.ranges.RangesKt;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u0001:\u0001AB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00062\b\b\u0002\u00101\u001a\u00020\u0006H\u0002J\u000e\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\tJ\u0006\u00104\u001a\u00020\tJ\"\u00105\u001a\u00020-2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020-09J\u0006\u0010:\u001a\u00020-J\u0006\u0010;\u001a\u00020-J\u000e\u0010<\u001a\u00020-2\u0006\u00103\u001a\u00020\tJ\u000e\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\tJ\u0010\u0010?\u001a\u00020-2\b\b\u0002\u0010@\u001a\u00020\u0006R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006B"},
   d2 = {"Lcom/rayneo/arsdk/android/ui/util/RecyclerViewTracker;", "", "mPair", "Lcom/rayneo/arsdk/android/core/ViewPair;", "Landroidx/recyclerview/widget/RecyclerView;", "loop", "", "(Lcom/rayneo/arsdk/android/core/ViewPair;Z)V", "<set-?>", "", "currentSelectPos", "getCurrentSelectPos", "()I", "focusObj", "Lcom/rayneo/arsdk/android/focus/IFocusable;", "getFocusObj", "()Lcom/rayneo/arsdk/android/focus/IFocusable;", "isFling", "()Z", "setFling", "(Z)V", "getLoop", "getMPair", "()Lcom/rayneo/arsdk/android/core/ViewPair;", "onFocusChangeListener", "Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;", "getOnFocusChangeListener", "()Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;", "setOnFocusChangeListener", "(Lcom/rayneo/arsdk/android/ui/util/OnTrackerFocusChangeListener;)V", "onItemFocusListener", "Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;", "getOnItemFocusListener", "()Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;", "setOnItemFocusListener", "(Lcom/rayneo/arsdk/android/ui/util/OnItemFocusListener;)V", "preDelta", "", "refreshListener", "Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;", "getRefreshListener", "()Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;", "setRefreshListener", "(Lcom/rayneo/arsdk/android/ui/util/PullToRefreshListener;)V", "checkFlingOrOneStep", "", "args", "Lcom/rayneo/arsdk/android/touch/FlingArgs;", "checkLastItemVisible", "enableFling", "checkPosSelected", "pos", "checkedSelectPos", "handleActionEvent", "it", "Lcom/rayneo/arsdk/android/touch/TempleAction;", "block", "Lkotlin/Function1;", "notifyDataSetChanged", "notifyFocusChanged", "notifyItemChanged", "setCurrentSelectPos", "index", "smoothScrollToPosition", "smoothScroll", "Companion", "MercurySDK_release"}
)
public final class RecyclerViewTracker {
   public static final RecyclerViewTracker.Companion Companion = new RecyclerViewTracker.Companion((DefaultConstructorMarker)null);
   public static final String TAG = "RecyclerViewTracker";
   public static final int FLING_SPEED_LOW = 3000;
   public static final int FLING_SPEED_HIGH = 5000;
   private static long preTime;
   private final ViewPair<RecyclerView> mPair;
   private final boolean loop;
   private final IFocusable focusObj;
   private float preDelta;
   private boolean isFling;
   private int currentSelectPos;
   private OnItemFocusListener onItemFocusListener;
   private PullToRefreshListener refreshListener;
   private OnTrackerFocusChangeListener onFocusChangeListener;

   public RecyclerViewTracker(ViewPair<RecyclerView> mPair, boolean loop) {
      Intrinsics.checkNotNullParameter(mPair, "mPair");
      super();
      this.mPair = mPair;
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
               RecyclerViewTracker.this.notifyFocusChanged();
               OnTrackerFocusChangeListener var3;
               if ((var3 = RecyclerViewTracker.this.getOnFocusChangeListener()) != null) {
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
            int recyclerView1 = ViewExtensionKt.findFirstVisibleItemPosition((RecyclerView)RecyclerViewTracker.this.getMPair().getLeft());
            FLogger.e$default("RecyclerViewTracker", a.a("onScrollStateChanged: 6.0 isFling = ").append(RecyclerViewTracker.this.isFling()).append(",firstPos = ").append(recyclerView1).append(",newState = ").append(newState).append(' ').toString(), (Throwable)null, 4, (Object)null);
            if (RecyclerViewTracker.this.isFling() && newState == 0 && RecyclerViewTracker.this.getCurrentSelectPos() != recyclerView1) {
               RecyclerViewTracker var10004 = RecyclerViewTracker.this;
               var10004.notifyItemChanged(var10004.getCurrentSelectPos());
               RecyclerViewTracker.this.currentSelectPos = recyclerView1;
               RecyclerViewTracker.this.setFling(false);
               RecyclerViewTracker.smoothScrollToPosition$default(RecyclerViewTracker.this, false, 1, (Object)null);
               RecyclerViewTracker var10000 = RecyclerViewTracker.this;
               var10000.notifyItemChanged(var10000.getCurrentSelectPos());
            }

         }
      });
   }

   // $FF: synthetic method
   public RecyclerViewTracker(ViewPair var1, boolean var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      this(var1, var2);
   }

   private final void checkFlingOrOneStep(FlingArgs args, boolean checkLastItemVisible, boolean enableFling) {
      if (!enableFling) {
         smoothScrollToPosition$default(this, false, 1, (Object)null);
      } else {
         final IntRef enableFling1;
         IntRef var10000 = enableFling1 = new IntRef;
         enableFling1.<init>();
         int args1;
         var10000.element = args1 = (int)args.getVelocityX();
         if (Math.abs(args1) < 3000 || checkLastItemVisible && ViewExtensionKt.lastItemVisible((RecyclerView)this.mPair.getLeft())) {
            smoothScrollToPosition$default(this, false, 1, (Object)null);
         } else {
            if (Math.abs(enableFling1.element) > 5000) {
               enableFling1.element = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(enableFling1.element, -5000), 5000);
            }

            this.isFling = true;
            this.mPair.update(new Function1<RecyclerView, Unit>() {
               public final void invoke(RecyclerView $this$update) {
                  Intrinsics.checkNotNullParameter($this$update, "$this$update");
                  $this$update.fling(0, enableFling1.element / 2);
               }
            });
         }

      }
   }

   // $FF: synthetic method
   public static void checkFlingOrOneStep$default(RecyclerViewTracker var0, FlingArgs var1, boolean var2, boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = false;
      }

      if ((var4 & 4) != 0) {
         var3 = true;
      }

      var0.checkFlingOrOneStep(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void smoothScrollToPosition$default(RecyclerViewTracker var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = true;
      }

      var0.smoothScrollToPosition(var1);
   }

   public final ViewPair<RecyclerView> getMPair() {
      return this.mPair;
   }

   public final boolean getLoop() {
      return this.loop;
   }

   public final IFocusable getFocusObj() {
      return this.focusObj;
   }

   public final boolean isFling() {
      return this.isFling;
   }

   public final void setFling(boolean var1) {
      this.isFling = var1;
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

   public final void handleActionEvent(final TempleAction it, Function1<? super TempleAction, Unit> block) {
      Intrinsics.checkNotNullParameter(it, "it");
      Intrinsics.checkNotNullParameter(block, "block");
      if (this.focusObj.getHasFocus()) {
         if (it instanceof TempleAction.SlideBackward) {
            Companion.ensureInterval(new Function0<Unit>() {
               public final void invoke() {
                  RecyclerViewTracker var10001;
                  if (RecyclerViewTracker.this.getLoop()) {
                     RecyclerViewTracker var10003 = RecyclerViewTracker.this;
                     var10003.notifyItemChanged(var10003.getCurrentSelectPos());
                     RecyclerViewTracker var10002 = RecyclerViewTracker.this;
                     var10002.currentSelectPos = var10002.getCurrentSelectPos() + 1;
                     var10001 = RecyclerViewTracker.this;
                     int var3 = var10001.getCurrentSelectPos();
                     Adapter var4 = ((RecyclerView)RecyclerViewTracker.this.getMPair().getLeft()).getAdapter();
                     Intrinsics.checkNotNull(var4);
                     var10001.currentSelectPos = var3 % var4.getItemCount();
                     RecyclerViewTracker.checkFlingOrOneStep$default(RecyclerViewTracker.this, ((TempleAction.SlideBackward)it).getArgs(), true, false, 4, (Object)null);
                  } else {
                     int var10000 = RecyclerViewTracker.this.getCurrentSelectPos();
                     Adapter var2 = ((RecyclerView)RecyclerViewTracker.this.getMPair().getLeft()).getAdapter();
                     Intrinsics.checkNotNull(var2);
                     if (var10000 < var2.getItemCount() - 1) {
                        var10001 = RecyclerViewTracker.this;
                        var10001.notifyItemChanged(var10001.getCurrentSelectPos());
                        RecyclerViewTracker var1 = RecyclerViewTracker.this;
                        var1.currentSelectPos = var1.getCurrentSelectPos() + 1;
                     }

                     RecyclerViewTracker.checkFlingOrOneStep$default(RecyclerViewTracker.this, ((TempleAction.SlideBackward)it).getArgs(), true, false, 4, (Object)null);
                  }

               }
            });
         } else if (it instanceof TempleAction.SlideForward) {
            Companion.ensureInterval(new Function0<Unit>() {
               public final void invoke() {
                  RecyclerViewTracker var10000;
                  RecyclerViewTracker var10001;
                  if (RecyclerViewTracker.this.getLoop()) {
                     RecyclerViewTracker var10002 = RecyclerViewTracker.this;
                     var10002.notifyItemChanged(var10002.getCurrentSelectPos());
                     var10001 = RecyclerViewTracker.this;
                     var10001.currentSelectPos = var10001.getCurrentSelectPos() + -1;
                     if (RecyclerViewTracker.this.getCurrentSelectPos() < 0) {
                        var10000 = RecyclerViewTracker.this;
                        Adapter var2 = ((RecyclerView)var10000.getMPair().getLeft()).getAdapter();
                        Intrinsics.checkNotNull(var2);
                        var10000.currentSelectPos = var2.getItemCount() - 1;
                     }
                  } else if (RecyclerViewTracker.this.getCurrentSelectPos() > 0) {
                     var10001 = RecyclerViewTracker.this;
                     var10001.notifyItemChanged(var10001.getCurrentSelectPos());
                     var10000 = RecyclerViewTracker.this;
                     var10000.currentSelectPos = var10000.getCurrentSelectPos() + -1;
                  } else {
                     PullToRefreshListener var1;
                     if ((var1 = RecyclerViewTracker.this.getRefreshListener()) != null) {
                        var1.onRefresh();
                     }
                  }

                  RecyclerViewTracker.checkFlingOrOneStep$default(RecyclerViewTracker.this, ((TempleAction.SlideForward)it).getArgs(), false, false, 4, (Object)null);
               }
            });
         } else if (it instanceof TempleAction.SlideContinuous) {
            FLogger.i("rilke", "LIST action = " + it + ", SlideContinuous longClick = " + ((TempleAction.SlideContinuous)it).getLongClick());
            Companion.ensureInterval(new Function0<Unit>() {
               public final void invoke() {
                  RecyclerViewTracker var10000;
                  RecyclerViewTracker var10001;
                  Adapter var4;
                  if (((TempleAction.SlideContinuous)it).getDelta() > 0.0F) {
                     var10001 = RecyclerViewTracker.this;
                     var10001.notifyItemChanged(var10001.getCurrentSelectPos());
                     if (RecyclerViewTracker.this.getLoop()) {
                        var10001 = RecyclerViewTracker.this;
                        var10001.currentSelectPos = var10001.getCurrentSelectPos() + 1;
                        var10000 = RecyclerViewTracker.this;
                        int var3 = var10000.getCurrentSelectPos();
                        Adapter var10002 = ((RecyclerView)RecyclerViewTracker.this.getMPair().getLeft()).getAdapter();
                        Intrinsics.checkNotNull(var10002);
                        var10000.currentSelectPos = var3 % var10002.getItemCount();
                     } else {
                        int var2 = RecyclerViewTracker.this.getCurrentSelectPos();
                        var4 = ((RecyclerView)RecyclerViewTracker.this.getMPair().getLeft()).getAdapter();
                        Intrinsics.checkNotNull(var4);
                        if (var2 < var4.getItemCount() - 1) {
                           var10000 = RecyclerViewTracker.this;
                           var10000.currentSelectPos = var10000.getCurrentSelectPos() + 1;
                        }
                     }
                  } else {
                     var10001 = RecyclerViewTracker.this;
                     var10001.notifyItemChanged(var10001.getCurrentSelectPos());
                     if (RecyclerViewTracker.this.getLoop()) {
                        var10001 = RecyclerViewTracker.this;
                        var10001.currentSelectPos = var10001.getCurrentSelectPos() + -1;
                        if (RecyclerViewTracker.this.getCurrentSelectPos() < 0) {
                           var10000 = RecyclerViewTracker.this;
                           var4 = ((RecyclerView)var10000.getMPair().getLeft()).getAdapter();
                           Intrinsics.checkNotNull(var4);
                           var10000.currentSelectPos = var4.getItemCount() - 1;
                        }
                     } else if (RecyclerViewTracker.this.getCurrentSelectPos() > 0) {
                        var10000 = RecyclerViewTracker.this;
                        var10000.currentSelectPos = var10000.getCurrentSelectPos() + -1;
                     } else {
                        PullToRefreshListener var1;
                        if ((var1 = RecyclerViewTracker.this.getRefreshListener()) != null) {
                           var1.onRefresh();
                        }
                     }
                  }

                  RecyclerViewTracker.smoothScrollToPosition$default(RecyclerViewTracker.this, false, 1, (Object)null);
               }
            });
         } else if (!(it instanceof TempleAction.DoubleClick) && !(it instanceof TempleAction.Click)) {
            if (it instanceof TempleAction.ActionUp) {
               this.preDelta = 0.0F;
               smoothScrollToPosition$default(this, false, 1, (Object)null);
            }
         } else {
            block.invoke(it);
            it.setConsumed(true);
         }

      }
   }

   public final void smoothScrollToPosition(final boolean smoothScroll) {
      FLogger.i("rilke", a.a("smoothScrollToPosition, currentPos = ").append(this.currentSelectPos).toString());
      int var2;
      if ((var2 = this.currentSelectPos) != -1) {
         this.notifyItemChanged(var2);
         this.mPair.update(new Function1<RecyclerView, Unit>() {
            public final void invoke(RecyclerView $this$update) {
               Intrinsics.checkNotNullParameter($this$update, "$this$update");
               if (smoothScroll) {
                  $this$update.smoothScrollToPosition(RecyclerViewTracker.this.getCurrentSelectPos());
                  OnItemFocusListener var2;
                  if (Intrinsics.areEqual(RecyclerViewTracker.this.getMPair().getLeft(), $this$update) && (var2 = RecyclerViewTracker.this.getOnItemFocusListener()) != null) {
                     var2.OnItemFocus(RecyclerViewTracker.this.getCurrentSelectPos(), $this$update);
                  }
               } else {
                  LayoutManager var10000 = $this$update.getLayoutManager();
                  Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                  ((LinearLayoutManager)var10000).scrollToPositionWithOffset(RecyclerViewTracker.this.getCurrentSelectPos(), 0);
               }

            }
         });
      }
   }

   public final int checkedSelectPos() {
      return this.focusObj.getHasFocus() ? this.currentSelectPos : -1;
   }

   public final boolean checkPosSelected(int pos) {
      return this.currentSelectPos == pos && this.focusObj.getHasFocus();
   }

   public final void notifyItemChanged(final int pos) {
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

   public final void notifyFocusChanged() {
      this.notifyItemChanged(this.currentSelectPos);
   }

   public final void notifyDataSetChanged() {
      this.mPair.update(null.INSTANCE);
   }

   @Metadata(
      mv = {1, 7, 1},
      k = 1,
      xi = 48,
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"},
      d2 = {"Lcom/rayneo/arsdk/android/ui/util/RecyclerViewTracker$Companion;", "", "()V", "FLING_SPEED_HIGH", "", "FLING_SPEED_LOW", "TAG", "", "preTime", "", "getPreTime", "()J", "setPreTime", "(J)V", "ensureInterval", "", "block", "Lkotlin/Function0;", "MercurySDK_release"}
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }

      public final long getPreTime() {
         return RecyclerViewTracker.preTime;
      }

      public final void setPreTime(long var1) {
         RecyclerViewTracker.preTime = var1;
      }

      public final void ensureInterval(Function0<Unit> block) {
         Intrinsics.checkNotNullParameter(block, "block");
         long var2;
         if ((var2 = System.currentTimeMillis()) - this.getPreTime() > 300L) {
            this.setPreTime(var2);
            block.invoke();
         }

      }
   }
}
