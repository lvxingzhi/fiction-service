package com.note.provider.fiction.dao;

import com.note.base.dao.SessionContext;
import com.note.provider.fiction.dto.response.FictionRankSearchResp;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("fiction.service.fictionRankDao")
public class FictionRankDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    public List<FictionRankSearchResp> selectByCondition(Map map){
        List<FictionRankSearchResp> list = sessionContext.getSqlSession().selectList(this.getClass().getName()+".selectByCondition",map);
        return list;
    }

}