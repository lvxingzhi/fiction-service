package com.note.base.utils;

import com.note.base.dto.file.ChapterDto;
import com.note.base.dto.file.FileParseDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>解析文件 </p>
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
public class FileParseUtil {

    /**
     * 解析文件章节列表
     * @param fileParseDto
     * @return
     * @throws IOException
     */
    public static List<ChapterDto> parse(FileParseDto fileParseDto) throws IOException {
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        Path path = Paths.get(fileParseDto.getPath(),fileParseDto.getFileName());
//        Path path = FileSystems.getDefault().getPath("D:/", "abc.txt");
        BufferedReader reader = Files.newBufferedReader(path, Charset.forName(fileParseDto.getEncode()));
        System.out.println();
        String str = null;
        String title = "";
        int index = 1;
        ChapterDto chapterDto = null;
        boolean begain = false;
        while((str = reader.readLine()) != null){
            System.out.println(str);
            if(str.contains(fileParseDto.getHeadTag())){
                begain = true;
            }
            if(begain&&str.contains(fileParseDto.getHeadTag())){
                chapterDto = new ChapterDto();
                title = str.replaceAll(fileParseDto.getHeadTag(),"");
                chapterDto.setTitle(title);
                chapterDto.setIndex(index);
                chapterDtoList.add(chapterDto);
                index+=1;
            }else if(begain){
                chapterDto.setContent(ObjectUtil.dualStringNull(chapterDto.getContent())+"\n"+str);
            }
        }

        // 统计字数
        chapterDtoList.forEach((ChapterDto t) ->
            t.setTotal(ObjectUtil.notNull(t.getContent())?t.getContent().length():0)
        );
        return chapterDtoList;
    }

}
