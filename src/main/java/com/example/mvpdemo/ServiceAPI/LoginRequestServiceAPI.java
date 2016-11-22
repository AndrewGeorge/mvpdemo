package com.example.mvpdemo.ServiceAPI;

import com.example.mvpdemo.Bean.LoginResponseData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public interface LoginRequestServiceAPI {
//    //获取TabLayout上的数据
//    @GET("api/lore/classify")
//    Call<ClassfyBean> getClassfyData();
//
//    //获取首页列表的数据
//    @GET("api/lore/list")
//    Call<CateItemBean> getListData(@Query("id") int id);
//
//    //获取详情数据
//    @GET("api/lore/show")
//    Call<DetailBean> getDetailData(@Query("id") int id);
//
//    @GET("api/{id}/delete")
//    Call<DetailBean> getData(@Path("id")String id);    //
//
//    //使用post访问接口
//    @FormUrlEncoded
//    @POST("api/lore/list")
//    Call<CateItemBean> getItemListData(@Field("id") int id);

    @FormUrlEncoded
    @POST("/wswsys/app/api")
    Call<LoginResponseData> userLogin(@Query("opt") String opt,@FieldMap Map<String, String> params);

}
