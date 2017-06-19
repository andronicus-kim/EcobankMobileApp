package bignerdranch.com.ecobank.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by james on 4/12/2017.
 */

public class RetrofitClient {

    // Trailing slash is needed
    public static final String BASE_URL = "http://agency.mobitill.com/api/terminals/";



    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkhttpClientClass.getInstance().getClient())
            .build();

    public static Retrofit getRetrofit(){
        return retrofit;
    }
}
