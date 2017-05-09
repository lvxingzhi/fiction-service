package com.note.base.dto;

import java.util.HashMap;

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
 * @date 2017/5/9
 * @since 1.0
 */
public class ResponseDTO {

    private static final Integer SUCCESS = 0;
    private static final Integer ERROR = 1;

    private String message = "";
    private Integer status = SUCCESS;
    private HashMap<String,Object> data = new HashMap<>();

    private ResponseDTO(){
    }

    private ResponseDTO(String message){
        this.message = message;
    }

    public static ResponseDTO getSuccessInstance(){
        return new ResponseDTO();
    }

    public static ResponseDTO getSuccessInstance(String message){
        return new ResponseDTO(message);
    }

    public static ResponseDTO getErrorInstance(){
        ResponseDTO dto = new ResponseDTO();
        dto.setStatus(ERROR);
        return dto;
    }

    public static ResponseDTO getErrorInstance(String message){
        ResponseDTO dto = new ResponseDTO(message);
        dto.setStatus(ERROR);
        dto.setMessage(message);
        return dto;
    }

    public boolean isSuccess(){
        return this.getStatus()==SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

}
