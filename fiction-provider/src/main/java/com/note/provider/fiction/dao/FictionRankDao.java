package com.note.provider.fiction.dao;

import com.note.provider.fiction.dto.response.FictionRankSearchResp;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository("fiction.service.fictionRankDao")
public class FictionRankDao  extends SqlSessionDaoSupport {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Resource(name ="sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<FictionRankSearchResp> selectByCondition(Map map){
        List<FictionRankSearchResp> list = this.getSqlSession().selectList(this.getClass().getName()+".selectByCondition",map);
        return list;
    }

}