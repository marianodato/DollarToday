package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.playlog.internal.zza$zza reason: collision with other inner class name */
    public static abstract class C0547zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.playlog.internal.zza$zza$zza reason: collision with other inner class name */
        private static class C0548zza implements zza {
            private IBinder zznJ;

            C0548zza(IBinder iBinder) {
                this.zznJ = iBinder;
            }

            public IBinder asBinder() {
                return this.zznJ;
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (logEvent != null) {
                        obtain.writeInt(1);
                        logEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznJ.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.zznJ.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zznJ.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zza zzdz(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C0548zza(iBinder) : (zza) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.playlog.internal.PlayLoggerContext] */
        /* JADX WARNING: type inference failed for: r1v3, types: [com.google.android.gms.playlog.internal.PlayLoggerContext] */
        /* JADX WARNING: type inference failed for: r1v4, types: [com.google.android.gms.playlog.internal.PlayLoggerContext] */
        /* JADX WARNING: type inference failed for: r1v6, types: [com.google.android.gms.playlog.internal.PlayLoggerContext] */
        /* JADX WARNING: type inference failed for: r1v7, types: [com.google.android.gms.playlog.internal.LogEvent] */
        /* JADX WARNING: type inference failed for: r1v9, types: [com.google.android.gms.playlog.internal.LogEvent] */
        /* JADX WARNING: type inference failed for: r1v10 */
        /* JADX WARNING: type inference failed for: r1v11 */
        /* JADX WARNING: type inference failed for: r1v12 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.playlog.internal.PlayLoggerContext, com.google.android.gms.playlog.internal.LogEvent]
          uses: [com.google.android.gms.playlog.internal.PlayLoggerContext, com.google.android.gms.playlog.internal.LogEvent]
          mth insns count: 45
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 4 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r1 = 0
                r2 = 1
                switch(r6) {
                    case 2: goto L_0x0011;
                    case 3: goto L_0x0039;
                    case 4: goto L_0x0059;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r8.writeString(r0)
                r0 = r2
                goto L_0x0009
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r3 = r7.readString()
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0037
                com.google.android.gms.playlog.internal.zze r0 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r0 = r0.createFromParcel(r7)
            L_0x0026:
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x0032
                com.google.android.gms.playlog.internal.zzc r1 = com.google.android.gms.playlog.internal.LogEvent.CREATOR
                com.google.android.gms.playlog.internal.LogEvent r1 = r1.createFromParcel(r7)
            L_0x0032:
                r5.zza(r3, r0, r1)
                r0 = r2
                goto L_0x0009
            L_0x0037:
                r0 = r1
                goto L_0x0026
            L_0x0039:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x004e
                com.google.android.gms.playlog.internal.zze r1 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r1 = r1.createFromParcel(r7)
            L_0x004e:
                com.google.android.gms.playlog.internal.zzc r3 = com.google.android.gms.playlog.internal.LogEvent.CREATOR
                java.util.ArrayList r3 = r7.createTypedArrayList(r3)
                r5.zza(r0, r1, r3)
                r0 = r2
                goto L_0x0009
            L_0x0059:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x006e
                com.google.android.gms.playlog.internal.zze r1 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r1 = r1.createFromParcel(r7)
            L_0x006e:
                byte[] r3 = r7.createByteArray()
                r5.zza(r0, r1, r3)
                r0 = r2
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zza.C0547zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException;
}
