package com.gemvietnam.hocvalam.socialNetwork.network;

import com.gemvietnam.common.base.log.Logger;
import com.gemvietnam.hocvalam.socialNetwork.Environments;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Web services builder
 * Created by neo on 2/15/2016.
 */
public class ServiceBuilder {
    public static final String BASE_URL = Environments.END_POINT + "api_yii2.php/v1/";

    private static Retrofit sInstance;
    private static SocialNetworkService sService;

    private static Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    // User agent default
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        // Set original User agent
                        Request original = chain.request();

                        String userAgent = System.getProperty("http.agent");
                        Logger.d("User-agent " + userAgent);
                        Request request = original.newBuilder()
                                .header("User-Agent", userAgent)
                                .method(original.method(), original.body())
                                .build();


                        return chain.proceed(request);
                    }
                })
                .build();

        if (sInstance == null) {
            sInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return sInstance;
    }

    public static SocialNetworkService getService() {
        if (sService == null) {
            sService = getRetrofit().create(SocialNetworkService.class);
        }

        return sService;
    }
}
