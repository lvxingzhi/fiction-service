package com.note.provider.fiction.service;

import com.note.base.dto.PageDto;
import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.provider.fiction.dao.FictionBaseDao;
import com.note.provider.fiction.dto.request.FictionFindOneReq;
import com.note.provider.fiction.dto.request.FictionSearchReq;
import com.note.provider.fiction.dto.response.FictionFindOneResp;
import com.note.provider.fiction.dto.response.FictionSearchResp;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */
@Service("fiction.service.fictionBaseService")
public class FictionBaseService {

    @Resource(name ="fiction.service.fictionBaseDao")
    private FictionBaseDao fictionBaseDao;

    public List<FictionBaseEntity> selectByCondition(String name) throws SQLException {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name",name);
        RowBounds rowBounds = new RowBounds(new PageDto().getOffset(),new PageDto().getLimit());
        return fictionBaseDao.selectByCondition(map,rowBounds);
    }

    public List<FictionSearchResp> selectFullByCondition(FictionSearchReq fictionSearchReq) throws SQLException {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("searchContent",fictionSearchReq);
        RowBounds rowBounds = new RowBounds(fictionSearchReq.getOffset(),fictionSearchReq.getLimit());
        return fictionBaseDao.selectFullByCondition(map,rowBounds);
    }

    public FictionFindOneResp findOneByCondition(FictionFindOneReq fictionFindOneReq) throws SQLException {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("searchContent",fictionFindOneReq);
        return fictionBaseDao.findOneByCondition(map);
    }




}
