package com.agri.atef.myapplication.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

//    @GET("count-UnreadNotic")
//    SmartCall<NotifyCountResponse> getNotifyCount(@Query("api_token") String api_token);

    @GET("uploadVegetables")
    Call<VegtablesResponse> getVegtablesResponse(@Query("api_token") String api_token);

    @GET("uploadArticles")
    Call<ArticlesResponse> getArticlesResponse();

    @GET("uploadFruits")
    Call<FruitsResponse> getFruitsResponse();

    @GET("uploadBcools")
    Call<BcoolsResponse> getBcoolsResponse();

    @GET("uploadSokars")
    Call<SokarsResponse> getSokarsResponse();

    @GET("uploadOils")
    Call<OilsResponse> getOilsResponse();

    @GET("uploadInsects")
    Call<InsectsResponse> getInsectsResponse();

    @GET("uploadHacls")
    Call<HaclsResponse> getHaclsResponse();


}
