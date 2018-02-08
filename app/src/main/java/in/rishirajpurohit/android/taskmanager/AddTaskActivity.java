package in.rishirajpurohit.android.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;

import in.rishirajpurohit.android.taskmanager.POJO.Task;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTaskActivity extends AppCompatActivity {

    private static final String TAG = AddTaskActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        final EditText et_task_name = (EditText) findViewById(R.id.et_task_name);
        final EditText et_task_body = (EditText) findViewById(R.id.et_task_body);
        final Spinner spinner_priority = (Spinner) findViewById(R.id.spinner_priority);


        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,new String[]{
                "1","2","3"
        });

        spinner_priority.setAdapter(a);

        Button btn = (Button) findViewById(R.id.button_add_task);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_task_name.getText().toString();
                String body = et_task_body.getText().toString();
                String priority = spinner_priority.getSelectedItem().toString();

                TasksDbHelper db = new TasksDbHelper(AddTaskActivity.this);

                Task t = new Task();
                t.setTask_name(name);
                t.setTask_body(body);
                t.setTask_priority(priority);
                db.addTask(t);

                Toast.makeText(AddTaskActivity.this, "Task Added Successfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(AddTaskActivity.this,AllTasksActivity.class));
            }
        });

        Button btn_server = (Button) findViewById(R.id.btn_serverconnect);
        btn_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<BulkTaskModel> call = apiService.getTasks();

                call.enqueue(new Callback<BulkTaskModel>() {
                    @Override
                    public void onResponse(Call<BulkTaskModel> call, Response<BulkTaskModel> response) {

                        List<TaskModel> tasks = response.body().getTasks();

                        for(TaskModel tm : tasks){
                            String name = tm.getTask_name();
                            String tid = tm.getTask_id();
                            String body = tm.getTask_body();
                            String priroity = tm.getTask_priroity();

                            TasksDbHelper db = new TasksDbHelper(AddTaskActivity.this);

                            Task t = new Task();
                            t.setTask_name(name);
                            t.setTask_ID(Integer.parseInt(tid));
                            t.setTask_body(body);
                            t.setTask_priority(priroity);
                            db.addTask(t);
                        }


                    }

                    @Override
                    public void onFailure(Call<BulkTaskModel>call, Throwable t) {
                        // Log error here since request failed
                        Log.e(TAG, t.toString());
                        Toast.makeText(AddTaskActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
