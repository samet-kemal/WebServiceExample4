package RestAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private static RestApiClient instance = null;
    private RestApi myApi;

    private RestApiClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RestApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(RestApi.class);
    }

    public static synchronized RestApiClient getInstance() {
        if (instance == null) {
            instance = new RestApiClient();
        }
        return instance;
    }

    public RestApi getMyApi() {
        return myApi;
    }


}
