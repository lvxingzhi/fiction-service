package com.note.base.dto.file;

/**
 * <p>文件解析预处理对象 </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/3/20
 * @since 1.0
 */
public class FileParseDto {

    private String path; //路径
    private String fileName; //文件名
    private String headTag; // 断章头标识
    private String footTag; // 断章尾标识

}
