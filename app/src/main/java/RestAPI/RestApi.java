package RestAPI;

import java.util.List;

import Model.InfoItem;
import Model.ResultItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    String BASE_URL="https://jsonplaceholder.typicode.com";

    @GET("/comments")
    Call<List<InfoItem>> getInfoList();

    @GET("/comments")
    Call<List<ResultItem>> getResult(@Query("postId") String postId ,@Query("id") String id);




}
