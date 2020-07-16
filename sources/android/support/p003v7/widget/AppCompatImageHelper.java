package android.support.p003v7.widget;

import android.graphics.drawable.Drawable;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.appcompat.C0188R;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.AppCompatImageHelper */
class AppCompatImageHelper {
    private final AppCompatDrawableManager mDrawableManager;
    private final ImageView mView;

    AppCompatImageHelper(ImageView view, AppCompatDrawableManager drawableManager) {
        this.mView = view;
        this.mDrawableManager = drawableManager;
    }

    /* access modifiers changed from: 0000 */
    public void loadFromAttributes(AttributeSet attrs, int defStyleAttr) {
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attrs, C0188R.styleable.AppCompatImageView, defStyleAttr, 0);
        try {
            Drawable d = a.getDrawableIfKnown(C0188R.styleable.AppCompatImageView_android_src);
            if (d != null) {
                this.mView.setImageDrawable(d);
            }
            int id = a.getResourceId(C0188R.styleable.AppCompatImageView_srcCompat, -1);
            if (id != -1) {
                Drawable d2 = this.mDrawableManager.getDrawable(this.mView.getContext(), id);
                if (d2 != null) {
                    this.mView.setImageDrawable(d2);
                }
            }
            Drawable drawable = this.mView.getDrawable();
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
        } finally {
            a.recycle();
        }
    }

    /* access modifiers changed from: 0000 */
    public void setImageResource(int resId) {
        if (resId != 0) {
            Drawable d = this.mDrawableManager != null ? this.mDrawableManager.getDrawable(this.mView.getContext(), resId) : ContextCompat.getDrawable(this.mView.getContext(), resId);
            if (d != null) {
                DrawableUtils.fixDrawable(d);
            }
            this.mView.setImageDrawable(d);
            return;
        }
        this.mView.setImageDrawable(null);
    }
}
