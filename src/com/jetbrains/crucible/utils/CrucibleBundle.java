package com.jetbrains.crucible.utils;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ResourceBundle;

/**
 * User: ktisha
 */
public class CrucibleBundle {
    private static Reference<ResourceBundle> ourBundle;

    @NonNls
    private static final String BUNDLE = "com.jetbrains.crucible.utils.CrucibleBundle";

    private CrucibleBundle() {}

    public static String message(@PropertyKey(resourceBundle = BUNDLE)String key, Object... params) {
        return CommonBundle.message(getBundle(), key, params);
    }

    private static ResourceBundle getBundle() {
        ResourceBundle bundle = null;
        if (ourBundle != null) bundle = ourBundle.get();
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE);
            ourBundle = new SoftReference<ResourceBundle>(bundle);
        }
        return bundle;
    }
}
