package com.vkmusic.service.api;

import com.vkmusic.exception.HttpConnectionException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * Created by Vadym_Vlasenko on 5/6/2016.
 */
@Service
public class HttpConnector {

    public String sendPost(String URL, List<NameValuePair> valuePairList) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);
        HttpEntity postParams = new UrlEncodedFormEntity(valuePairList);
        httpPost.setEntity(postParams);
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new HttpConnectionException();
        }
        String response = EntityUtils.toString(httpResponse.getEntity());
        httpClient.close();
        return response;
    }

    public String sendGet(String URL) throws IOException {
        HttpGet request = new HttpGet(URL);
        return sendGetByRequest(request);
    }

    public String sendGet(URI uri) throws IOException {
        HttpGet request = new HttpGet(uri);
        return sendGetByRequest(request);
    }

    private String sendGetByRequest(HttpGet request) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new HttpConnectionException("Status code is %s" + statusCode);
        }
        return EntityUtils.toString(response.getEntity());
    }

}
