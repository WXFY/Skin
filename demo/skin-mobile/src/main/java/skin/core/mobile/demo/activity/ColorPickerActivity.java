package skin.core.mobile.demo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import skin.core.mobile.demo.activity.base.BaseActivity;
import skin.support.mobile.demo.R;

public class ColorPickerActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        initToolbar(true);
    }
}
