package in.rishirajpurohit.android.taskmanager;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rishi on 08-02-2018.
 */

public class TaskModel {
    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTask_body() {
        return task_body;
    }

    public void setTask_body(String task_body) {
        this.task_body = task_body;
    }

    public String getTask_priroity() {
        return task_priroity;
    }

    public void setTask_priroity(String task_priroity) {
        this.task_priroity = task_priroity;
    }

    @SerializedName("task_name")
    private String task_name;

    @SerializedName("task_id")
    private String task_id;

    @SerializedName("task_body")
    private String task_body;

    @SerializedName("task_priority")
    private String task_priroity;

    public TaskModel(String name,String id, String body, String priority){
        this.task_name = name;
        this.task_id = id;
        this.task_body = body;
        this.task_priroity = priority;
    }

}
