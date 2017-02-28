package com.note.provider.fiction.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository("fiction.service.fictionChapterExtentionDao")
public class FictionChapterExtentionDao extends SqlSessionDaoSupport {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Resource(name ="sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


}