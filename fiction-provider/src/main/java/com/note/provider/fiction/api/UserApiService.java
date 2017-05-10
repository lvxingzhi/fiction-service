package com.note.provider.fiction.api;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/18.
 */
public interface UserApiService {

    /**
     * 新增
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String add(String json) throws SQLException, IOException;

    /**
     * 查找
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String find(String json) throws SQLException, IOException;

    /**
     * 修改基本信息
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String updateBaseInfo(String json) throws SQLException, IOException;

    /**
     * 修改扩展信息
     * @param json
     * @return
     * @throws SQLException
     * @throws IOException
     */
    String updateExtensionInfo(String json) throws SQLException, IOException;




}
