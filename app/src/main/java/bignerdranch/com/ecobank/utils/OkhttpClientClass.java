package bignerdranch.com.ecobank.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by dataintegrated on 6/19/2017.
 */

public class OkhttpClientClass {

    private OkHttpClient client;
    private static final OkhttpClientClass ourInstance = new OkhttpClientClass();

    public static OkhttpClientClass getInstance() {
        return ourInstance;
    }

    private OkhttpClientClass() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

         client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

    }
    public OkHttpClient getClient(){

        return client;
    }

}
