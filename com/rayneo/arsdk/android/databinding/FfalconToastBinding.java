package com.rayneo.arsdk.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rayneo.arsdk.android.R.id;
import com.rayneo.arsdk.android.R.layout;

public final class FfalconToastBinding implements ViewBinding {
   private final FrameLayout rootView;
   public final FrameLayout container;
   public final TextView tvToast;

   private FfalconToastBinding(FrameLayout rootView, FrameLayout container, TextView tvToast) {
      this.rootView = rootView;
      this.container = container;
      this.tvToast = tvToast;
   }

   public static FfalconToastBinding inflate(LayoutInflater inflater) {
      return inflate(inflater, (ViewGroup)null, false);
   }

   public static FfalconToastBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
      View inflater1 = inflater.inflate(layout.ffalcon_toast, parent, false);
      if (attachToParent) {
         parent.addView(inflater1);
      }

      return bind(inflater1);
   }

   public static FfalconToastBinding bind(View rootView) {
      FrameLayout var1 = (FrameLayout)rootView;
      int var2;
      TextView var3;
      if ((var3 = (TextView)ViewBindings.findChildViewById(rootView, var2 = id.tv_toast)) != null) {
         return new FfalconToastBinding(var1, var1, var3);
      } else {
         String rootView1 = rootView.getResources().getResourceName(var2);
         throw new NullPointerException("Missing required view with ID: ".concat(rootView1));
      }
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
