package com.augmentcare.patient.network.restApi;

import android.util.Log;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.utils.PrefsHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class API {

    private static APIService webService;

    public static void reset(){
        webService = null;
    }

    public static APIService getApi() {
        if (webService == null) {
            try {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .writeTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(1, TimeUnit.MINUTES);
                httpClient.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        // Customize the request
                        Request request = original.newBuilder()
                                .header("Accept", "application/json")
                                .header("Content-Type", "application/json")
                                .header("access-token", PrefsHelper.getAccessTokenFromSP())
                                .header("uid", PrefsHelper.getUIDFromSP())
                                .header("client", PrefsHelper.getClientFromSP())


//                                .header("access-token", "I-zLq5gDx-y9JSNxPI-k8A")
//                                .header("uid", "devdoc@mailinator.com")
//                                .header("client", "qrL3Vs5YsnIJYbdFz0pXnQ")


                                .method(original.method(), original.body())
                                .build();

                        Response response = chain.proceed(request);

                        // Customize or return the response
                        return response;
                    }
                });

                httpClient.addInterceptor(interceptor);

//                Gson gson = new GsonBuilder()
//                        .setLenient()
//                        .create();

                OkHttpClient client = httpClient.build();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BuildConfig.SOCKET_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // for rx calling
                        .addConverterFactory(ScalarsConverterFactory.create()) // for response in string and shit
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client).build();

                webService = retrofit.create(APIService.class);


            } catch (Exception e) {
                Log.d("web service client","exception "+e.toString());
            }

        }
        return webService;
    }


//    private static String addAuthHeader() {
//        String authStr = BuildConfig.BASE_USER + ":" + BuildConfig.BASE_PASSWORD;
//        Log.d("", "Auth value " + authStr);
//        // Encode authentication values, and add to header
//        String authStrEncoded = "";
//        try {
//            authStrEncoded = new String(Base64.encode(
//                    authStr.getBytes("UTF-8"), Base64.NO_WRAP));
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        }
//        return authStrEncoded;
//    }

}