package com.note.provider.fiction.api;

import java.io.IOException;
import java.sql.SQLException;

/**
 * dubbo暴露接口
 */
public interface FictionApiService {

    /**
     * 名称检索
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String search(String json) throws SQLException, IOException;

    /**
     * 多功能检索
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String findFull(String json) throws SQLException, IOException;

    /**
     * RANK列表
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String findRankList(String json) throws SQLException, IOException;

    /**
     * 详情信息
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String findFictionInfo(String json) throws SQLException, IOException;

    /**
     * 章节列表
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String findFictionChapters(String json) throws SQLException, IOException;

    /**
     * 章节信息
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String findChapterInfo(String json) throws SQLException, IOException;

    /**
     * 最新列表  @TODO
     *
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String findNewList(String json) throws SQLException, IOException;

}
