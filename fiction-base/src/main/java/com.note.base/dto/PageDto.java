package com.note.base.dto;

/**
 * 分页实体
 */
public class PageDto {

    private static final int MIN = 1;
    private static final int MAX = 19891222;

    private static final int DEFAULT_SIZE=50;

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
            return MIN;
        }else{
            return (page-1)*size+1;
        }

    }

    public int getLimit() {
        return size;
    }

}
