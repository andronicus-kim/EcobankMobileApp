package bignerdranch.com.ecobank.data;

import bignerdranch.com.ecobank.request.Example;
import bignerdranch.com.ecobank.response.ResponseData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by james on 4/12/2017.
 */

public interface AccountService {
    @POST("newaccount")
    Call<ResponseData> postData(@Body Example example);
}
