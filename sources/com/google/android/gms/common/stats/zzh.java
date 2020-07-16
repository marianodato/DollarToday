package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh implements Creator<WakeLockEvent> {
    static void zza(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, wakeLockEvent.mVersionCode);
        zzb.zza(parcel, 2, wakeLockEvent.getTimeMillis());
        zzb.zza(parcel, 4, wakeLockEvent.zzqj(), false);
        zzb.zzc(parcel, 5, wakeLockEvent.zzql());
        zzb.zzb(parcel, 6, wakeLockEvent.zzqm(), false);
        zzb.zza(parcel, 8, wakeLockEvent.zzqf());
        zzb.zza(parcel, 10, wakeLockEvent.zzqk(), false);
        zzb.zzc(parcel, 11, wakeLockEvent.getEventType());
        zzb.zza(parcel, 12, wakeLockEvent.zzqc(), false);
        zzb.zza(parcel, 13, wakeLockEvent.zzqo(), false);
        zzb.zzc(parcel, 14, wakeLockEvent.zzqn());
        zzb.zza(parcel, 15, wakeLockEvent.zzqp());
        zzb.zza(parcel, 16, wakeLockEvent.zzqq());
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzaB */
    public WakeLockEvent createFromParcel(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        ArrayList arrayList = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 6:
                    arrayList = zza.zzD(parcel, zzao);
                    break;
                case 8:
                    j2 = zza.zzi(parcel, zzao);
                    break;
                case 10:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 12:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 13:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 14:
                    i4 = zza.zzg(parcel, zzao);
                    break;
                case 15:
                    f = zza.zzl(parcel, zzao);
                    break;
                case 16:
                    j3 = zza.zzi(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }

    /* renamed from: zzbZ */
    public WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
