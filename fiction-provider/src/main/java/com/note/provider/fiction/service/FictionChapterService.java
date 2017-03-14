package com.note.provider.fiction.service;

import com.note.provider.fiction.dao.FictionChapterDao;
import com.note.provider.fiction.dto.request.FictionChapterInfoReq;
import com.note.provider.fiction.dto.request.FictionChapterReq;
import com.note.provider.fiction.dto.response.FictionChapterInfoResp;
import com.note.provider.fiction.dto.response.FictionChapterResp;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */
@Service("fiction.service.fictionChapterService")
public class FictionChapterService {

    @Resource(name ="fiction.service.fictionChapterDao")
    private FictionChapterDao fictionChapterDao;

    public List<FictionChapterResp> searchByCondition(FictionChapterReq fictionChapterReq) throws SQLException {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("searchContent",fictionChapterReq);
        RowBounds rowBounds = new RowBounds(fictionChapterReq.getOffset(),fictionChapterReq.getLimit());
        return fictionChapterDao.selectByCondition(map,rowBounds);
    }

    public FictionChapterInfoResp findChapterInfo(FictionChapterInfoReq fictionChapterInfoReq) throws SQLException {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("searchContent",fictionChapterInfoReq);
        return fictionChapterDao.findOneByLogicCode(map);
    }



}
