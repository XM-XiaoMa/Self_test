package com.retrofit.single.api;


import com.retrofit.and_rxjava.entity.Translation;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mbc on 19-7-5
 * Description: http://fy.iciba.com/ajax.php?a=fy&f=auto&t=auto&w=hello
 */
public interface SingleTranslationInterface {

    /*Retrofit turns your HTTP API into a Java interface. */
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello")
//    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello")
    Call<Translation> getCall();
}
