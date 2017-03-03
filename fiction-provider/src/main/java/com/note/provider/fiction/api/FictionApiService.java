package com.note.provider.fiction.api;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/12.
 */
public interface FictionApiService {

    String search(String json) throws SQLException, IOException;

    String findFull(String json) throws SQLException, IOException;

    String findRankList(String json) throws SQLException, IOException;

    String findFictionInfo(String json) throws SQLException, IOException;

    String findFictionChapters(String json) throws SQLException, IOException;

    String findChapterInfo(String json) throws SQLException, IOException;

    String findNewList(String json) throws SQLException, IOException;

}
