package com.okta.spring.AuthorizationServerApplication.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReceiveStatus {
    private List<String> uuids;
}
