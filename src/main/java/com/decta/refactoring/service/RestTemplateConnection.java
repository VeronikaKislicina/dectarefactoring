package com.decta.refactoring.service;

import com.decta.refactoring.request.RpcRequest;
import com.decta.refactoring.response.RpcResponse;

public class RestTemplateConnection implements ServiceConnection {
    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public RpcResponse getResponse(RpcRequest request, String method) {
        return restTemplate.url("https://server.host.lv/client").method(method).body(request).execute();

    }
}