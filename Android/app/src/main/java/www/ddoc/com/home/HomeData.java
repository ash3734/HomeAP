package www.ddoc.com.home;

import java.io.Serializable;

/**
 * Created by ash on 2017-08-11.
 */

public class HomeData implements Serializable {
    String text;

    public HomeData(String text) {
        this.text = text;
    }
}
