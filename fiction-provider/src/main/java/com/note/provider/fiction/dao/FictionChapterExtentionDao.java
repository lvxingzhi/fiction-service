package com.note.provider.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.entity.fiction.entity.FictionChapterExtentionEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("fiction.service.fictionChapterExtentionDao")
public class FictionChapterExtentionDao extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public int add(FictionChapterExtentionEntity fictionChapterExtentionEntity){
        return sessionContext.insert(this.getClass().getName()+".insert",fictionChapterExtentionEntity);
    }

}