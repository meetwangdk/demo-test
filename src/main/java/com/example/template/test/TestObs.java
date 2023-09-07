package com.example.template.test;

import com.obs.services.ObsClient;
import com.obs.services.model.HttpMethodEnum;
import com.obs.services.model.TemporarySignatureRequest;
import com.obs.services.model.TemporarySignatureResponse;
import shade.okhttp3.Call;
import shade.okhttp3.OkHttpClient;
import shade.okhttp3.Request;
import shade.okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class TestObs {

    public static void main(String[] args) throws IOException {
        String endPoint = "http://obs.cn-east-3.myhuaweicloud.com";
        String ak = "LAITX3PINUGQA27GEHF6";
        String sk = "TDMp2YT1UMxyM5J0cX153thJ7Gl9HMcArdJbSpMJ";

// 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
// URL有效期，3600秒
        long expireSeconds = 3600L;
        TemporarySignatureRequest request = new TemporarySignatureRequest(HttpMethodEnum.GET, expireSeconds);
        request.setBucketName("bigjin-test");
        request.setObjectKey("test.txt");

        TemporarySignatureResponse response = obsClient.createTemporarySignature(request);

        System.out.println("Getting object using temporary signature url:");
        System.out.println("\t" + response.getSignedUrl());
        Request.Builder builder = new Request.Builder();
        for (Map.Entry<String, String> entry : response.getActualSignedRequestHeaders().entrySet()) {
            builder.header(entry.getKey(), entry.getValue());
        }

//使用GET请求下载对象
        Request httpRequest = builder.url(response.getSignedUrl()).get().build();
        OkHttpClient httpClient = new OkHttpClient.Builder().followRedirects(false).retryOnConnectionFailure(false)
                .cache(null).build();

        Call c = httpClient.newCall(httpRequest);
        Response res = c.execute();
        System.out.println("\tStatus:" + res.code());
        if (res.body() != null) {
            System.out.println("\tContent:" + res.body().string() + "\n");
        }
        res.close();

    }
}
