package com.theokanning.openai.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

public class LoggingInterceptor implements Interceptor {
    private static final Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (request.body() != null) {
            Request copy = request.newBuilder().build();
            Buffer buffer = new Buffer();
            request.body().writeTo(buffer);
            String bodyString = buffer.readUtf8();
            LOG.info("Sending request to " + request.url() + " with body: " + bodyString);
        }

        Response response = chain.proceed(request);
        return response;
    }

    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            if (copy.body() != null) {
                copy.body().writeTo(buffer);
                return buffer.readUtf8();
            }
            return "";
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
