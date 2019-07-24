package com.retrofit.and_rxjava.api;


import com.retrofit.and_rxjava.entity.Translation;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by mbc on 19-7-5
 * Description: http://fy.iciba.com/ajax.php?a=fy&f=auto&t=auto&w=hello
 */
public interface RxTranslationInterface {

    /*Retrofit turns your HTTP API into a Java interface. */
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello")
    Observable<Translation> getCall();
}
