package com.decta.refactoring.service;

import com.decta.refactoring.request.RpcRequest;
import com.decta.refactoring.response.RpcResponse;
import org.springframework.stereotype.Service;

@Service
public class RestTemplate {

    private String url;

    public RestTemplate url(String url) {
        this.url = url;
        return this;
    }

    public RestTemplate method(String method) {
        return this;
    }

    public RestTemplate body(RpcRequest body) {
        return this;
    }

    public RpcResponse execute() {
        return new RpcResponse();
    }
}
