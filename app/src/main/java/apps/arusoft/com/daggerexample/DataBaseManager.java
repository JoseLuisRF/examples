
package apps.arusoft.com.daggerexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose.ramos on 02/03/2016.
 */
public class DataBaseManager {

    public List<String> queryNames(){
        List<String> names = new ArrayList();
        names.add("Jose");
        names.add("Luis");
        names.add("Emilio");
        names.add("Daniela");
        names.add("Diana");
        names.add("Andrea");

        return names;
    }
}
