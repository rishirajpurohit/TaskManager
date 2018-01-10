package in.rishirajpurohit.android.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import in.rishirajpurohit.android.taskmanager.POJO.Task;

public class AddTaskActivity extends AppCompatActivity {

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


    }
}
