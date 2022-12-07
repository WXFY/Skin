package skin.core.flycotablayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.DrawableRes;
import android.util.AttributeSet;

import com.flyco.tablayout.SlidingTabLayout;

import skin.core.content.res.SkinCompatResources;
import skin.core.widget.SkinCompatBackgroundHelper;
import skin.core.widget.SkinCompatHelper;
import skin.core.widget.SkinCompatSupportable;
import skin.support.flycotablayout.R;

/**
 * Created by ximsf on 2017/3/8.
 */

public class SkinSlidingTabLayout extends SlidingTabLayout implements SkinCompatSupportable {
    private SkinCompatBackgroundHelper mBackgroundTintHelper;
    private int mIndicatorColorResId = SkinCompatHelper.INVALID_ID;
    private int mUnderlineColorResId = SkinCompatHelper.INVALID_ID;
    private int mDividerColorResId = SkinCompatHelper.INVALID_ID;
    private int mTextSelectColorResId = SkinCompatHelper.INVALID_ID;
    private int mTextUnselectColorResId = SkinCompatHelper.INVALID_ID;

    public SkinSlidingTabLayout(Context context) {
        this(context, null, 0);
    }

    public SkinSlidingTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinSlidingTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        obtainAttributes(context, attrs);
        mBackgroundTintHelper = new SkinCompatBackgroundHelper(this);
        mBackgroundTintHelper.loadFromAttributes(attrs, defStyleAttr);
    }

    private void obtainAttributes(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SlidingTabLayout);
        mIndicatorColorResId = ta.getResourceId(R.styleable.SlidingTabLayout_tl_indicator_color, SkinCompatHelper.INVALID_ID);
        mIndicatorColorResId = SkinCompatHelper.checkResourceId(mIndicatorColorResId);
        mUnderlineColorResId = ta.getResourceId(R.styleable.SlidingTabLayout_tl_underline_color, SkinCompatHelper.INVALID_ID);
        mUnderlineColorResId = SkinCompatHelper.checkResourceId(mUnderlineColorResId);
        mDividerColorResId = ta.getResourceId(R.styleable.SlidingTabLayout_tl_divider_color, SkinCompatHelper.INVALID_ID);
        mDividerColorResId = SkinCompatHelper.checkResourceId(mDividerColorResId);
        mTextSelectColorResId = ta.getResourceId(R.styleable.SlidingTabLayout_tl_textSelectColor, SkinCompatHelper.INVALID_ID);
        mTextSelectColorResId = SkinCompatHelper.checkResourceId(mTextSelectColorResId);
        mTextUnselectColorResId = ta.getResourceId(R.styleable.SlidingTabLayout_tl_textUnselectColor, SkinCompatHelper.INVALID_ID);
        mTextUnselectColorResId = SkinCompatHelper.checkResourceId(mTextUnselectColorResId);
        ta.recycle();
        applySlidingTabLayoutResources();
    }

    @Override
    public void setBackgroundResource(@DrawableRes int resId) {
        super.setBackgroundResource(resId);
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundResource(resId);
        }
    }

    private void applySlidingTabLayoutResources() {
        if (mIndicatorColorResId != SkinCompatHelper.INVALID_ID) {
            setIndicatorColor(SkinCompatResources.getColor(getContext(), mIndicatorColorResId));
        }
        if (mUnderlineColorResId != SkinCompatHelper.INVALID_ID) {
            setUnderlineColor(SkinCompatResources.getColor(getContext(), mUnderlineColorResId));
        }
        if (mDividerColorResId != SkinCompatHelper.INVALID_ID) {
            setDividerColor(SkinCompatResources.getColor(getContext(), mDividerColorResId));
        }
        if (mTextSelectColorResId != SkinCompatHelper.INVALID_ID) {
            setTextSelectColor(SkinCompatResources.getColor(getContext(), mTextSelectColorResId));
        }
        if (mTextUnselectColorResId != SkinCompatHelper.INVALID_ID) {
            setTextUnselectColor(SkinCompatResources.getColor(getContext(), mTextUnselectColorResId));
        }
    }

    @Override
    public void applySkin() {
        applySlidingTabLayoutResources();
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.applySkin();
        }
    }
}
