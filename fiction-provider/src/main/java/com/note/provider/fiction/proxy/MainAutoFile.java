package com.note.provider.fiction.proxy;

import com.note.base.dto.ResponseDTO;
import com.note.base.dto.file.BaseDto;
import com.note.base.dto.file.ChapterDto;
import com.note.base.dto.file.FileParseDto;
import com.note.base.utils.FileParseUtil;
import com.note.base.utils.JsonUtil;
import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.provider.fiction.dto.request.FictionAddReq;
import com.note.provider.fiction.dto.request.FictionChapterAddReq;
import com.note.provider.fiction.dto.request.FictionSearchReq;
import com.note.provider.fiction.service.FictionBaseService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
 * @date 2017/3/21
 * @since 1.0
 */
public class MainAutoFile {

    public static void main(String[] args) throws IOException, SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/applicationContext.xml"});
        context.start();
        System.out.println("#########: 开始");
        FileParseDto fileParseDto = new FileParseDto();
        fileParseDto.setPath("H:/temp/");
        fileParseDto.setFileName("温度.txt");
        fileParseDto.setEncode("UTF-8");
        System.out.println("#########解析小说: "+fileParseDto.toString());

        Map<String,Object> resultMap = FileParseUtil.accessAuto(fileParseDto);
        BaseDto baseDto = (BaseDto) resultMap.get(FileParseUtil.BASE_DTO);
        List<ChapterDto> chapterDtoList = (List<ChapterDto>)resultMap.get(FileParseUtil.CHAPTER_DTO_LIST);
        chapterDtoList.forEach(s->{
            System.out.println(s.getTitle());});

        AdminServiceProxy adminServiceProxy = (AdminServiceProxy) context.getBean("fiction.service.adminServiceProxy");
        FictionBaseService fictionBaseService = (FictionBaseService) context.getBean("fiction.service.fictionBaseService");
        FictionAddReq fictionAddReq = new FictionAddReq();
        fictionAddReq.setTitle(baseDto.getTitle());
        fictionAddReq.setShortDesc(baseDto.getShortDesc());
        fictionAddReq.setCoverPhoto(baseDto.getPhoto());
        fictionAddReq.setTypeCode(baseDto.getType());
        fictionAddReq.setAuthorName(baseDto.getAuthor());
        fictionAddReq.setFullDesc(baseDto.getFullDesc());

        FictionSearchReq fictionSearchReq = new FictionSearchReq();
        fictionSearchReq.setTitle(baseDto.getTitle());
        int count = fictionBaseService.selectFullCountByCondition(fictionSearchReq);
        if(count>0){
            System.out.println("已存在重复名称:"+baseDto.getTitle());
        }
        String fictionResult = adminServiceProxy.createFiction(JsonUtil.toJson(fictionAddReq));
        ResponseDTO responseDTO = JsonUtil.fromJson(fictionResult, ResponseDTO.class);
        FictionBaseEntity fictionBaseEntity = JsonUtil.fromJson(responseDTO.getData("data"), FictionBaseEntity.class);
        System.out.println("#########: "+ JsonUtil.toJson(fictionBaseEntity));
        chapterDtoList.forEach(s->{
            FictionChapterAddReq fictionChapterAddReq = new FictionChapterAddReq();
            fictionChapterAddReq.setFictionCode(fictionBaseEntity.getLogicCode());
            fictionChapterAddReq.setChapterSort(s.getIndex());
            fictionChapterAddReq.setChapterName(s.getTitle());
            fictionChapterAddReq.setChapterType(1);// 1 free 2 not free
            fictionChapterAddReq.setChapterContent(s.getContent());
            adminServiceProxy.createFictionChapter(JsonUtil.toJson(fictionChapterAddReq));
        });
        System.out.println("#########: 结束");

    }

}
