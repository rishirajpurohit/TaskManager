package in.rishirajpurohit.android.taskmanager;

/**
 * Created by rishi on 08-02-2018.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("getTasks")
    Call<BulkTaskModel> getTasks();
}