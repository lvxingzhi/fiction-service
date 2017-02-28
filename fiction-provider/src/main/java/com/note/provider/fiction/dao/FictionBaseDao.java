package com.note.provider.fiction.dao;

import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.provider.fiction.dto.response.FictionFindOneResp;
import com.note.provider.fiction.dto.response.FictionSearchResp;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/12.
 */
@Repository("fiction.service.fictionBaseDao")
public class FictionBaseDao extends SqlSessionDaoSupport{

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Resource(name ="sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
         super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<FictionBaseEntity> selectByCondition(Map map){
        List<FictionBaseEntity> list = this.getSqlSession().selectList(this.getClass().getName()+".selectByCondition",map);
        return list;
    }

    public List<FictionSearchResp> selectFullByCondition(Map map){
        List<FictionSearchResp> list = this.getSqlSession().selectList(this.getClass().getName()+".selectFullByCondition",map);
        return list;
    }

    public FictionFindOneResp findOneByCondition(Map map){
        FictionFindOneResp result = this.getSqlSession().selectOne(this.getClass().getName()+".selectOneByCondition",map);
        return result;
    }



}
