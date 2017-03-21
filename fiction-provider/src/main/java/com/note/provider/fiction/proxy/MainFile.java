package com.note.provider.fiction.proxy;

import com.note.base.dto.file.ChapterDto;
import com.note.base.dto.file.FileParseDto;
import com.note.base.enums.ChapterTypeEnum;
import com.note.base.enums.DeleteConst;
import com.note.base.utils.*;
import com.note.entity.fiction.entity.FictionChapterEntity;
import com.note.entity.fiction.entity.FictionChapterExtentionEntity;
import com.note.provider.fiction.service.FictionChapterService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
 * @date 2017/3/21
 * @since 1.0
 */
public class MainFile {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/applicationContext.xml"});
        context.start();
        FictionChapterService fictionChapterService = (FictionChapterService)context.getBean("fiction.service.fictionChapterService");
        // TODO 保存基本信息

        // TODO 保存扩展信息

        //  保存章节基本信息,扩展信息
        FileParseDto fileParseDto = new FileParseDto();
        fileParseDto.setEncode("GBK");
        fileParseDto.setHeadTag("chapter");
        fileParseDto.setPath("d:/");
        fileParseDto.setFileName("abc.txt");
        List<ChapterDto> chapterDtoList = FileParseUtil.parse(fileParseDto);
        System.out.println(JsonUtil.toJson(chapterDtoList));
        final List<FictionChapterEntity> list = new ArrayList<>();
        if(ObjectUtil.notNull(chapterDtoList)){
            chapterDtoList.forEach((ChapterDto chapterDto) -> {
                FictionChapterEntity fictionChapterEntity = new FictionChapterEntity();
                fictionChapterEntity.setLogicCode(UUIDGenerator.uuid());
                fictionChapterEntity.setFictionCode("");
                fictionChapterEntity.setChapterSort(chapterDto.getIndex()+"");
                fictionChapterEntity.setChapterName(chapterDto.getTitle());
                fictionChapterEntity.setChapterType(1);
                fictionChapterEntity.setChapterViews(ChapterTypeEnum.NORMAL.getType());
                fictionChapterEntity.setChapterWordCount(chapterDto.getTotal());
                fictionChapterEntity.setCreateTime(DateUtil.nowDate());
                fictionChapterEntity.setModifyTime(DateUtil.nowDate());
                fictionChapterEntity.setCreateUserCode("system");
                fictionChapterEntity.setModifyUserCode("system");
                fictionChapterEntity.setIsDelete(DeleteConst.NOT_DELETE);
                list.add(fictionChapterEntity);

                FictionChapterExtentionEntity fictionChapterExtentionEntity = new FictionChapterExtentionEntity();
                fictionChapterExtentionEntity.setLogicCode(UUIDGenerator.uuid());
                fictionChapterExtentionEntity.setChapterCode(fictionChapterEntity.getLogicCode());
                fictionChapterExtentionEntity.setCreateTime(DateUtil.nowDate());
                fictionChapterExtentionEntity.setCreateUserCode("system");
                fictionChapterExtentionEntity.setModifyTime(DateUtil.nowDate());
                fictionChapterExtentionEntity.setModifyUserCode("system");
                fictionChapterExtentionEntity.setIsDelete(DeleteConst.NOT_DELETE);
                fictionChapterExtentionEntity.setChapterContent(chapterDto.getContent());
                try {
                    fictionChapterService.add(fictionChapterEntity,fictionChapterExtentionEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(JsonUtil.toJson(list));


    }

}
