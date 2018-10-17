package com.example.app5;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

//http://114.115.144.251:8001/
//WebApi/DataExchange/
//GetData/
//WB_EMF_FaultRepairList?
//dataKey=00-00-00
//&Status=4&UserID=cyf_1

public class Retrofit2Util {


    // 添加默认参数拦截器
    private static class CommonInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request oldRequest = chain.request();
            // 添加默认参数
            HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                    .newBuilder()
                    .scheme(oldRequest.url().scheme())
                    .host(oldRequest.url().host())
//                    这是进行添加公共的参数
                    .addQueryParameter("dataKey", "00-00-00");
            // 新的请求
            Request newRequest = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(authorizedUrlBuilder.build())
                    .build();

            return chain.proceed(newRequest);
        }
    }

    //    添加日志拦截器
    //        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(); //默认日志
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Log.e("TAG", "retrofit2请求===" + message);
        }
    });

    private static Api getInstance() {
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
//            如果在debug状态下，就进行打印日志
            builder = builder.addInterceptor(new CommonInterceptor()).addInterceptor(logging);
        }
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //这个是为了支持rxjava2
                //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create())   //获取到数据后进行json
                .addConverterFactory(ScalarsConverterFactory.create())  //这个还不知道有什么作用
                //设置网络请求的Url地址
                .baseUrl("http://114.115.144.251:8001/WebApi/")
                .client(client)
                .build();
        // 创建网络请求接口的实例
        Api mApi = retrofit.create(Api.class);
        return mApi;
    }

    private static Api api = getInstance();

    public static Api getApi() {
        return api;
    }

}
