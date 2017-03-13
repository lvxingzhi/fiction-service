package com.note.provider.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("fiction.service.systemUserDao")
public class SystemUserDao  extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

}