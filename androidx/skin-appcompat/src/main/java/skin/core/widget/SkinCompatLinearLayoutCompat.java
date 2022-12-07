package skin.core.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.LinearLayoutCompat;

/**
 * Created by pengfengwang on 2017/1/13.
 */

public class SkinCompatLinearLayoutCompat extends LinearLayoutCompat implements SkinCompatSupportable {
    private SkinCompatBackgroundHelper mBackgroundTintHelper;

    public SkinCompatLinearLayoutCompat(Context context) {
        this(context, null);
    }

    public SkinCompatLinearLayoutCompat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinCompatLinearLayoutCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBackgroundTintHelper = new SkinCompatBackgroundHelper(this);
        mBackgroundTintHelper.loadFromAttributes(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundResource(resId);
        }
    }

    @Override
    public void applySkin() {
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.applySkin();
        }
    }

}
