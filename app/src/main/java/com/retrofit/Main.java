package com.retrofit;

import com.retrofit.and_rxjava.entity.Translation;
import com.retrofit.single.api.SingleTranslationInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mbc on 19-7-6
 * Description:
 */
public class Main {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
//                .baseUrl("http://fy.iciba.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /* The Retrofit class generates an implementation of the GitHubService interface. */
        SingleTranslationInterface request = retrofit.create(SingleTranslationInterface.class);
        /* Each Call from the created GitHubService can make a synchronous or asynchronous HTTP request to the remote webserver. */
        Call<Translation> call = request.getCall();

        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                System.out.print(response.body().getContent().string());
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                System.out.print(t.getMessage());
            }
        });
    }

}
