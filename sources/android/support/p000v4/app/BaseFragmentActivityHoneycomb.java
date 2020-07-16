package android.support.p000v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v4.app.BaseFragmentActivityHoneycomb */
abstract class BaseFragmentActivityHoneycomb extends BaseFragmentActivityDonut {
    BaseFragmentActivityHoneycomb() {
    }

    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View v = dispatchFragmentsOnCreateView(parent, name, context, attrs);
        if (v != null || VERSION.SDK_INT < 11) {
            return v;
        }
        return super.onCreateView(parent, name, context, attrs);
    }
}
