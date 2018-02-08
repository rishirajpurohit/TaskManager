package in.rishirajpurohit.android.taskmanager;

/**
 * Created by rishi on 08-02-2018.
 */

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class DummyModel {
    public String getMy_message() {
        return my_message;
    }

    public void setMy_message(String my_message) {
        this.my_message = my_message;
    }

    public String getMy_title() {
        return my_title;
    }

    public void setMy_title(String my_title) {
        this.my_title = my_title;
    }

    @SerializedName("msg")
    private String my_message;

    @SerializedName("title")
    private String my_title;

    public DummyModel(String msg,String title){
        this.my_message = msg;
        this.my_title = title;
    }
}
