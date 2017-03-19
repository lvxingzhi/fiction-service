package com.note.provider.fiction.proxy;

import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.entity.fiction.entity.SystemUserEntity;
import com.note.provider.fiction.api.UserApiService;
import com.note.provider.fiction.dto.request.SystemUserLoginReq;
import com.note.provider.fiction.dto.request.SystemUserReq;
import com.note.provider.fiction.service.SystemUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/18.
 */
@Component("fiction.service.userServiceProxy")
public class UserServiceProxy implements UserApiService {

    @Resource(name = "fiction.service.systemUserService")
    private SystemUserService systemUserService;

    public String add(String json) throws SQLException, IOException {
        SystemUserReq systemUserReq = JsonUtil.fromJson(json, SystemUserReq.class);
        systemUserService.add(systemUserReq);
        return "0";
    }

    public String find(String json) throws SQLException, IOException {
        SystemUserLoginReq systemUserLoginReq = JsonUtil.fromJson(json, SystemUserLoginReq.class);
        SystemUserEntity systemUserEntity = systemUserService.find(systemUserLoginReq);
        if(ObjectUtil.isNull(systemUserEntity)){
            return null;
        }
        return JsonUtil.toJson(systemUserEntity);
    }
}
