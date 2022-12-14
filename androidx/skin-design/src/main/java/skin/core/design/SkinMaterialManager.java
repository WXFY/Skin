package skin.core.design;

import android.content.Context;

import skin.core.SkinCompatManager;
import skin.core.design.app.SkinMaterialViewInflater;

/**
 * Created by ximsfei on 2017/1/13.
 */

public class SkinMaterialManager {
    private static volatile SkinMaterialManager sInstance;

    public static SkinMaterialManager init(Context context) {
        if (sInstance == null) {
            synchronized (SkinMaterialManager.class) {
                if (sInstance == null) {
                    sInstance = new SkinMaterialManager(context);
                }
            }
        }
        return sInstance;
    }

    public static SkinMaterialManager getInstance() {
        return sInstance;
    }

    private SkinMaterialManager(Context context) {
        SkinCompatManager.init(context).addInflater(new SkinMaterialViewInflater());
    }
}
