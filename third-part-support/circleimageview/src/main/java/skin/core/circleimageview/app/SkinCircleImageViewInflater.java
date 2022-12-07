package skin.core.circleimageview.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import skin.core.circleimageview.widget.SkinCompatCircleImageView;
import skin.core.app.SkinLayoutInflater;

/**
 * Created by ximsfei on 2017/3/5.
 */

public class SkinCircleImageViewInflater implements SkinLayoutInflater {
    @Override
    public View createView(Context context, final String name, AttributeSet attrs) {
        View view = null;
        switch (name) {
            case "de.hdodenhof.circleimageview.CircleImageView":
                view = new SkinCompatCircleImageView(context, attrs);
                break;
        }
        return view;
    }
}
