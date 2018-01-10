package in.rishirajpurohit.android.taskmanager.POJO;

/**
 * Created by rishi on 10-01-2018.
 */

public class Task {

    public int getTask_ID() {
        return task_ID;
    }

    public void setTask_ID(int task_ID) {
        this.task_ID = task_ID;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_body() {
        return task_body;
    }

    public void setTask_body(String task_body) {
        this.task_body = task_body;
    }

    public String getTask_priority() {
        return task_priority;
    }

    public void setTask_priority(String task_priority) {
        this.task_priority = task_priority;
    }

    int task_ID;
    String task_name,task_body,task_priority;
}
