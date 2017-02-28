package com.note.provider.fiction.proxy;

import com.google.gson.reflect.TypeToken;
import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.provider.fiction.api.FictionApiService;
import com.note.provider.fiction.dto.request.*;
import com.note.provider.fiction.dto.response.*;
import com.note.provider.fiction.service.FictionBaseService;
import com.note.provider.fiction.service.FictionChapterService;
import com.note.provider.fiction.service.FictionRankService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static com.note.base.utils.JsonUtil.gson;

/**
 * Created by Administrator on 2017/2/12.
 */
@Component("fiction.service.fictionServiceProxy")
public class FictionServiceProxy implements FictionApiService {

    @Resource(name = "fiction.service.fictionBaseService")
    private FictionBaseService fictionBaseService;

    @Resource(name = "fiction.service.fictionRankService")
    private FictionRankService fictionRankService;

    @Resource(name = "fiction.service.fictionChapterService")
    private FictionChapterService fictionChapterService;



    @Override
    public String search(String json) throws SQLException, IOException {
        List<FictionBaseEntity> list = fictionBaseService.selectByCondition(json);
        return gson.toJson(list);
    }

    @Override
    public String searchFull(String json) throws SQLException, IOException {
        FictionSearchReq fictionSearchReq = gson.fromJson(json, new TypeToken<FictionSearchReq>() {
        }.getType());
        List<FictionSearchResp> list = fictionBaseService.selectFullByCondition(fictionSearchReq);
        return gson.toJson(list);
    }

    @Override
    public String searchRankList(String json) throws SQLException, IOException {
        FictionRankSearchReq fictionRankSearchReq = gson.fromJson(json, new TypeToken<FictionRankSearchReq>() {
        }.getType());
        List<FictionRankSearchResp> list = fictionRankService.searchByCondition(fictionRankSearchReq);
        return gson.toJson(list);
    }

    @Override
    public String findFictionInfo(String json) throws SQLException, IOException {
        FictionFindOneReq fictionFindOneReq = gson.fromJson(json, new TypeToken<FictionFindOneReq>() {
        }.getType());
        FictionFindOneResp result = fictionBaseService.findOneByCondition(fictionFindOneReq);
        return gson.toJson(result);
    }

    @Override
    public String selectFictionChapters(String json) throws SQLException, IOException {
        FictionChapterReq fictionChapterReq = gson.fromJson(json, new TypeToken<FictionChapterReq>() {
        }.getType());
        List<FictionChapterResp> list = fictionChapterService.searchByCondition(fictionChapterReq);
        return gson.toJson(list);
    }

    @Override
    public String findChapterInfo(String json) throws SQLException, IOException {
        FictionChapterInfoReq fictionChapterInfoReq = gson.fromJson(json, new TypeToken<FictionChapterInfoReq>() {
        }.getType());
        FictionChapterInfoResp result = fictionChapterService.findChapterInfo(fictionChapterInfoReq);
        return gson.toJson(result);
    }

    @Override
    public String searchNewList(String json) throws SQLException, IOException {
        List<FictionBaseEntity> list = fictionBaseService.selectByCondition(json);
        return gson.toJson(list);
    }


}
