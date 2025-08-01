package com.ffalconxr.mercury.ipc.speech;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SpeechResult implements Parcelable {
   public static final Creator<SpeechResult> CREATOR = new Creator<SpeechResult>() {
      public SpeechResult createFromParcel(Parcel var1) {
         return new SpeechResult(var1);
      }

      public SpeechResult[] newArray(int var1) {
         return new SpeechResult[var1];
      }
   };
   public String nlpResult;
   public int eventType;
   public int arg1;
   public int arg2;
   public String info;

   public SpeechResult(String var1) {
      this.nlpResult = var1;
   }

   public SpeechResult(Parcel var1) {
      this.nlpResult = var1.readString();
      this.eventType = var1.readInt();
      this.arg1 = var1.readInt();
      this.arg2 = var1.readInt();
      this.info = var1.readString();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.nlpResult);
      var1.writeInt(this.eventType);
      var1.writeInt(this.arg1);
      var1.writeInt(this.arg2);
      var1.writeString(this.info);
   }
}
