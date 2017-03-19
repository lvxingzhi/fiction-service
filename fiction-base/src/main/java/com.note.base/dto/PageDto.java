package com.note.base.dto;

/**
 * 分页实体
 */
public class PageDto {

    public static final int MIN = 1;
    public static final int MAX = 19891222;

    public static final int DEFAULT_SIZE=50;

    private int page = MIN;
    private int size = DEFAULT_SIZE;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOffset() {
        if(MIN == page){
            return 0;
        }else{
            return (page-1)*size;
        }

    }

    public int getLimit() {
        return size;
    }

}
