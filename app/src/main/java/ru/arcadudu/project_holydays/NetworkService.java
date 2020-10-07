package ru.arcadudu.project_holydays;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService extends Application {

//    private static NetworkService mInstance;
//    private static final String BASE_URL = "http://holidayapp82020.crabdance.com:13130";
    private Retrofit mRetrofit;

    private static UmoriliApi umoriliApi;


    public static UmoriliApi getApi(){
        return umoriliApi;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.BASE_URL))
                .addConverterFactory(GsonConverterFactory.create()).build();
        umoriliApi = mRetrofit.create(UmoriliApi.class);
    }
}




