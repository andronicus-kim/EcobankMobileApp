package bignerdranch.com.ecobank.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dataintegrated on 6/19/2017.
 */

public class ResponseData {

    @SerializedName("data")
    @Expose
    private ResponseBodyContents mResponseBodyContents;

    public ResponseBodyContents getResponseBodyContents() {
        return mResponseBodyContents;
    }

    public void setData(ResponseBodyContents mResponseBodyContents) {
        this.mResponseBodyContents = mResponseBodyContents;
    }

}

