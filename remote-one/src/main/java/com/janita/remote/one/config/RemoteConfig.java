package com.janita.remote.one.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Janita on 2017-03-23 10:04
 */
@ConfigurationProperties(prefix = "remote")
public class RemoteConfig {

    private static String host;
    private static int port;
    private static String post;
    private static String get;

    private static String url;

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        RemoteConfig.host = host;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        RemoteConfig.port = port;
    }

    public static String getPost() {
        return post;
    }

    public static void setPost(String post) {
        RemoteConfig.post = post;
    }

    public static String getGet() {
        return get;
    }

    public static void setGet(String get) {
        RemoteConfig.get = get;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        RemoteConfig.url = url;
    }
}
