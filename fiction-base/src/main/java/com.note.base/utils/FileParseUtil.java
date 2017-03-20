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
 * @date 2017/3/20
 * @since 1.0
 */
public class FileParseUtil {

    private static List<ChapterDto> parse(FileParseDto fileParseDto) throws IOException {
        List<ChapterDto> chapterDtos = new ArrayList<>();
        Path path = Paths.get("D:/","abc.txt");
//        Path path = FileSystems.getDefault().getPath("D:/", "abc.txt");
        BufferedReader reader = Files.newBufferedReader(path, Charset.forName("GBK"));
        System.out.println();
        String str = null;
        String title = "";
        int index = 1;
        ChapterDto chapterDto = new ChapterDto();
        while((str = reader.readLine()) != null){
            System.out.println(str);
            if(str.contains("7")){
                chapterDtos.add(chapterDto);
                title = str.replaceAll("7","").replaceAll("8","");
                chapterDto = new ChapterDto();
                chapterDto.setTitle(title);
                chapterDto.setIndex(index);
                index+=1;
            }else{
                chapterDto.setContent(chapterDto.getContent()+str);
            }
        }
        return chapterDtos;
    }

    public static void main(String[] args) throws IOException {
        FileParseUtil.parse(null);
    }



}
