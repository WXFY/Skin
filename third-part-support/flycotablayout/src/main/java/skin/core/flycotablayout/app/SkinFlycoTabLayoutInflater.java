package skin.core.flycotablayout.app;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import skin.core.flycotablayout.widget.SkinSegmentTabLayout;
import skin.core.app.SkinLayoutInflater;
import skin.core.flycotablayout.widget.SkinCommonTabLayout;
import skin.core.flycotablayout.widget.SkinMsgView;
import skin.core.flycotablayout.widget.SkinSlidingTabLayout;

/**
 * Created by ximsf on 2017/3/8.
 */

public class SkinFlycoTabLayoutInflater implements SkinLayoutInflater {
    @Override
    public View createView(@NonNull Context context, String name, @NonNull AttributeSet attrs) {
        View view = null;
        switch (name) {
            case "com.flyco.tablayout.SlidingTabLayout":
                view = new SkinSlidingTabLayout(context, attrs);
                break;
            case "com.flyco.tablayout.CommonTabLayout":
                view = new SkinCommonTabLayout(context, attrs);
                break;
            case "com.flyco.tablayout.SegmentTabLayout":
                view = new SkinSegmentTabLayout(context, attrs);
                break;
            case "com.flyco.tablayout.widget.MsgView":
                view = new SkinMsgView(context, attrs);
                break;
        }
        return view;
    }
}
