package in.rishirajpurohit.android.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import in.rishirajpurohit.android.taskmanager.POJO.Task;

/**
 * Created by rishi on 10-01-2018.
 */




public class TasksDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Tasks.db";
    private static final int DATABASE_VERSION = 3;

    //Query : Table create
    private static final String TABLE_NAME = "Tasks";

    private static final String TASKS_COLUMN_NAME = "Name";
    private static final String TASKS_COLUMN_BODY = "Body";
    private static final String TASKS_COLUMN_PRIORITY = "Priority";
    private static final String TABLE_CREATE_TASKS = "CREATE TABLE "+TABLE_NAME+" (" + TASKS_COLUMN_NAME +" Text, "+ TASKS_COLUMN_BODY +" Text, "+ TASKS_COLUMN_PRIORITY +" Text "+ ");";
    private static final String TABLE_DELETE_TASKS = "DROP TABLE IF EXISTS "+TABLE_NAME+";";

    public TasksDbHelper(Context ctx){
        super(ctx,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate( SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE_TASKS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TABLE_DELETE_TASKS);
        onCreate(sqLiteDatabase);

    }

    //add a new task
    public Boolean addTask(Task t){
        ContentValues cv = new ContentValues();
        cv.put(TASKS_COLUMN_NAME,t.getTask_name());
        cv.put(TASKS_COLUMN_BODY,t.getTask_body());
        cv.put(TASKS_COLUMN_PRIORITY,t.getTask_priority());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long result = sqLiteDatabase.insert(TABLE_NAME,null,cv);


        if(result != 1){
            return false;
        }

        return true;
    }

    //get all tasks
    public List<Task> getAllTasks(){
        List<Task> all_tasks = new ArrayList<Task>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();;

       Cursor cursor = sqLiteDatabase.query(TABLE_NAME,new String[]{
               TASKS_COLUMN_BODY, TASKS_COLUMN_NAME, TASKS_COLUMN_PRIORITY
       },null,null,null,null,null);



       if(cursor.moveToFirst()){
           do{
               //get data
               Task t = new Task();
               t.setTask_name(cursor.getString(cursor.getColumnIndex(TASKS_COLUMN_NAME)));
               t.setTask_body(cursor.getString(cursor.getColumnIndex(TASKS_COLUMN_BODY)));
               t.setTask_priority(cursor.getString(cursor.getColumnIndex(TASKS_COLUMN_PRIORITY)));
               //save to list
               all_tasks.add(t);
           }while(cursor.moveToNext());
       }

       return all_tasks;

    }


}
