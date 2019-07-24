package com.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.widget.R;
import com.retrofit.and_rxjava.api.RxTranslationInterface;
import com.retrofit.and_rxjava.entity.Translation;
import com.retrofit.single.api.SingleTranslationInterface;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mbc on 19-7-6
 * Description:
 */
public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }

    public void singleRetrofit(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /* The Retrofit class generates an implementation of the GitHubService interface. */
        SingleTranslationInterface request = retrofit.create(SingleTranslationInterface.class);
        /* Each Call from the created GitHubService can make a synchronous or asynchronous HTTP request to the remote webserver. */
        Call<Translation> call = request.getCall();

        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                Log.d("xiaoma", response.body().getContent().string());
                Toast.makeText(RetrofitActivity.this, response.body().getContent().string(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                Log.d("xiaoma", "fail -- " + t.getMessage());
            }
        });
    }

//    public void retrofit_RxJava(View view) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://fy.iciba.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//
//        /* The Retrofit class generates an implementation of the GitHubService interface. */
//        RxTranslationInterface request = retrofit.create(RxTranslationInterface.class);
//        /* Each Call from the created GitHubService can make a synchronous or asynchronous HTTP request to the remote webserver. */
//        Observable<Translation> observable = request.getCall();
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Translation>() {
//                    Disposable disposable;
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        disposable = d;
//                    }
//
//                    @Override
//                    public void onNext(Translation translation) {
//                        Toast.makeText(RetrofitActivity.this, translation.getContent().string(), Toast.LENGTH_LONG).show();
//                        disposable.dispose();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("xiaoma", "fail -- " + e.getMessage());
//                        disposable.dispose();
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}
