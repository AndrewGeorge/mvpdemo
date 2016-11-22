package com.example.mvpdemo.utils;

import com.example.mvpdemo.main.MyApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class RetrofitBuilder {

    private static Retrofit retrofit;
    public synchronized static Retrofit buildRetrofit() {
        if (retrofit == null) {
            //设置网络缓存
            Interceptor interceptor=new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    CacheControl.Builder cacheBuilder = new CacheControl.Builder();
                    cacheBuilder.maxAge(0, TimeUnit.SECONDS);
                    cacheBuilder.maxStale(365, TimeUnit.DAYS);
                    CacheControl cacheControl = cacheBuilder.build();
                    Request request = chain.request();
                    if(!NetWorkUtil.isNetworkReachable(MyApplication.mContext)){
                        request = request.newBuilder()
                                .cacheControl(cacheControl)
                                .build();
                    }
                    Response originalResponse = chain.proceed(request);
                    if (!NetWorkUtil.isNetworkReachable(MyApplication.mContext)) {
                        int maxAge = 0; // read from cache
                        return originalResponse.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public ,max-age=" + maxAge)
                                .build();
                    } else {
                        int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                        return originalResponse.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .build();
                    }
                }
            };



//            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .retryOnConnectionFailure(true)
                    .build();
            retrofit = new Retrofit.Builder().client(client)
                    .baseUrl(Constents.BASE_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
