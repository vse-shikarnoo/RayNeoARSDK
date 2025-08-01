package com.ffalconxr.mercury.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.List;

public class Response implements Parcelable {
   public static final Creator<Response> CREATOR = new Creator<Response>() {
      public Response createFromParcel(Parcel var1) {
         return new Response(var1);
      }

      public Response[] newArray(int var1) {
         return new Response[var1];
      }
   };
   public List<String> packages;
   public String data;

   public Response(List<String> var1, String var2) {
      this.packages = var1;
      this.data = var2;
   }

   public Response(Parcel var1) {
      this.packages = var1.createStringArrayList();
      this.data = var1.readString();
   }

   public List<String> getPackages() {
      return this.packages;
   }

   public void setPackages(List<String> var1) {
      this.packages = var1;
   }

   public String getData() {
      return this.data;
   }

   public void setData(String var1) {
      this.data = var1;
   }

   @NonNull
   public String toString() {
      return "Response{packages=" + this.packages + ", data='" + this.data + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeStringList(this.packages);
      var1.writeString(this.data);
   }

   public int describeContents() {
      return 0;
   }
}
