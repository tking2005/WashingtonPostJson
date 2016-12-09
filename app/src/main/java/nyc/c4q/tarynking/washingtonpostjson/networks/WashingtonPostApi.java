package nyc.c4q.tarynking.washingtonpostjson.networks;

import nyc.c4q.tarynking.washingtonpostjson.models.ListOfPosts;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tarynking on 12/8/16.
 */

public interface WashingtonPostApi {

    @GET("/wp-srv/simulation/simulation_test.json")
    Call<ListOfPosts> getPosts();

}
