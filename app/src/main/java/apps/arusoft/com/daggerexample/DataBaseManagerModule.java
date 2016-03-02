package apps.arusoft.com.daggerexample;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.ramos on 02/03/2016.
 */
@Module
public class DataBaseManagerModule {

    @Provides
    @Singleton
    public DataBaseManager provideDataBaseManager(){
        return new DataBaseManager();
    }
}
