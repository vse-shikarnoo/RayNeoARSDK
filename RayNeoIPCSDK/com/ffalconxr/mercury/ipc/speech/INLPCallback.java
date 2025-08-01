package com.ffalconxr.mercury.ipc.speech;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface INLPCallback extends IInterface {
   void onSpeechResult(SpeechResult var1, boolean var2);

   public abstract static class Stub extends Binder implements INLPCallback {
      private static final String DESCRIPTOR = "com.ffalconxr.mercury.ipc.speech.INLPCallback";
      public static final int TRANSACTION_onSpeechResult = 1;

      public Stub() {
         this.attachInterface(this, "com.ffalconxr.mercury.ipc.speech.INLPCallback");
      }

      public static INLPCallback asInterface(IBinder var0) {
         if (var0 == null) {
            return null;
         } else {
            IInterface var1;
            return (INLPCallback)((var1 = var0.queryLocalInterface("com.ffalconxr.mercury.ipc.speech.INLPCallback")) != null && var1 instanceof INLPCallback ? (INLPCallback)var1 : new INLPCallback.Stub.Proxy(var0));
         }
      }

      public static boolean setDefaultImpl(INLPCallback var0) {
         if (INLPCallback.Stub.Proxy.sDefaultImpl == null) {
            if (var0 != null) {
               INLPCallback.Stub.Proxy.sDefaultImpl = var0;
               return true;
            } else {
               return false;
            }
         } else {
            throw new IllegalStateException("setDefaultImpl() called twice");
         }
      }

      public static INLPCallback getDefaultImpl() {
         return INLPCallback.Stub.Proxy.sDefaultImpl;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
         String var5 = "com.ffalconxr.mercury.ipc.speech.INLPCallback";
         if (var1 != 1) {
            if (var1 != 1598968902) {
               return super.onTransact(var1, var2, var3, var4);
            } else {
               var3.writeString(var5);
               return true;
            }
         } else {
            var2.enforceInterface(var5);
            SpeechResult var6;
            if (var2.readInt() != 0) {
               var6 = (SpeechResult)SpeechResult.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            boolean var7;
            if (var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.onSpeechResult(var6, var7);
            var3.writeNoException();
            return true;
         }
      }

      private static class Proxy implements INLPCallback {
         public static INLPCallback sDefaultImpl;
         private IBinder mRemote;

         public Proxy(IBinder var1) {
            this.mRemote = var1;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "com.ffalconxr.mercury.ipc.speech.INLPCallback";
         }

         public void onSpeechResult(SpeechResult param1, boolean param2) {
            // $FF: Couldn't be decompiled
         }
      }
   }

   public static class Default implements INLPCallback {
      public void onSpeechResult(SpeechResult var1, boolean var2) {
      }

      public IBinder asBinder() {
         return null;
      }
   }
}
