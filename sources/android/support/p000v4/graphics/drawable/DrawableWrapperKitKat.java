package android.support.p000v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperKitKat */
class DrawableWrapperKitKat extends DrawableWrapperHoneycomb {

    /* renamed from: android.support.v4.graphics.drawable.DrawableWrapperKitKat$DrawableWrapperStateKitKat */
    private static class DrawableWrapperStateKitKat extends DrawableWrapperState {
        DrawableWrapperStateKitKat(@Nullable DrawableWrapperState orig, @Nullable Resources res) {
            super(orig, res);
        }

        public Drawable newDrawable(@Nullable Resources res) {
            return new DrawableWrapperKitKat(this, res);
        }
    }

    DrawableWrapperKitKat(Drawable drawable) {
        super(drawable);
    }

    DrawableWrapperKitKat(DrawableWrapperState state, Resources resources) {
        super(state, resources);
    }

    public void setAutoMirrored(boolean mirrored) {
        this.mDrawable.setAutoMirrored(mirrored);
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    /* access modifiers changed from: 0000 */
    public DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateKitKat(this.mState, null);
    }
}
