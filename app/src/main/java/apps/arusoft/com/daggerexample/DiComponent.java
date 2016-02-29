package apps.arusoft.com.daggerexample;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jose.ramos on 25/02/2016.
 */

@Singleton
@Component(modules = {NetworkApiModule.class})
public interface DiComponent {
    // to update the fields in your activities
    void inject(MainActivity activity);
}
