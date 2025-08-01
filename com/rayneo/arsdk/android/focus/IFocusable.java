package com.rayneo.arsdk.android.focus;

import kotlin.Metadata;

@Metadata(
   mv = {1, 7, 1},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"},
   d2 = {"Lcom/rayneo/arsdk/android/focus/IFocusable;", "", "focusParent", "getFocusParent", "()Lcom/rayneo/arsdk/android/focus/IFocusable;", "setFocusParent", "(Lcom/rayneo/arsdk/android/focus/IFocusable;)V", "hasFocus", "", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "MercurySDK_release"}
)
public interface IFocusable {
   boolean getHasFocus();

   void setHasFocus(boolean var1);

   IFocusable getFocusParent();

   void setFocusParent(IFocusable var1);
}
