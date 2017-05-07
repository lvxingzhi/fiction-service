package com.note.provider.fiction.service;

import com.note.base.enums.DeleteEnum;
import com.note.base.enums.UserLevelEnum;
import com.note.base.enums.UserTypeEnum;
import com.note.base.utils.UUIDGenerator;
import com.note.entity.fiction.entity.SystemUserEntity;
import com.note.provider.fiction.dao.SystemUserDao;
import com.note.provider.fiction.dto.request.SystemUserLoginReq;
import com.note.provider.fiction.dto.request.SystemUserReq;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@Repository("fiction.service.systemUserService")
public class SystemUserService  {

    @Resource(name ="fiction.service.systemUserDao")
    private SystemUserDao systemUserDao;

    public int add(SystemUserReq systemUserReq) {
        SystemUserEntity systemUserEntity = new SystemUserEntity();
        systemUserEntity.setLogicCode(UUIDGenerator.uuid());
        systemUserEntity.setLoginName(systemUserReq.getUserName());
        systemUserEntity.setLoginPassword(systemUserReq.getPassword());
        systemUserEntity.setEmail(systemUserReq.getEmail());
        systemUserEntity.setLevel(UserLevelEnum.NORMAL.getType());
        systemUserEntity.setType(UserTypeEnum.NORMAL.getType());
        systemUserEntity.setName(systemUserReq.getName());
        systemUserEntity.setCreateTime(new Date());
        systemUserEntity.setModifyTime(systemUserEntity.getCreateTime());
        systemUserEntity.setCreateUserCode("admin");
        systemUserEntity.setModifyUserCode("admin");
        systemUserEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
        return systemUserDao.add(systemUserEntity);
    }

    public SystemUserEntity find(SystemUserLoginReq systemUserLoginReq) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("searchContent",systemUserLoginReq);
        return systemUserDao.selectOneByCondition(map);
    }

}