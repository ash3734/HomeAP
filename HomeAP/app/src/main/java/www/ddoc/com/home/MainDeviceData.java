package www.ddoc.com.home;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ash on 2017-08-28.
 */

public class MainDeviceData implements Serializable{
    int num;
    String hw_addr;
    int adult;
    int gambling;
    int game;
    int learning;
    String type;
    String name;
    ArrayList<MainUrlData> information;

    public MainDeviceData(int num, String hw_addr, int adult, int gambling, int game, int learning, String type, String name, ArrayList<MainUrlData> information) {
        this.num = num;
        this.hw_addr = hw_addr;
        this.adult = adult;
        this.gambling = gambling;
        this.game = game;
        this.learning = learning;
        this.type = type;
        this.name = name;
        this.information = information;
    }
}
