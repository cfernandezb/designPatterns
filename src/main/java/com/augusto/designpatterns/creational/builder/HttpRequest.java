package com.augusto.designpatterns.creational.builder;

public class HttpRequest {
    private final String method;
    private final String url;
    private final String body;
    private final String headers;
    private final int timeout;

    private HttpRequest(Builder builder) {
        this.method = builder.method;
        this.url = builder.url;
        this.body = builder.body;
        this.headers = builder.headers;
        this.timeout = builder.timeout;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        return body;
    }

    public String getHeaders() {
        return headers;
    }

    public int getTimeout() {
        return timeout;
    }

    public static class Builder {
        private String method = "GET";
        private String url;
        private String body;
        private String headers;
        private int timeout = 5;

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setHeaders(String headers) {
            this.headers = headers;
            return this;
        }

        public Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", body='" + body + '\'' +
                ", headers='" + headers + '\'' +
                ", timeout=" + timeout +
                '}';
    }
}
