package com.note.provider.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.provider.fiction.dto.response.FictionFindOneResp;
import com.note.provider.fiction.dto.response.FictionSearchResp;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/12.
 */
@Repository("fiction.service.fictionBaseDao")
public class FictionBaseDao extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public List<FictionBaseEntity> selectByCondition(Map map){
        List<FictionBaseEntity> list = sessionContext.selectList(this.getClass().getName()+".selectByCondition",map);
        return list;
    }

    public List<FictionSearchResp> selectFullByCondition(Map map){
        List<FictionSearchResp> list = sessionContext.selectList(this.getClass().getName()+".selectFullByCondition",map);
        return list;
    }

    public FictionFindOneResp findOneByCondition(Map map){
        FictionFindOneResp result = sessionContext.selectOne(this.getClass().getName()+".selectOneByCondition",map);
        return result;
    }

}
