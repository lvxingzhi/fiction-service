package com.note.provider.fiction.dao;

import com.note.provider.fiction.dto.response.FictionChapterInfoResp;
import com.note.provider.fiction.dto.response.FictionChapterResp;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository("fiction.service.fictionChapterDao")
public class FictionChapterDao extends SqlSessionDaoSupport {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Resource(name ="sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<FictionChapterResp> selectByCondition(Map map){
        List<FictionChapterResp> list = this.getSqlSession().selectList(this.getClass().getName()+".selectByCondition",map);
        return list;
    }

    public FictionChapterInfoResp findOneByLogicCode(Map map){
        FictionChapterInfoResp result = this.getSqlSession().selectOne(this.getClass().getName()+".findByLogicCode",map);
        return result;
    }



}