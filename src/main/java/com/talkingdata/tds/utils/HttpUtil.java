package com.talkingdata.tds.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpUtil {
    private static final Logger logger = Logger
            .getLogger(HttpUtil.class);

    /**
     * post请求仅支持查询参数
     *
     * @param url
     * @param param
     * @param post
     * @param uploadFile
     * @return
     */
    public static String httpSend(String url,
                                  final Map<String, Object> param, boolean post, File uploadFile) {
        String response = null;

        if (post) {
            response = post(url, param);
        } else {
            response = get(url, param,null);
        }
        return response;
    }

    /**
     * 查询参数
     *
     * @param baseUrl
     * @param paramMap
     * @return
     */
    public static String post(String baseUrl, Map<String, Object> paramMap) {

        return post(baseUrl, null, null, null, paramMap, null, false);

    }

    /**
     * body
     *
     * @param baseUrl
     * @param json
     * @return
     */
    public static String post(String baseUrl, String json) {

        return post(baseUrl, null, null, null, null, json, false);
    }

    /**
     * body
     *
     * @param baseUrl
     * @param json
     * @return
     */
    public static String post(String baseUrl, Map<String, String> headers, String json, boolean contentType) {

        return post(baseUrl, headers, null, null, null, json, contentType);

    }

    /**
     * 查询参数
     *
     * @param baseUrl
     * @param paramMap
     * @return
     */
    public static String post(String baseUrl, Map<String, String> headerMap, String routekey,
                              String routevalue, Map<String, Object> paramMap, String body, boolean contentType) {

//        Unirest.setTimeouts(timeout, timeout);
        HttpResponse<String> jsonResponse = null;
        HttpRequestWithBody httpRequestWithBody = null;

        try {
            if (contentType && !CollectionUtils.isEmpty(headerMap)) {
                httpRequestWithBody = Unirest.post(baseUrl).
                        headers(headerMap);
            } else {
                httpRequestWithBody = Unirest.post(baseUrl).
                        header("Accept", "application/json")
                        .header("Content-Type", "application/json;charset=UTF-8");
            }
            if (StringUtils.isNotEmpty(routekey)) {
                httpRequestWithBody.routeParam(routekey, routevalue);
            }
            if (!CollectionUtils.isEmpty(paramMap)) {
                httpRequestWithBody.queryString(paramMap);
            }
            if (StringUtils.isNotEmpty(body)) {
                httpRequestWithBody.body(body);
            }
            jsonResponse = httpRequestWithBody.asString();
        } catch (UnirestException e) {
            logger.error(String.format("http request failed %s", baseUrl), e);
        }
        if (isOKStatusCode(jsonResponse.getStatus())) {
            logger.info(jsonResponse.getBody());
            return jsonResponse.getBody();
        }
        logger.error(String.format("http request failed %s %d %s", baseUrl, jsonResponse.getStatus(), jsonResponse.getBody()));
        return  jsonResponse.getBody();
    }

    /**
     * 查询参数
     *
     * @param baseUrl
     * @param paramMap
     * @return
     */
    public static Map<String, Object> post(String baseUrl, Map<String, String> headerMap, String routekey,
                                           String routevalue, Map<String, Object> paramMap, String body) {
        String response = null;
        HttpRequestWithBody httpRequestWithBody = null;
        httpRequestWithBody = Unirest.post(baseUrl).
                header("Accept", "application/json")
                .header("Content-Type", "application/json;charset=UTF-8");
        try {
            if (!CollectionUtils.isEmpty(headerMap)) {
                httpRequestWithBody = Unirest.post(baseUrl).
                        headers(headerMap);
            }
            if (StringUtils.isNotEmpty(routekey)) {
                httpRequestWithBody.routeParam(routekey, routevalue);
            }
            if (!CollectionUtils.isEmpty(paramMap)) {
                httpRequestWithBody.queryString(paramMap);
            }
            if (StringUtils.isNotEmpty(body)) {
                httpRequestWithBody.body(body);
            }
            HttpResponse<String> httpResponse = httpRequestWithBody.asString();
            response = httpResponse.getBody();
            logger.info(String.format("http request success %s %d %s", baseUrl, httpResponse.getStatus(), response));
            if (!JSONUtils.mayBeJSON(response)) {
                Map<String, Object> result = new HashMap<>();
                result.put("status", "success");
                result.put("result", response);
                return result;
            }
        } catch (UnirestException e) {
            logger.error(String.format("http request failed %s %s", baseUrl, response));
        }
        return JSON.<Map<String, Object>>parseObject(response, Map.class);
    }

    /**
     * 查询参数
     *
     * @param baseUrl
     * @param paramMap
     * @return
     */
    public static Map<String, Object> put(String baseUrl, Map<String, String> headerMap, String routekey,
                                          String routevalue, Map<String, Object> paramMap, String body) {
        String response = null;
        HttpRequestWithBody httpRequestWithBody = null;
        httpRequestWithBody = Unirest.put(baseUrl).
                header("Accept", "application/json")
                .header("Content-Type", "application/json;charset=UTF-8");
        try {
            if (!CollectionUtils.isEmpty(headerMap)) {
                httpRequestWithBody = Unirest.post(baseUrl).
                        headers(headerMap);
            }
            if (StringUtils.isNotEmpty(routekey)) {
                httpRequestWithBody.routeParam(routekey, routevalue);
            }
            if (!CollectionUtils.isEmpty(paramMap)) {
                httpRequestWithBody.queryString(paramMap);
            }
            if (StringUtils.isNotEmpty(body)) {
                httpRequestWithBody.body(body);
            }
            HttpResponse<String> httpResponse = httpRequestWithBody.asString();
            response = httpResponse.getBody();
            logger.info(String.format("http request success %s %d %s", baseUrl, httpResponse.getStatus(), response));
            if (!JSONUtils.mayBeJSON(response)) {
                Map<String, Object> result = new HashMap<>();
                result.put("status", "success");
                result.put("result", response);
                return result;
            }
        } catch (UnirestException e) {
            logger.error(String.format("http request failed %s %s", baseUrl, response));
        }
        return JSON.<Map<String, Object>>parseObject(response, Map.class);
    }

    /**
     * 带文件、查询参数等
     *
     * @param baseUrl
     * @param fileName   不能为空
     * @param uploadFile 不能为空
     * @param paramMap
     * @return
     */
    public static String post(String baseUrl, String fileName, InputStream uploadFile, Map<String, Object> paramMap) {

        HttpResponse<String> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(baseUrl)
                    .fields(paramMap)
                    .field(fileName, uploadFile, fileName)
                    .asString();
        } catch (UnirestException e) {
            logger.error(String.format("http request failed %s", baseUrl), e);
        }
        if (isOKStatusCode(jsonResponse.getStatus())) {
            return jsonResponse.getBody();
        }
        logger.error(String.format("http post request failed %s %d", baseUrl, jsonResponse.getStatus()));
        return  jsonResponse.getBody();
    }

    /**
     * 带文件、查询参数、routekey、routeValue等
     *
     * @param baseUrl
     * @param fileName
     * @param uploadFile
     * @param paramMap
     * @param routeKey   不能为空
     * @param routeValue 不能为空
     * @return
     */
    public static String post(String baseUrl, String fileName, InputStream uploadFile, Map<String, Object> paramMap, String routeKey,
                              String routeValue) {
        Preconditions.checkArgument(!StringUtils.isEmpty(routeKey) | !StringUtils.isEmpty(routeValue), "routeKey|routeValue can't be empty.");
        HttpResponse<String> jsonResponse = null;
        try {
            if (StringUtils.isEmpty(fileName) || uploadFile == null) {
                jsonResponse = Unirest.post(baseUrl)
                        .routeParam(routeKey, URLEncoder.encode(routeValue, "UTF-8"))
                        .fields(paramMap)
                        .asString();
            } else {
                jsonResponse = Unirest.post(baseUrl)
                        .routeParam(routeKey, URLEncoder.encode(routeValue, "UTF-8"))
                        .fields(paramMap)
                        .field(fileName, uploadFile, fileName)
                        .asString();
            }
        } catch (UnirestException e) {
            logger.error(String.format("http request failed %s", baseUrl), e);
        } catch (UnsupportedEncodingException e) {
            logger.error(String.format("http request failed %s", baseUrl), e);
        }
        if (isOKStatusCode(jsonResponse.getStatus())) {
            return jsonResponse.getBody();
        }
        logger.error(String.format("http post request failed %s %d", baseUrl, jsonResponse.getStatus()));
        return  jsonResponse.getBody();
    }

    public static String post(String baseUrl, Map<String, Object> paramMap, String routeKey, String routeValue) {
        return post(baseUrl, null, null, paramMap, routeKey, routeValue);
    }

    /**
     * @param baseUrl
     * @param paramMap
     * @return
     */
    public static String get(String baseUrl, Map<String, Object> paramMap,Map<String,String> headerMap) {
        return get(baseUrl, paramMap, headerMap, null, null);
    }


    public static String get(String baseUrl, Map<String, Object> paramMap, Map<String,String> headerMap,String routeKey, String routeValue) {
        HttpResponse<String> jsonResponse = null;
        try {
            if (!StringUtils.isEmpty(routeKey) && !StringUtils.isEmpty(routeValue)) {
                jsonResponse = Unirest.get(baseUrl).
                        header("Accept", "application/json")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .headers(headerMap)
                        .routeParam(routeKey, URLEncoder.encode(routeValue, "UTF-8"))
                        .queryString(paramMap).asString();
            } else {
                jsonResponse = Unirest.get(baseUrl).
                        header("Accept", "application/json")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .headers(headerMap)
                        .queryString(paramMap).asString();
            }
        } catch (UnirestException e) {
            logger.error(String.format("http request failed %s", baseUrl), e);
        } catch (UnsupportedEncodingException e) {
            logger.error(String.format("http request failed %s", baseUrl), e);
        }
        if (isOKStatusCode(jsonResponse.getStatus())) {
            return jsonResponse.getBody();
        }
        logger.error(String.format("http get request failed %s %d", baseUrl, jsonResponse.getStatus()));
        return  jsonResponse.getBody();
    }


    public static Map<String, Object> delete(String baseUrl, String routeKey, String routeValue, boolean isjson) {
        try {
            HttpRequestWithBody requestWithBody = Unirest.delete(baseUrl);
            if (isjson) {
                requestWithBody.header("Accept", "application/json")
                        .header("Content-Type", "application/json");
            } else {
                requestWithBody.header("Accept", "text/plain")
                        .header("Content-Type", "text/plain");
            }
            HttpResponse<String> jsonResponse = requestWithBody.routeParam(routeKey, URLEncoder.encode(routeValue, "UTF-8"))
                    .asString();

            logger.info(String.format("http delete request %s %d %s", baseUrl, jsonResponse.getStatus(), jsonResponse.getBody()));
            String response = jsonResponse.getBody();
            if (!JSONUtils.mayBeJSON(response)) {
                Map<String, Object> result = new HashMap<>();
                result.put("status", "success");
                result.put("result", response);
                return result;
            }
            return JSON.<Map<String, Object>>parseObject(response, Map.class);
        } catch (UnirestException e) {
        } catch (UnsupportedEncodingException e) {
            logger.error(String.format("http request failed %s", baseUrl), e);
        }
        return  null;
    }

    /**
     * 几种正常的状态码. 200 201 202 302
     *
     * @param statuscode
     * @return
     */
    private static boolean isOKStatusCode(int statuscode) {
        if (statuscode == HttpStatus.SC_OK) {
            return true;
        } else if (statuscode == HttpStatus.SC_ACCEPTED) {
            return true;
        } else if (statuscode == HttpStatus.SC_CREATED) {
            return true;
        } else if (statuscode == HttpStatus.SC_MOVED_TEMPORARILY) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String [] main) throws IOException {
        String url = "http://jk.tendcloud.com/job/haina/job/test/buildHistory/ajax/api/json";
        URI uri = URI.create(url);
        HttpHost host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(uri.getHost(), uri.getPort()),
                new UsernamePasswordCredentials("xianlong.bai", "06215"));
        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(host, basicAuth);
        Map<String,Object> map = new HashMap<>();
        map.put("token","52930b28e78abcb3cca2925149a46362");
//        String result = HttpUtil.get(url,map,null);

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(host, httpGet, localContext);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

}


