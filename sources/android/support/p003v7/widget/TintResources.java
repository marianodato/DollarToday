package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/* renamed from: android.support.v7.widget.TintResources */
public class TintResources extends Resources {
    private final Context mContext;

    public TintResources(@NonNull Context context, @NonNull Resources res) {
        super(res.getAssets(), res.getDisplayMetrics(), res.getConfiguration());
        this.mContext = context;
    }

    public Drawable getDrawable(int id) throws NotFoundException {
        return AppCompatDrawableManager.get().onDrawableLoadedFromResources(this.mContext, this, id);
    }

    /* access modifiers changed from: 0000 */
    public final Drawable superGetDrawable(int id) {
        return super.getDrawable(id);
    }
}
