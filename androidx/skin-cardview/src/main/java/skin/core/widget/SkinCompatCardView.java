package skin.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import androidx.cardview.widget.CardView;
import android.util.AttributeSet;

import skin.core.content.res.SkinCompatResources;
import skin.support.cardview.R;

/**
 * Created by ximsfei on 2017/3/5.
 */

public class SkinCompatCardView extends CardView implements SkinCompatSupportable {
    private static final int[] COLOR_BACKGROUND_ATTR = {android.R.attr.colorBackground};
    private int mThemeColorBackgroundResId = SkinCompatHelper.INVALID_ID;
    private int mBackgroundColorResId = SkinCompatHelper.INVALID_ID;

    public SkinCompatCardView(Context context) {
        this(context, null);
    }

    public SkinCompatCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinCompatCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CardView, defStyleAttr,
                R.style.CardView);
        if (a.hasValue(R.styleable.CardView_cardBackgroundColor)) {
            mBackgroundColorResId = a.getResourceId(R.styleable.CardView_cardBackgroundColor, SkinCompatHelper.INVALID_ID);
        } else {
            final TypedArray aa = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            mThemeColorBackgroundResId = aa.getResourceId(0, SkinCompatHelper.INVALID_ID);
            aa.recycle();
        }
        a.recycle();
        applyBackgroundColorResource();
    }

    private void applyBackgroundColorResource() {
        mBackgroundColorResId = SkinCompatHelper.checkResourceId(mBackgroundColorResId);
        mThemeColorBackgroundResId = SkinCompatHelper.checkResourceId(mThemeColorBackgroundResId);
        ColorStateList backgroundColor;
        if (mBackgroundColorResId != SkinCompatHelper.INVALID_ID) {
            backgroundColor = SkinCompatResources.getColorStateList(getContext(), mBackgroundColorResId);
            setCardBackgroundColor(backgroundColor);
        } else if (mThemeColorBackgroundResId != SkinCompatHelper.INVALID_ID) {
            int themeColorBackground = SkinCompatResources.getColor(getContext(), mThemeColorBackgroundResId);
            final float[] hsv = new float[3];
            Color.colorToHSV(themeColorBackground, hsv);
            backgroundColor = ColorStateList.valueOf(hsv[2] > 0.5f
                    ? getResources().getColor(R.color.cardview_light_background)
                    : getResources().getColor(R.color.cardview_dark_background));
            setCardBackgroundColor(backgroundColor);
        }
    }

    @Override
    public void applySkin() {
        applyBackgroundColorResource();
    }

}
