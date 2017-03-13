package com.note.provider.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.provider.fiction.dto.response.FictionChapterInfoResp;
import com.note.provider.fiction.dto.response.FictionChapterResp;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("fiction.service.fictionChapterDao")
public class FictionChapterDao extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public List<FictionChapterResp> selectByCondition(Map map){
        List<FictionChapterResp> list = sessionContext.selectList(this.getClass().getName()+".selectByCondition",map);
        return list;
    }

    public FictionChapterInfoResp findOneByLogicCode(Map map){
        FictionChapterInfoResp result = sessionContext.selectOne(this.getClass().getName()+".findByLogicCode",map);
        return result;
    }



}