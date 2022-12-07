package com.ximsfei.skindemo;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;

import com.ximsfei.skindemo.loader.CustomSDCardLoader;
import com.ximsfei.skindemo.loader.ZipSDCardLoader;

import skin.core.SkinCompatManager;
import skin.core.app.SkinAppCompatViewInflater;
import skin.core.app.SkinCardViewInflater;
import skin.core.circleimageview.app.SkinCircleImageViewInflater;
import skin.core.constraint.app.SkinConstraintViewInflater;
import skin.core.design.app.SkinMaterialViewInflater;
import skin.core.flycotablayout.app.SkinFlycoTabLayoutInflater;
import skin.core.utils.Slog;

/**
 * Created by ximsfei on 2017/1/10.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        SkinCircleImageViewManager.init(this);
//        SkinMaterialManager.init(this);
//        SkinConstraintManager.init(this);
//        SkinCardViewManager.init(this);
//        SkinFlycoTabLayoutManager.init(this);
//        SkinCompatManager.init(this).loadSkin();
//        SkinCompatManager.init(this)
        // 框架换肤日志打印
        Slog.DEBUG = BuildConfig.DEBUG;
        SkinCompatManager.withoutActivity(this)
                .addStrategy(new CustomSDCardLoader())          // 自定义加载策略，指定SDCard路径
                .addStrategy(new ZipSDCardLoader())             // 自定义加载策略，获取zip包中的资源
                .addInflater(new SkinAppCompatViewInflater())   // 基础控件换肤
                .addInflater(new SkinMaterialViewInflater())    // material design
                .addInflater(new SkinConstraintViewInflater())  // ConstraintLayout
                .addInflater(new SkinCardViewInflater())        // CardView v7
                .addInflater(new SkinCircleImageViewInflater()) // hdodenhof/CircleImageView
                .addInflater(new SkinFlycoTabLayoutInflater())  // H07000223/FlycoTabLayout
                .setSkinStatusBarColorEnable(true)              // 关闭状态栏换肤
//                .setSkinWindowBackgroundEnable(false)           // 关闭windowBackground换肤
//                .setSkinAllActivityEnable(false)                // true: 默认所有的Activity都换肤; false: 只有实现SkinCompatSupportable接口的Activity换肤
                .loadSkin();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
