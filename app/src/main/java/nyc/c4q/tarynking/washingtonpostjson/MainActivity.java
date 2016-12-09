package nyc.c4q.tarynking.washingtonpostjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import nyc.c4q.tarynking.washingtonpostjson.models.ListOfPosts;
import nyc.c4q.tarynking.washingtonpostjson.models.Post;
import nyc.c4q.tarynking.washingtonpostjson.networks.WashingtonPostApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://www.washingtonpost.com/";
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PostAdapter());

        //retrofit
        Retrofit retrofit = new Retrofit.Builder() //setting up the URL making use of
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//convert to json to POJO
                .build();

        WashingtonPostApi api = retrofit.create(WashingtonPostApi.class); //use retrofit to create instance of API

        Call<ListOfPosts> call = api.getPosts();//calling method from interface..use API to call method getposts

        call.enqueue(new Callback<ListOfPosts>() {
            @Override
            public void onResponse(Call<ListOfPosts> call, Response<ListOfPosts> response) {
                ListOfPosts listOfPosts = response.body();//give you back data
                List<Post> list = listOfPosts.getPosts();//pass to recycler view adapter
                PostAdapter adapter = (PostAdapter) recyclerView.getAdapter();//#21 in notes
                adapter.setData(list);//#22 on notes
            }

            @Override
            public void onFailure(Call<ListOfPosts> call, Throwable t) {

            }
        });

    }


}
