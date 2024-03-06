/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vn.coderest.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author siluk
 */
public class RestInvoker
{

    Logger logger = LoggerFactory.getLogger(RestInvoker.class);

    public Response invoke(String url, String method, String body, String pathVariable, String queryParam) throws IOException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException, Exception
    {

        try
        {
            logger.trace("INVOKE RADIUS API\nURL>> " + url + "\nPOST Body>> " + body);
            OkHttpClient client = (new OkHttpClient()).newBuilder().build();
//             OkHttpClient client = new OkHttpClient();
            OkHttpClient.Builder clientBuilder = client.newBuilder();

            if (true)
            {
                try
                {
                    X509TrustManager trustManager = new X509TrustManager()
                    {
                        @Override
                        public X509Certificate[] getAcceptedIssuers()
                        {
                            X509Certificate[] cArrr = new X509Certificate[0];
                            return cArrr;
                        }

                        @Override
                        public void checkServerTrusted(final X509Certificate[] chain,
                                final String authType) throws CertificateException
                        {
                        }

                        @Override
                        public void checkClientTrusted(final X509Certificate[] chain,
                                final String authType) throws CertificateException
                        {
                        }
                    };
                    final TrustManager[] trustAllCerts = new TrustManager[]
                    {
                        trustManager
                    };

                    SSLContext sslContext = SSLContext.getInstance("SSL");

                    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                    clientBuilder.sslSocketFactory(sslContext.getSocketFactory(), trustManager);
                    HostnameVerifier hostnameVerifier = new HostnameVerifier()
                    {
                        @Override
                        public boolean verify(String hostname, SSLSession session)
                        {
                            return true;
                        }
                    };
                    clientBuilder.hostnameVerifier(hostnameVerifier);
                } catch (NoSuchAlgorithmException ex)
                {

                } catch (KeyManagementException ex)
                {

                }
            }

            if (pathVariable != null)
            {
                url += getPathVariables(pathVariable);
            }
            if (queryParam != null)
            {
                url += getQueryParams(queryParam);
            }
            System.out.println(url);
//            OkHttpClient client = new OkHttpClient().newBuilder()
//                    .build();
            RequestBody reqbody;
            if (method.toUpperCase().equals("GET"))
            {
                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                Response response = client.newCall(request).execute();
                return response;
            }

            if (body == null)
            {
                MediaType mediaType = MediaType.parse("text/plain");
                reqbody = RequestBody.create(mediaType, "");
            } else
            {
                JSONObject json = new JSONObject(body);
                MediaType mediaType = MediaType.parse("application/json");
                reqbody = RequestBody.create(mediaType, json.toString());
            }
            Request request = new Request.Builder()
                    .url(url)
                    .method(method.toUpperCase(), reqbody)
                    .build();
            Response response = client.newCall(request).execute();
            return response;
        } catch (Exception ex)
        {
            logger.error("Errorr Invoking RADWEBAPI Service>> " + ex.getMessage(), ex);
            throw new Exception(ex.getMessage());
        }

    }

    public static String getPathVariables(String pathVariable)
    {
        String pathVarUrl = "";
        for (String path : pathVariable.split(" "))
        {
            pathVarUrl += "/" + path;
        }
        return pathVarUrl;
    }

    public static String getQueryParams(String queryParam)
    {
        String queryUrl = "";
        String[] queryPar = queryParam.split(",");
        for (int i = 0; i < queryPar.length; i++)
        {
            String[] key_value = queryPar[i].split("=");
            if (i == 0)
            {
                queryUrl += "?" + key_value[0] + "=" + key_value[1];
            } else
            {
                queryUrl += "&" + key_value[0] + "=" + key_value[1];
            }
        }
        return queryUrl;
    }
}
