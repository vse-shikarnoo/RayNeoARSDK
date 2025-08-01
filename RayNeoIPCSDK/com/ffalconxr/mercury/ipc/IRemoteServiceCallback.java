package com.ffalconxr.mercury.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IRemoteServiceCallback extends IInterface {
   void onResponse(Response var1);

   public abstract static class Stub extends Binder implements IRemoteServiceCallback {
      private static final String DESCRIPTOR = "com.ffalconxr.mercury.ipc.IRemoteServiceCallback";
      public static final int TRANSACTION_onResponse = 1;

      public Stub() {
         this.attachInterface(this, "com.ffalconxr.mercury.ipc.IRemoteServiceCallback");
      }

      public static IRemoteServiceCallback asInterface(IBinder var0) {
         if (var0 == null) {
            return null;
         } else {
            IInterface var1;
            return (IRemoteServiceCallback)((var1 = var0.queryLocalInterface("com.ffalconxr.mercury.ipc.IRemoteServiceCallback")) != null && var1 instanceof IRemoteServiceCallback ? (IRemoteServiceCallback)var1 : new IRemoteServiceCallback.Stub.Proxy(var0));
         }
      }

      public static boolean setDefaultImpl(IRemoteServiceCallback var0) {
         if (IRemoteServiceCallback.Stub.Proxy.sDefaultImpl == null) {
            if (var0 != null) {
               IRemoteServiceCallback.Stub.Proxy.sDefaultImpl = var0;
               return true;
            } else {
               return false;
            }
         } else {
            throw new IllegalStateException("setDefaultImpl() called twice");
         }
      }

      public static IRemoteServiceCallback getDefaultImpl() {
         return IRemoteServiceCallback.Stub.Proxy.sDefaultImpl;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
         String var5 = "com.ffalconxr.mercury.ipc.IRemoteServiceCallback";
         if (var1 != 1) {
            if (var1 != 1598968902) {
               return super.onTransact(var1, var2, var3, var4);
            } else {
               var3.writeString(var5);
               return true;
            }
         } else {
            var2.enforceInterface(var5);
            Response var6;
            if (var2.readInt() != 0) {
               var6 = (Response)Response.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.onResponse(var6);
            var3.writeNoException();
            return true;
         }
      }

      public static class Proxy implements IRemoteServiceCallback {
         public static IRemoteServiceCallback sDefaultImpl;
         private IBinder mRemote;

         public Proxy(IBinder var1) {
            this.mRemote = var1;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "com.ffalconxr.mercury.ipc.IRemoteServiceCallback";
         }

         public void onResponse(Response param1) {
            // $FF: Couldn't be decompiled
         }
      }
   }

   public static class Default implements IRemoteServiceCallback {
      public void onResponse(Response var1) {
      }

      public IBinder asBinder() {
         return null;
      }
   }
}
