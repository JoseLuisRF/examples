package apps.arusoft.com.daggerexample;

import android.app.Application;

/**
 * Created by jose.ramos on 25/02/2016.
 */
public class MyApplication extends Application {
    DiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerDiComponent.builder().build();
    }

    public DiComponent getComponent() {
        return component;
    }
}
