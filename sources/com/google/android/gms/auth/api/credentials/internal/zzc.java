package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;

public final class zzc implements CredentialsApi {

    private static class zza extends zza {
        private zzb<Status> zzSI;

        zza(zzb<Status> zzb) {
            this.zzSI = zzb;
        }

        public void zzg(Status status) {
            this.zzSI.zzp(status);
        }
    }

    public PendingResult<Status> delete(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zzd<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzh zzh) throws RemoteException {
                zzh.zza((zzg) new zza(this), new DeleteRequest(credential));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient client) {
        return client.zzb(new zzd<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzh zzh) throws RemoteException {
                zzh.zza(new zza(this));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient client, final CredentialRequest request) {
        return client.zza(new zzd<CredentialRequestResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzh zzh) throws RemoteException {
                zzh.zza((zzg) new zza() {
                    public void zza(Status status, Credential credential) {
                        C02561.this.zzb((Result) new zzb(status, credential));
                    }

                    public void zzg(Status status) {
                        C02561.this.zzb((Result) zzb.zzh(status));
                    }
                }, request);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzi */
            public CredentialRequestResult zzb(Status status) {
                return zzb.zzh(status);
            }
        });
    }

    public PendingResult<Status> save(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zzd<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzh zzh) throws RemoteException {
                zzh.zza((zzg) new zza(this), new SaveRequest(credential));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
