package com.decta.refactoring.service;

import com.decta.refactoring.request.RpcRequest;
import com.decta.refactoring.response.RpcResponse;

public interface ServiceConnection {

    RpcResponse getResponse(RpcRequest request, String method);

}