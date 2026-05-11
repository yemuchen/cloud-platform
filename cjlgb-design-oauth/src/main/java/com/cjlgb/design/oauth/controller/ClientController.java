package com.cjlgb.design.oauth.controller;

import com.cjlgb.design.common.oauth.entity.OauthClient;
import com.cjlgb.design.common.security.annotation.PreAuthorize;
import com.cjlgb.design.oauth.service.ClientService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WFT
 * @date 2020/6/15
 * description:
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/client")
public class ClientController {

    private final ClientService clientService;

    /**
     * 获取某客户端信息
     * @param clientId 客户端Id
     * @return com.cjlgb.design.common.oauth.entity.OauthClient
     */
    @PreAuthorize
    @GetMapping(value = "/{clientId}")
    @JsonIgnoreProperties(value = "secret")
    public OauthClient get(@PathVariable(value = "clientId") Long clientId){
        return this.clientService.selectById(clientId);
    }

}
