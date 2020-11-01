package com.laibold.concluesion;

import android.app.Application;
import android.content.res.Resources;

/**
 * Gives every Class access to Resources and packageName
 */
public class App extends Application {

    private static Resources resources;
    private static String packageName;

    @Override
    public void onCreate() {
        super.onCreate();

        resources = getResources();
        packageName = getPackageName();
    }

    /**
     * @return Resources
     */
    public static Resources getAppResources() {
        return resources;
    }

    /**
     * @return PackageName
     */
    public static String getAppPackageName() {
        return packageName;
    }
}
