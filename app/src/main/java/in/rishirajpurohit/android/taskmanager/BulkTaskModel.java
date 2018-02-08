package in.rishirajpurohit.android.taskmanager;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rishi on 08-02-2018.
 */

public class BulkTaskModel {

    public List<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    @SerializedName("tasks")
    private List<TaskModel> tasks;



}
