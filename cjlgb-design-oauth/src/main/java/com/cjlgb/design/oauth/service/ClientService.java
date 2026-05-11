package com.cjlgb.design.oauth.service;

import com.cjlgb.design.common.mybatis.enums.LockFlag;
import com.cjlgb.design.common.mybatis.service.BaseService;
import com.cjlgb.design.common.oauth.entity.OauthClient;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author WFT
 * @date 2020/6/14
 * description:
 */
public interface ClientService extends BaseService<OauthClient> {

    /**
     * 根据Id获取客户端信息
     * @param clientId java.io.Serializable
     * @return com.cjlgb.design.common.oauth.entity.OauthClient
     */
    default OauthClient selectById(Serializable clientId){
        OauthClient client = this.getById(clientId);
        Assert.notNull(client,"客户端Id不存在");
        Assert.isTrue(client.getLockFlag() == LockFlag.enable,"客户端被锁定,请与管理员联系");
        return client;
    }

}
