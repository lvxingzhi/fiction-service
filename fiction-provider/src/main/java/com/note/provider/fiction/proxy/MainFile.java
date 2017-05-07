package com.note.provider.fiction.proxy;

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

    // TODO 建立作者库
    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/applicationContext.xml"});
//        context.start();
//        FictionChapterService fictionChapterService = (FictionChapterService)context.getBean("fiction.service.fictionChapterService");
//        //  保存基本信息
//        FictionBaseEntity fictionBaseEntity = new FictionBaseEntity();
//        fictionBaseEntity.setLogicCode(UUIDGenerator.uuid());
//        fictionBaseEntity.setTitle("");
//        fictionBaseEntity.setShortDesc("");
//        fictionBaseEntity.setCoverPhoto("");
//        fictionBaseEntity.setTypeCode(FictionTypeEnum.ORIGINAL_NORMAL.getType());
//        fictionBaseEntity.setTypeName(FictionTypeEnum.ORIGINAL_NORMAL.getDesc());
//        fictionBaseEntity.setAuthorCode("");
//        fictionBaseEntity.setAuthorName("");
//        fictionBaseEntity.setFictionStatus(FictionStatusEnum.ING.getType());
////      fictionBaseEntity.setChapterTotal(); // TODO 删除此字段,保留扩展信息中
//        fictionBaseEntity.setCreateTime(DateUtil.nowDate());
//        fictionBaseEntity.setModifyTime(DateUtil.nowDate());
//        fictionBaseEntity.setCreateUserCode("system");
//        fictionBaseEntity.setModifyUserCode("system");
//
//        // TODO 保存扩展信息
//        FictionExtentionEntity fictionExtentionEntity = new FictionExtentionEntity();
//        fictionExtentionEntity.setLogicCode(UUIDGenerator.uuid());
//        fictionExtentionEntity.setFictionCode(fictionBaseEntity.getLogicCode());
//        fictionExtentionEntity.setFictionScore(980.0);
//        fictionExtentionEntity.setFictionScoreNum(100);
//        fictionExtentionEntity.setFullDesc("");
//        fictionExtentionEntity.setTotalChapter(0);
//        fictionExtentionEntity.setTotalWord(0);
//        fictionExtentionEntity.setLastUpdateTime(DateUtil.nowDate());
//        fictionExtentionEntity.setLevel(0); // TODO 暂时没有用
//        fictionExtentionEntity.setFictionViews(0);
//        fictionExtentionEntity.setCreateTime(DateUtil.nowDate());
//        fictionExtentionEntity.setModifyTime(DateUtil.nowDate());
//        fictionExtentionEntity.setCreateUserCode("system");
//        fictionExtentionEntity.setModifyUserCode("system");
//        fictionExtentionEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
//
//        //  保存章节基本信息,扩展信息
//        FileParseDto fileParseDto = new FileParseDto();
//        fileParseDto.setEncode("GBK");
//        fileParseDto.setHeadTag("chapter");
//        fileParseDto.setPath("d:/");
//        fileParseDto.setFileName("abc.txt");
//        List<ChapterDto> chapterDtoList = FileParseUtil.parse(fileParseDto);
//
//        System.out.println(JsonUtil.toJson(chapterDtoList));
//        final List<FictionChapterEntity> list = new ArrayList<>();
//        if(ObjectUtil.notNull(chapterDtoList)){
//            chapterDtoList.forEach((ChapterDto chapterDto) -> {
//                FictionChapterEntity fictionChapterEntity = new FictionChapterEntity();
//                fictionChapterEntity.setLogicCode(UUIDGenerator.uuid());
//                fictionChapterEntity.setFictionCode(fictionBaseEntity.getLogicCode());
//                fictionChapterEntity.setChapterSort(chapterDto.getIndex()+"");
//                fictionChapterEntity.setChapterName(chapterDto.getTitle());
//                fictionChapterEntity.setChapterType(ChapterTypeEnum.NORMAL.getType());
//                fictionChapterEntity.setChapterViews(0);
//                fictionChapterEntity.setChapterWordCount(chapterDto.getTotal());
//                fictionChapterEntity.setCreateTime(DateUtil.nowDate());
//                fictionChapterEntity.setModifyTime(DateUtil.nowDate());
//                fictionChapterEntity.setCreateUserCode("system");
//                fictionChapterEntity.setModifyUserCode("system");
//                fictionChapterEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
//                list.add(fictionChapterEntity);
//
//                FictionChapterExtentionEntity fictionChapterExtentionEntity = new FictionChapterExtentionEntity();
//                fictionChapterExtentionEntity.setLogicCode(UUIDGenerator.uuid());
//                fictionChapterExtentionEntity.setChapterCode(fictionChapterEntity.getLogicCode());
//                fictionChapterExtentionEntity.setCreateTime(DateUtil.nowDate());
//                fictionChapterExtentionEntity.setCreateUserCode("system");
//                fictionChapterExtentionEntity.setModifyTime(DateUtil.nowDate());
//                fictionChapterExtentionEntity.setModifyUserCode("system");
//                fictionChapterExtentionEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
//                fictionChapterExtentionEntity.setChapterContent(chapterDto.getContent());
//                try {
//                    fictionChapterService.add(fictionChapterEntity,fictionChapterExtentionEntity);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        fictionExtentionEntity.setTotalChapter(list.size());
//        fictionExtentionEntity.setLastChapterName(list.get(list.size()).getChapterName());
//        fictionExtentionEntity.setLastChapterCode(list.get(list.size()).getLogicCode());
//
//
//        // TODO 一个事务中保存
//
//        System.out.println(JsonUtil.toJson(list));


    }

}
