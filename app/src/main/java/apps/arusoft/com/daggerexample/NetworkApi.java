package apps.arusoft.com.daggerexample;

/**
 * Created by jose.ramos on 25/02/2016.
 */
public class NetworkApi {
    public boolean validateUser(String username, String password) {
        // imagine an actual network call here
        // for demo purpose return false in "real" life
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
