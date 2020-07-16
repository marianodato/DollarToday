package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;

public interface zzf extends IInterface {

    public static abstract class zza extends Binder implements zzf {

        /* renamed from: com.google.android.gms.signin.internal.zzf$zza$zza reason: collision with other inner class name */
        private static class C0550zza implements zzf {
            private IBinder zznJ;

            C0550zza(IBinder iBinder) {
                this.zznJ = iBinder;
            }

            public IBinder asBinder() {
                return this.zznJ;
            }

            public void zza(int i, Account account, zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zznJ.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthAccountRequest authAccountRequest, zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest != null) {
                        obtain.writeInt(1);
                        authAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zznJ.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ResolveAccountRequest resolveAccountRequest, zzt zzt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest != null) {
                        obtain.writeInt(1);
                        resolveAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    this.zznJ.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzp zzp, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzp != null ? zzp.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zznJ.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult != null) {
                        obtain.writeInt(1);
                        checkServerAuthResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznJ.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RecordConsentRequest recordConsentRequest, zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (recordConsentRequest != null) {
                        obtain.writeInt(1);
                        recordConsentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zznJ.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zznJ.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaq(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznJ.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzjq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.zznJ.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzf zzdN(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new C0550zza(iBinder) : (zzf) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.signin.internal.RecordConsentRequest] */
        /* JADX WARNING: type inference failed for: r0v7, types: [com.google.android.gms.signin.internal.RecordConsentRequest] */
        /* JADX WARNING: type inference failed for: r0v11, types: [android.accounts.Account] */
        /* JADX WARNING: type inference failed for: r0v14, types: [android.accounts.Account] */
        /* JADX WARNING: type inference failed for: r0v17, types: [com.google.android.gms.common.internal.ResolveAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.common.internal.ResolveAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v26, types: [com.google.android.gms.signin.internal.CheckServerAuthResult] */
        /* JADX WARNING: type inference failed for: r0v29, types: [com.google.android.gms.signin.internal.CheckServerAuthResult] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.common.internal.AuthAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v33, types: [com.google.android.gms.common.internal.AuthAccountRequest] */
        /* JADX WARNING: type inference failed for: r0v35 */
        /* JADX WARNING: type inference failed for: r0v36 */
        /* JADX WARNING: type inference failed for: r0v37 */
        /* JADX WARNING: type inference failed for: r0v38 */
        /* JADX WARNING: type inference failed for: r0v39 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.accounts.Account, com.google.android.gms.signin.internal.RecordConsentRequest, com.google.android.gms.common.internal.ResolveAccountRequest, com.google.android.gms.signin.internal.CheckServerAuthResult, com.google.android.gms.common.internal.AuthAccountRequest]
          uses: [com.google.android.gms.signin.internal.RecordConsentRequest, android.accounts.Account, com.google.android.gms.common.internal.ResolveAccountRequest, com.google.android.gms.signin.internal.CheckServerAuthResult, com.google.android.gms.common.internal.AuthAccountRequest]
          mth insns count: 105
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
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r2 = 0
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 2: goto L_0x0011;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x004d;
                    case 5: goto L_0x0062;
                    case 7: goto L_0x0084;
                    case 8: goto L_0x0095;
                    case 9: goto L_0x00bc;
                    case 10: goto L_0x00dc;
                    case 11: goto L_0x00ff;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r1 = super.onTransact(r6, r7, r8, r9)
            L_0x000a:
                return r1
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r8.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.AuthAccountRequest> r0 = com.google.android.gms.common.internal.AuthAccountRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.common.internal.AuthAccountRequest r0 = (com.google.android.gms.common.internal.AuthAccountRequest) r0
            L_0x0024:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zze r2 = com.google.android.gms.signin.internal.zze.zza.zzdM(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                goto L_0x000a
            L_0x0033:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0046
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.CheckServerAuthResult> r0 = com.google.android.gms.signin.internal.CheckServerAuthResult.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.signin.internal.CheckServerAuthResult r0 = (com.google.android.gms.signin.internal.CheckServerAuthResult) r0
            L_0x0046:
                r5.zza(r0)
                r8.writeNoException()
                goto L_0x000a
            L_0x004d:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0060
                r0 = r1
            L_0x0059:
                r5.zzaq(r0)
                r8.writeNoException()
                goto L_0x000a
            L_0x0060:
                r0 = r2
                goto L_0x0059
            L_0x0062:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0075
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.ResolveAccountRequest> r0 = com.google.android.gms.common.internal.ResolveAccountRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.common.internal.ResolveAccountRequest r0 = (com.google.android.gms.common.internal.ResolveAccountRequest) r0
            L_0x0075:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.common.internal.zzt r2 = com.google.android.gms.common.internal.zzt.zza.zzaL(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                goto L_0x000a
            L_0x0084:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                r5.zzjq(r0)
                r8.writeNoException()
                goto L_0x000a
            L_0x0095:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x00ac
                android.os.Parcelable$Creator r0 = android.accounts.Account.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.accounts.Account r0 = (android.accounts.Account) r0
            L_0x00ac:
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zze r3 = com.google.android.gms.signin.internal.zze.zza.zzdM(r3)
                r5.zza(r2, r0, r3)
                r8.writeNoException()
                goto L_0x000a
            L_0x00bc:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.common.internal.zzp r0 = com.google.android.gms.common.internal.zzp.zza.zzaH(r0)
                int r3 = r7.readInt()
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x00d4
                r2 = r1
            L_0x00d4:
                r5.zza(r0, r3, r2)
                r8.writeNoException()
                goto L_0x000a
            L_0x00dc:
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00ef
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.RecordConsentRequest> r0 = com.google.android.gms.signin.internal.RecordConsentRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.signin.internal.RecordConsentRequest r0 = (com.google.android.gms.signin.internal.RecordConsentRequest) r0
            L_0x00ef:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zze r2 = com.google.android.gms.signin.internal.zze.zza.zzdM(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                goto L_0x000a
            L_0x00ff:
                java.lang.String r0 = "com.google.android.gms.signin.internal.ISignInService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zze r0 = com.google.android.gms.signin.internal.zze.zza.zzdM(r0)
                r5.zza(r0)
                r8.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.signin.internal.zzf.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(int i, Account account, zze zze) throws RemoteException;

    void zza(AuthAccountRequest authAccountRequest, zze zze) throws RemoteException;

    void zza(ResolveAccountRequest resolveAccountRequest, zzt zzt) throws RemoteException;

    void zza(zzp zzp, int i, boolean z) throws RemoteException;

    void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void zza(RecordConsentRequest recordConsentRequest, zze zze) throws RemoteException;

    void zza(zze zze) throws RemoteException;

    void zzaq(boolean z) throws RemoteException;

    void zzjq(int i) throws RemoteException;
}
