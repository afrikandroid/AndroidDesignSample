/*
package com.ads.dagger;

import com.ads.dagger.components.AppComponent;
import com.ads.dagger.components.DaggerAppComponent;
import com.ads.dagger.modules.AppModule;

*/
/**
 * Created by bah on 9/21/15.
 *
 * Singleton for handling app specific dagger injections.
 * Note - should be created in application onCreate.
 *//*

public class DaggerInjector {
    private static DaggerInjector INSTANCE;
    private AppComponent appComponent;

    public static DaggerInjector getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DaggerInjector();
        }
        return INSTANCE;
    }

    */
/**
     * Once application created, call this method to create the Application Component
     * Note - requires multiple modules. Override factory classes when needed, not Modules.
     * @param appModule
     *//*

    public void onApplicationCreated(AppModule appModule){
        appComponent = DaggerAppComponent.builder().appModule(appModule).build();
    }

    */
/**
     * Get instance of dagger's Application Component.
     * @return - single instance of Application Component
     *//*

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
*/
