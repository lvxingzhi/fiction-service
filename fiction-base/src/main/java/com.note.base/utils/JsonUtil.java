package com.note.base.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * <p>TODO </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/2/28
 * @since 1.0
 */
public class JsonUtil {

    public static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    private JsonUtil(){

    }
}
