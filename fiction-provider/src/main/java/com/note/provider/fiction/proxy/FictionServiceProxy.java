package com.note.provider.fiction.proxy;

import com.google.gson.reflect.TypeToken;
import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.entity.fiction.entity.FictionExtentionEntity;
import com.note.provider.fiction.api.FictionApiService;
import com.note.provider.fiction.dto.request.*;
import com.note.provider.fiction.dto.response.*;
import com.note.provider.fiction.service.FictionBaseService;
import com.note.provider.fiction.service.FictionChapterService;
import com.note.provider.fiction.service.FictionExtentionService;
import com.note.provider.fiction.service.FictionRankService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * 业务
 */
@Component("fiction.service.fictionServiceProxy")
public class FictionServiceProxy implements FictionApiService {

    @Resource(name = "fiction.service.fictionBaseService")
    private FictionBaseService fictionBaseService;

    @Resource(name = "fiction.service.fictionRankService")
    private FictionRankService fictionRankService;

    @Resource(name = "fiction.service.fictionChapterService")
    private FictionChapterService fictionChapterService;

    @Resource(name = "fiction.service.fictionExtentionService")
    private FictionExtentionService fictionExtentionService;

    public String search(String json) throws SQLException, IOException {
        List<FictionBaseEntity> list = fictionBaseService.selectByCondition(json);
        return JsonUtil.toJson(list);
    }

    public String findFull(String json) throws SQLException, IOException {
        FictionSearchReq fictionSearchReq = JsonUtil.fromJson(json, new TypeToken<FictionSearchReq>() {
        }.getType());
        List<FictionSearchResp> list = fictionBaseService.selectFullByCondition(fictionSearchReq);
        int count = fictionBaseService.selectFullCountByCondition(fictionSearchReq);
        if(ObjectUtil.notNull(list)){
            list.forEach(s->{
                if(ObjectUtil.isNull(s.getShortDesc())){
                    s.setSubShortDesc("");
                }else{
                    if(s.getShortDesc().length()>25){
                        s.setSubShortDesc(s.getShortDesc().substring(0,23)+"……");
                    }else{
                        s.setSubShortDesc(s.getShortDesc());
                    }
                }
            });
        }
        HashMap<String,Object> result = new HashMap<>();
        result.put("count",count+"");
        result.put("list",list);
        return JsonUtil.toJson(result);
    }

    public String findRankList(String json) throws SQLException, IOException {
        FictionRankSearchReq fictionRankSearchReq = JsonUtil.fromJson(json, new TypeToken<FictionRankSearchReq>() {
        }.getType());
        List<FictionRankSearchResp> list = fictionRankService.searchByCondition(fictionRankSearchReq);
        return JsonUtil.toJson(list);
    }

    public String findFictionInfo(String json) throws SQLException, IOException {
        FictionFindOneReq fictionFindOneReq = JsonUtil.fromJson(json, new TypeToken<FictionFindOneReq>() {
        }.getType());
        FictionFindOneResp result = fictionBaseService.findOneByCondition(fictionFindOneReq);
        // 增加浏览量
        FictionExtentionEntity fictionExtentionEntity = fictionExtentionService.findByFictionCode(result.getLogicCode());
        fictionExtentionEntity.setFictionViews(fictionExtentionEntity.getFictionViews()+1);
        fictionExtentionService.updateStatistics(fictionExtentionEntity);
        return JsonUtil.toJson(result);
    }

    public String findFictionChapters(String json) throws SQLException, IOException {
        FictionChapterReq fictionChapterReq = JsonUtil.fromJson(json, new TypeToken<FictionChapterReq>() {
        }.getType());
        List<FictionChapterResp> list = fictionChapterService.searchByCondition(fictionChapterReq);
        return JsonUtil.toJson(list);
    }

    public String findChapterInfo(String json) throws SQLException, IOException {
        FictionChapterInfoReq fictionChapterInfoReq = JsonUtil.fromJson(json, new TypeToken<FictionChapterInfoReq>() {
        }.getType());
        FictionChapterInfoResp result = fictionChapterService.findChapterInfo(fictionChapterInfoReq);
        return JsonUtil.toJson(result);
    }

    public String findNewList(String json) throws SQLException, IOException {
        List<FictionBaseEntity> list = fictionBaseService.selectByCondition(json);
        return JsonUtil.toJson(list);
    }

}
