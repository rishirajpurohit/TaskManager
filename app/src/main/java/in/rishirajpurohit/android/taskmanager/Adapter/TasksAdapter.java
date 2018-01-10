package in.rishirajpurohit.android.taskmanager.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import in.rishirajpurohit.android.taskmanager.POJO.Task;
import in.rishirajpurohit.android.taskmanager.R;

/**
 * Created by rishi on 10-01-2018.
 */

public class TasksAdapter extends BaseAdapter {

    List<Task> allTasks;
    private static LayoutInflater inflater=null;private Activity activity;


    public TasksAdapter(Activity a, List<Task> list_tasks){
        activity = a;
        this.allTasks = list_tasks;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return allTasks.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi=view;
        if(view==null)
            vi = inflater.inflate(R.layout.list_row_task, null);

        TextView taskName = (TextView)vi.findViewById(R.id.tv_task_name);
        TextView taskBody = (TextView)vi.findViewById(R.id.tv_task_body);
        TextView taskPriority = (TextView)vi.findViewById(R.id.tv_task_priority);

        Task t = allTasks.get(i);

        taskName.setText(t.getTask_name());
        taskBody.setText(t.getTask_body());
        taskPriority.setText(t.getTask_priority());

        return vi;
    }
}
