package com.note.provider.fiction.proxy;

import com.note.base.dto.file.BaseDto;
import com.note.base.dto.file.ChapterDto;
import com.note.base.dto.file.FileParseDto;
import com.note.base.utils.FileParseUtil;
import com.note.base.utils.JsonUtil;
import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.provider.fiction.api.AdminApiService;
import com.note.provider.fiction.dto.request.FictionAddReq;
import com.note.provider.fiction.dto.request.FictionChapterAddReq;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
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
public class MainFile {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/applicationContext.xml"});
        context.start();
        System.out.println("#########: 开始");
        FileParseDto fileParseDto = new FileParseDto();
        fileParseDto.setPath("F:/");
        fileParseDto.setFileName("新建文本文档.txt");
        fileParseDto.setEncode("UTF-8");
        System.out.println("#########: "+fileParseDto.toString());

        Map<String,Object> resultMap = FileParseUtil.access(fileParseDto);
        BaseDto baseDto = (BaseDto) resultMap.get(FileParseUtil.BASE_DTO);
        List<ChapterDto> chapterDtoList = (List<ChapterDto>)resultMap.get(FileParseUtil.CHAPTER_DTO_LIST);

        AdminApiService adminApiService = (AdminApiService) context.getBean("fiction.service.adminServiceProxy");
        FictionAddReq fictionAddReq = new FictionAddReq();
        fictionAddReq.setTitle(baseDto.getTitle());
        fictionAddReq.setShortDesc(baseDto.getShortDesc());
        fictionAddReq.setCoverPhoto(baseDto.getPhoto());
        fictionAddReq.setTypeCode(baseDto.getType());
        fictionAddReq.setAuthorName(baseDto.getAuthor());
        fictionAddReq.setFullDesc(baseDto.getShortDesc());
        String fictionResult = adminApiService.createFiction(JsonUtil.toJson(fictionAddReq));
        FictionBaseEntity fictionBaseEntity = JsonUtil.fromJson(fictionResult, FictionBaseEntity.class);
        System.out.println("#########: "+JsonUtil.toJson(fictionBaseEntity));
        chapterDtoList.forEach(s->{
            FictionChapterAddReq fictionChapterAddReq = new FictionChapterAddReq();
            fictionChapterAddReq.setFictionCode(fictionBaseEntity.getLogicCode());
            fictionChapterAddReq.setChapterSort(s.getIndex());
            fictionChapterAddReq.setChapterName(s.getTitle());
            fictionChapterAddReq.setChapterType(1);// 1 free 2 not free
            fictionChapterAddReq.setChapterContent(s.getContent());
            adminApiService.createFictionChapter(JsonUtil.toJson(fictionChapterAddReq));
            System.out.println("#########: "+fictionChapterAddReq.getChapterName());
        });
        System.out.println("#########: 结束");

    }

}
