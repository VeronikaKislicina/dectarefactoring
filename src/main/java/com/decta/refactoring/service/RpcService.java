package com.decta.refactoring.service;

import com.decta.refactoring.entity.BusinessClient;
import com.decta.refactoring.entity.Client;
import com.decta.refactoring.exception.RPCServiceException;
import com.decta.refactoring.request.RpcRequest;
import com.decta.refactoring.response.RpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RpcService {

    private ServiceConnection serviceConnection;

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private RestTemplate restTemplate;

    public RpcService() {
        restTemplate = new RestTemplate();
    }

    public RpcResponse registerNewClient(Client client) {
        RpcRequest request = new RpcRequest()
                .withJsonRpc("2.0")
                .withMethod("REGISTER_NEW_CLIENT")
                .withId("1")
                .withParameters(client);

        RpcResponse response = null;
        try {
            response = serviceConnection.getResponse(request, "POST");
        } catch (Exception e) {
            log.info("RPC call failed");
        }

        return response;
    }

    public RpcResponse registerNewBusinessClient(BusinessClient client) {
        RpcRequest request = new RpcRequest()
                .withJsonRpc("2.0")
                .withMethod("REGISTER_NEW__BUSINESS_CLIENT")
                .withId("1")
                .withParameters(client);

        RpcResponse response = null;
        try {
            response = serviceConnection.getResponse(request, "POST");
        } catch (Exception e) {
            log.info("RPC call failed");
        }

        if (response.getErrorCode() != 0) throw new RPCServiceException("Unknown exception");

        return response;
    }

    public RpcResponse getPrivateClientsList(String clientId) {

        RpcRequest request = new RpcRequest()
                .withJsonRpc("2.0")
                .withMethod("GET_REGISTERED_CLIENTS")
                .withId("1")
                .withParameters(clientId);

        RpcResponse response = null;
        try {
            response = serviceConnection.getResponse(request, "GET");
        } catch (Exception e) {
            log.info("RPC call failed");
        }

        if (response.getErrorCode() != 0) throw new RPCServiceException("Unknown exception");

        return response;
    }

    public RpcResponse editClients(Client client) {
        RpcRequest request = new RpcRequest()
                .withJsonRpc("2.0")
                .withMethod("EDIT_CLIENT")
                .withId("1")
                .withParameters(client);

        RpcResponse response = null;
        try {
            response = serviceConnection.getResponse(request, "PATCH");
        } catch (Exception e) {
            log.info("RPC call failed");
        }

        if (response.getErrorCode() != 0) throw new RPCServiceException("Unknown exception");

        return response;
    }
}