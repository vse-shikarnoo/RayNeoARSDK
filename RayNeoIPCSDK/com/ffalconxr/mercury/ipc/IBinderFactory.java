package com.ffalconxr.mercury.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IBinderFactory extends IInterface {
   IBinder generateBinder(int var1);

   public abstract static class Stub extends Binder implements IBinderFactory {
      private static final String DESCRIPTOR = "com.ffalconxr.mercury.ipc.IBinderFactory";
      public static final int TRANSACTION_generateBinder = 1;

      public Stub() {
         this.attachInterface(this, "com.ffalconxr.mercury.ipc.IBinderFactory");
      }

      public static IBinderFactory asInterface(IBinder var0) {
         if (var0 == null) {
            return null;
         } else {
            IInterface var1;
            return (IBinderFactory)((var1 = var0.queryLocalInterface("com.ffalconxr.mercury.ipc.IBinderFactory")) != null && var1 instanceof IBinderFactory ? (IBinderFactory)var1 : new IBinderFactory.Stub.Proxy(var0));
         }
      }

      public static boolean setDefaultImpl(IBinderFactory var0) {
         if (IBinderFactory.Stub.Proxy.sDefaultImpl == null) {
            if (var0 != null) {
               IBinderFactory.Stub.Proxy.sDefaultImpl = var0;
               return true;
            } else {
               return false;
            }
         } else {
            throw new IllegalStateException("setDefaultImpl() called twice");
         }
      }

      public static IBinderFactory getDefaultImpl() {
         return IBinderFactory.Stub.Proxy.sDefaultImpl;
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
         String var5 = "com.ffalconxr.mercury.ipc.IBinderFactory";
         if (var1 != 1) {
            if (var1 != 1598968902) {
               return super.onTransact(var1, var2, var3, var4);
            } else {
               var3.writeString(var5);
               return true;
            }
         } else {
            var2.enforceInterface(var5);
            IBinder var6 = this.generateBinder(var2.readInt());
            var3.writeNoException();
            var3.writeStrongBinder(var6);
            return true;
         }
      }

      private static class Proxy implements IBinderFactory {
         public static IBinderFactory sDefaultImpl;
         private IBinder mRemote;

         public Proxy(IBinder var1) {
            this.mRemote = var1;
         }

         public IBinder asBinder() {
            return this.mRemote;
         }

         public String getInterfaceDescriptor() {
            return "com.ffalconxr.mercury.ipc.IBinderFactory";
         }

         public IBinder generateBinder(int var1) {
            IBinderFactory.Stub.Proxy var10000 = this;
            Parcel var23;
            Parcel var10001 = var23 = Parcel.obtain();
            int var10002 = var1;
            Parcel var10003 = var23;
            Parcel var2 = Parcel.obtain();

            Throwable var24;
            label190: {
               boolean var25;
               boolean var26;
               try {
                  var10003.writeInterfaceToken("com.ffalconxr.mercury.ipc.IBinderFactory");
                  var10001.writeInt(var10002);
                  var25 = var10000.mRemote.transact(1, var23, var2, 0);
               } catch (Throwable var22) {
                  var24 = var22;
                  var26 = false;
                  break label190;
               }

               IBinder var28;
               if (!var25) {
                  IBinderFactory var27;
                  try {
                     var27 = IBinderFactory.Stub.getDefaultImpl();
                  } catch (Throwable var21) {
                     var24 = var21;
                     var26 = false;
                     break label190;
                  }

                  if (var27 != null) {
                     try {
                        var28 = IBinderFactory.Stub.getDefaultImpl().generateBinder(var1);
                     } catch (Throwable var19) {
                        var24 = var19;
                        var26 = false;
                        break label190;
                     }

                     var2.recycle();
                     var23.recycle();
                     return var28;
                  }
               }

               try {
                  var2.readException();
                  var28 = var2.readStrongBinder();
               } catch (Throwable var20) {
                  var24 = var20;
                  var26 = false;
                  break label190;
               }

               var2.recycle();
               var23.recycle();
               return var28;
            }

            var2.recycle();
            var23.recycle();
            throw var24;
         }
      }
   }

   public static class Default implements IBinderFactory {
      public IBinder generateBinder(int var1) {
         return null;
      }

      public IBinder asBinder() {
         return null;
      }
   }
}
