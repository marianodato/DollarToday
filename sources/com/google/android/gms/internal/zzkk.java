package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public interface zzkk extends IInterface {

    public static abstract class zza extends Binder implements zzkk {

        /* renamed from: com.google.android.gms.internal.zzkk$zza$zza reason: collision with other inner class name */
        private static class C0541zza implements zzkk {
            private IBinder zznJ;

            C0541zza(IBinder iBinder) {
                this.zznJ = iBinder;
            }

            public IBinder asBinder() {
                return this.zznJ;
            }

            public void zza(zzkj zzkj, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zzkj != null ? zzkj.asBinder() : null);
                    if (proxyGrpcRequest != null) {
                        obtain.writeInt(1);
                        proxyGrpcRequest.writeToParcel(obtain, 0);
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

            public void zza(zzkj zzkj, ProxyRequest proxyRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zzkj != null ? zzkj.asBinder() : null);
                    if (proxyRequest != null) {
                        obtain.writeInt(1);
                        proxyRequest.writeToParcel(obtain, 0);
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
        }

        public static zzkk zzaw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkk)) ? new C0541zza(iBinder) : (zzkk) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.auth.api.proxy.ProxyGrpcRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.auth.api.proxy.ProxyGrpcRequest] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.auth.api.proxy.ProxyRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.auth.api.proxy.ProxyRequest] */
        /* JADX WARNING: type inference failed for: r0v14 */
        /* JADX WARNING: type inference failed for: r0v15 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.auth.api.proxy.ProxyRequest, com.google.android.gms.auth.api.proxy.ProxyGrpcRequest]
          uses: [com.google.android.gms.auth.api.proxy.ProxyGrpcRequest, com.google.android.gms.auth.api.proxy.ProxyRequest]
          mth insns count: 33
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
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0034;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.auth.api.internal.IAuthService"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.auth.api.internal.IAuthService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.zzkj r2 = com.google.android.gms.internal.zzkj.zza.zzav(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x002c
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.proxy.ProxyRequest> r0 = com.google.android.gms.auth.api.proxy.ProxyRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.proxy.ProxyRequest r0 = (com.google.android.gms.auth.api.proxy.ProxyRequest) r0
            L_0x002c:
                r4.zza(r2, r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0034:
                java.lang.String r2 = "com.google.android.gms.auth.api.internal.IAuthService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.zzkj r2 = com.google.android.gms.internal.zzkj.zza.zzav(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x004f
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.proxy.ProxyGrpcRequest> r0 = com.google.android.gms.auth.api.proxy.ProxyGrpcRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.proxy.ProxyGrpcRequest r0 = (com.google.android.gms.auth.api.proxy.ProxyGrpcRequest) r0
            L_0x004f:
                r4.zza(r2, r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzkk.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(zzkj zzkj, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException;

    void zza(zzkj zzkj, ProxyRequest proxyRequest) throws RemoteException;
}
