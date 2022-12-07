package skin.core.constraint.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import skin.core.constraint.SkinCompatConstraintLayout;
import skin.core.app.SkinLayoutInflater;

public class SkinConstraintViewInflater implements SkinLayoutInflater {
    @Override
    public View createView(Context context, final String name, AttributeSet attrs) {
        View view = null;
        switch (name) {
            case "androidx.constraintlayout.widget.ConstraintLayout":
                view = new SkinCompatConstraintLayout(context, attrs);
                break;
            default:
                break;
        }
        return view;
    }
}
