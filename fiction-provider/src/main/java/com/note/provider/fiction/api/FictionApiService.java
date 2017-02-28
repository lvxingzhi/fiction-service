package com.note.provider.fiction.api;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/12.
 */
public interface FictionApiService {

    String search(String json) throws SQLException, IOException;

    String searchFull(String json) throws SQLException, IOException;

    String searchRankList(String json) throws SQLException, IOException;

    String findFictionInfo(String json) throws SQLException, IOException;

    String selectFictionChapters(String json) throws SQLException, IOException;

    String findChapterInfo(String json) throws SQLException, IOException;

    String searchNewList(String json) throws SQLException, IOException;

}
