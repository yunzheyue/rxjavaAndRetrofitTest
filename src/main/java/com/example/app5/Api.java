package com.example.app5;


import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface Api {
    // 1. @GET注解的作用:采用Get方法发送网络请求
    // getNews(...) = 接收网络请求数据的方法
    // 其中返回类型为Call<News>，News是接收数据的类（即上面定义的News类）
    // 如果想直接获得Responsebody中的内容，可以定义网络请求返回值为Call<ResponseBody>
//    @Headers("apikey:81bf9da930c7f9825a3c3383f1d8d766")
//    @GET("word/word")  //使用Query相当于拼接成?num=...
//    Call<News> getNews(@Query("num") String num, @Query("page") String page);

    //2.    把Call的泛型定义为ResponseBody：Call<ResponseBody>  查看接口返回的json字符串
//    Call<ResponseBody> getNews2(@Query("num") String num, @Query("page") String page);

    //3.使用@Path  那么拼接后就不会有?
//    @GET(URL.CLAIM_APPLICATION_BOOKINFO + "{claimId}")
//    Observable<PublicResponseEntity<ClaimApplicationBookInfo>> getClaimApplicationBookInfo(@Header("Authorization") String authorization, @Path("claimId") String claimId);

//    4. Header的第二种使用方法
//    @GET("word/word")
//    Call<News> getNews(@Header("apikey")String apikey, @Query("num")String num, @Query("page")String page);

//    5. Header和Headers的区别   Header用于非固定的header  Headers用于苦丁的header
//    @GET("user")
//    Call<User> getUser(@Header("Authorization") String authorization)
//
//    @Headers("Authorization:authorization")
//    @GET("user")
//    Call<User> getUser()

    //GetData/
//WB_EMF_FaultRepairList?
//dataKey=00-00-00
//&Status=4&UserID=cyf_1

    @GET("DataExchange/GetData/WB_EMF_FaultRepairList")
        //使用Query相当于拼接成?num=...
    Call<ResponseBody> getNews(@Query("dataKey") String dataKey, @Query("Status") String status, @Query("UserID") String userID);

    @GET("DataExchange/GetData/WB_EMF_FaultRepairList")
        //使用Query相当于拼接成?num=...
    Call<News> getNews4(@Query("Status") String status, @Query("UserID") String userID);

    @GET("DataExchange/GetData/WB_EMF_FaultRepairList")
        //使用Query相当于拼接成?num=...
    Call<News> getNews2(@Query("dataKey") String dataKey, @Query("Status") String status, @Query("UserID") String userID);

    @GET("DataExchange/GetData/WB_EMF_FaultRepairList")
        //使用Query相当于拼接成?num=...
    Call<News.DataSourceBean.TablesBean.DatasBean> getNews3(@Query("dataKey") String dataKey, @Query("Status") String status, @Query("UserID") String userID);

    //    使用QueryMap  解决参数过多的问题  类似的可以使用Body  这个也能封装参数，但是适用于POST和PUT
    @POST("DataExchange/GetData/WB_EMF_FaultRepairList")
    Call<News> postNews1(@QueryMap HashMap<String, String> deviceInfo);


    //PDF文件Retrofit下载  这里用的@Streaming是用来注解大文件，对于小的文件就可以不使用
    @Streaming
    @GET
    Call<ResponseBody> retrofitDownloadFile(@Url String fileUrl);

    @GET("DataExchange/GetData/WB_EMF_FaultRepairList")
    Observable<News> getNews4(@Query("dataKey") String dataKey, @Query("Status") String status, @Query("UserID") String userID);


    @Streaming
    @GET
    Observable<ResponseBody> retrofitDownloadFile1(@Url String fileUrl);


    @POST("DataExchange/SendData/CMDS_MiniTask_AddOne")
    Call<ResponseBody> postNews5(@FieldMap HashMap<String, String> deviceInfo);


//    这是进行上传文件，但是具体的效果还没有实践
    @Multipart
    @POST("/WebApi/Upload/Post")
    Call<ResponseBody> upload_1(@PartMap Map<String, RequestBody> args, @Part MultipartBody.Part file);

    @Multipart
    @POST("/WebApi/Upload/Post")
    Call<ResponseBody> upload_2(@PartMap Map<String, RequestBody> data);


}
