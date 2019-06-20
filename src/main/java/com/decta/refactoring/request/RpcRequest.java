package com.decta.refactoring.request;

import com.decta.refactoring.entity.BusinessClient;
import com.decta.refactoring.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class RpcRequest {

    private String id;
    private String jsonRpc;
    private String method;
    private Client client;
    private String clientId;
    private BusinessClient businessClient;

    public RpcRequest withJsonRpc(String jsonRpc) {
        this.jsonRpc = jsonRpc;
        return this;
    }

    public RpcRequest withMethod(String method) {
        this.method = method;
        return this;
    }

    public RpcRequest withId(String id) {
        this.id = id;
        return this;
    }

    public RpcRequest withParameters(Client client) {
        this.client = client;
        return this;
    }

    public RpcRequest withParameters(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public RpcRequest withParameters(BusinessClient businessClient) {
        this.businessClient = businessClient;
        return this;
    }

}