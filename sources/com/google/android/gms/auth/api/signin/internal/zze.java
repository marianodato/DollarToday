package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zze$zza$zza reason: collision with other inner class name */
        private static class C0523zza implements zze {
            private IBinder zznJ;

            C0523zza(IBinder iBinder) {
                this.zznJ = iBinder;
            }

            public IBinder asBinder() {
                return this.zznJ;
            }

            public void zza(zzd zzd, GoogleSignInConfig googleSignInConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (googleSignInConfig != null) {
                        obtain.writeInt(1);
                        googleSignInConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznJ.transact(101, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznJ.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzd zzd, GoogleSignInConfig googleSignInConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (googleSignInConfig != null) {
                        obtain.writeInt(1);
                        googleSignInConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznJ.transact(102, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzd zzd, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznJ.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzd zzd, GoogleSignInConfig googleSignInConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (googleSignInConfig != null) {
                        obtain.writeInt(1);
                        googleSignInConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznJ.transact(103, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzaz(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new C0523zza(iBinder) : (zze) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.auth.api.signin.GoogleSignInConfig] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.auth.api.signin.GoogleSignInConfig] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.auth.api.signin.GoogleSignInConfig] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.auth.api.signin.GoogleSignInConfig] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.auth.api.signin.GoogleSignInConfig] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.auth.api.signin.GoogleSignInConfig] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.auth.api.signin.internal.SignInConfiguration] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.auth.api.signin.internal.SignInConfiguration] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.android.gms.auth.api.signin.internal.SignInConfiguration] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.auth.api.signin.internal.SignInConfiguration] */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: type inference failed for: r0v30 */
        /* JADX WARNING: type inference failed for: r0v31 */
        /* JADX WARNING: type inference failed for: r0v32 */
        /* JADX WARNING: type inference failed for: r0v33 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.auth.api.signin.GoogleSignInConfig, com.google.android.gms.auth.api.signin.internal.SignInConfiguration]
          uses: [com.google.android.gms.auth.api.signin.GoogleSignInConfig, com.google.android.gms.auth.api.signin.internal.SignInConfiguration]
          mth insns count: 72
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0034;
                    case 101: goto L_0x0057;
                    case 102: goto L_0x007a;
                    case 103: goto L_0x009e;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.auth.api.signin.internal.ISignInService"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.auth.api.signin.internal.ISignInService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.signin.internal.zzd r2 = com.google.android.gms.auth.api.signin.internal.zzd.zza.zzay(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x002c
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.signin.internal.SignInConfiguration> r0 = com.google.android.gms.auth.api.signin.internal.SignInConfiguration.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.signin.internal.SignInConfiguration r0 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r0
            L_0x002c:
                r4.zza(r2, r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0034:
                java.lang.String r2 = "com.google.android.gms.auth.api.signin.internal.ISignInService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.signin.internal.zzd r2 = com.google.android.gms.auth.api.signin.internal.zzd.zza.zzay(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x004f
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.signin.internal.SignInConfiguration> r0 = com.google.android.gms.auth.api.signin.internal.SignInConfiguration.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.signin.internal.SignInConfiguration r0 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r0
            L_0x004f:
                r4.zzb(r2, r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0057:
                java.lang.String r2 = "com.google.android.gms.auth.api.signin.internal.ISignInService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.signin.internal.zzd r2 = com.google.android.gms.auth.api.signin.internal.zzd.zza.zzay(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0072
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.signin.GoogleSignInConfig> r0 = com.google.android.gms.auth.api.signin.GoogleSignInConfig.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.signin.GoogleSignInConfig r0 = (com.google.android.gms.auth.api.signin.GoogleSignInConfig) r0
            L_0x0072:
                r4.zza(r2, r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x007a:
                java.lang.String r2 = "com.google.android.gms.auth.api.signin.internal.ISignInService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.signin.internal.zzd r2 = com.google.android.gms.auth.api.signin.internal.zzd.zza.zzay(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0095
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.signin.GoogleSignInConfig> r0 = com.google.android.gms.auth.api.signin.GoogleSignInConfig.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.signin.GoogleSignInConfig r0 = (com.google.android.gms.auth.api.signin.GoogleSignInConfig) r0
            L_0x0095:
                r4.zzb(r2, r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x009e:
                java.lang.String r2 = "com.google.android.gms.auth.api.signin.internal.ISignInService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.signin.internal.zzd r2 = com.google.android.gms.auth.api.signin.internal.zzd.zza.zzay(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x00b9
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.signin.GoogleSignInConfig> r0 = com.google.android.gms.auth.api.signin.GoogleSignInConfig.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.signin.GoogleSignInConfig r0 = (com.google.android.gms.auth.api.signin.GoogleSignInConfig) r0
            L_0x00b9:
                r4.zzc(r2, r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zze.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(zzd zzd, GoogleSignInConfig googleSignInConfig) throws RemoteException;

    void zza(zzd zzd, SignInConfiguration signInConfiguration) throws RemoteException;

    void zzb(zzd zzd, GoogleSignInConfig googleSignInConfig) throws RemoteException;

    void zzb(zzd zzd, SignInConfiguration signInConfiguration) throws RemoteException;

    void zzc(zzd zzd, GoogleSignInConfig googleSignInConfig) throws RemoteException;
}
