package com.ffalconxr.mercury.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

public class Request implements Parcelable {
   public static final Creator<Request> CREATOR = new Creator<Request>() {
      public Request createFromParcel(Parcel var1) {
         return new Request(var1);
      }

      public Request[] newArray(int var1) {
         return new Request[var1];
      }
   };
   private String packageName;
   private String data;

   public Request(String var1, String var2) {
      this.packageName = var1;
      this.data = var2;
   }

   public Request(Parcel var1) {
      this.packageName = var1.readString();
      this.data = var1.readString();
   }

   public String getPackageName() {
      return this.packageName;
   }

   public void setPackageName(String var1) {
      this.packageName = var1;
   }

   public String getData() {
      return this.data;
   }

   public void setData(String var1) {
      this.data = var1;
   }

   @NonNull
   public String toString() {
      return "Request{packageName='" + this.packageName + '\'' + ", data='" + this.data + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.packageName);
      var1.writeString(this.data);
   }

   public int describeContents() {
      return 0;
   }
}
