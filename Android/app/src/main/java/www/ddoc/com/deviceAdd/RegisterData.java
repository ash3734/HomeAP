package www.ddoc.com.deviceAdd;

/**
 * Created by ash on 2017-07-23.
 */

public class RegisterData {
    String hw_addr;
    String type;
    String name;
    int num;

    public RegisterData(String hw_addr, String type, String name, int num) {
        this.hw_addr = hw_addr;
        this.type = type;
        this.name = name;
        this.num = num;
    }
}
