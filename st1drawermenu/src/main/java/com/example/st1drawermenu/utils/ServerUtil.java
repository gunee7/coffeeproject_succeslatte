package com.example.st1drawermenu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018-02-25.
 */

public class ServerUtil {

    private final static String BASE_URL = "http://givetest.cafe24.com/usermain/";

    public static boolean checkIntenetSetting(Context context) {
        boolean isConnected = false;

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        // wifi 또는 모바일 네트워크 어느 하나라도 연결이 되어있다면,
        if (wifi.isConnected() || mobile.isConnected()) {
            Log.i("연결됨", "연결이 되었습니다.");
            isConnected = true;
        } else {
            Log.i("연결 안 됨", "연결이 다시 한번 확인해주세요");
            Toast.makeText(context, "인터넷 연결을 확인해주세요.", Toast.LENGTH_SHORT).show();
            isConnected = false;
        }

        return isConnected;
    }

    //    JSON 처리 부분 인터페이스
    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }

    public static void getEventList(final Context context, final JsonResponseHandler handler) {
        if (!checkIntenetSetting(context)) {
            return;
        }

        OkHttpClient client = new OkHttpClient();

        //URL에 포함할 Query문 작성 Name&Value
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "EventList.php").newBuilder();
//        urlBuilder.addEncodedQueryParameter("user_id", searchKey);
        String requestUrl = urlBuilder.build().toString();

        //Query문이 들어간 URL을 토대로 Request 생성
        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        //만들어진 Request를 서버로 요청할 Client 생성
        //Callback을 통해 비동기 방식으로 통신을 하여 서버로부터 받은 응답을 어떻게 처리 할 지 정의함
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("error", "Connect Server Error is " + e.toString());
                Toast.makeText(context, "서버와의 통신에 문제가있습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d("log", "서버에서 응답한 Body:" + body);
                try {
                    JSONObject json = new JSONObject(body);
                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public static void getNotice(final Context context, final JsonResponseHandler handler) {
        if (!checkIntenetSetting(context)) {
            return;
        }

        OkHttpClient client = new OkHttpClient();

        //URL에 포함할 Query문 작성 Name&Value
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "Notice.php").newBuilder();
//        urlBuilder.addEncodedQueryParameter("user_id", searchKey);
        String requestUrl = urlBuilder.build().toString();

        //Query문이 들어간 URL을 토대로 Request 생성
        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        //만들어진 Request를 서버로 요청할 Client 생성
        //Callback을 통해 비동기 방식으로 통신을 하여 서버로부터 받은 응답을 어떻게 처리 할 지 정의함
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("error", "Connect Server Error is " + e.toString());
                Toast.makeText(context, "서버와의 통신에 문제가있습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d("log", "서버에서 응답한 Body:" + body);
                try {
                    JSONObject json = new JSONObject(body);
                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
