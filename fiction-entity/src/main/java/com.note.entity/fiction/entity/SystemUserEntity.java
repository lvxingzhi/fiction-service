package com.note.entity.fiction.entity;

import java.util.Date;

public class SystemUserEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.cid
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.logic_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String logicCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.name
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.phone
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.photo
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String photo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.type
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.level
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer level;

    /**
     * 积分
     */
    private Integer score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.login_name
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String loginName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.login_password
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String loginPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.email
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.address
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.create_time
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.modify_time
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.create_user_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String createUserCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.modify_user_code
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private String modifyUserCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_user.is_delete
     *
     * @mbg.generated Sat Feb 25 22:52:36 CST 2017
     */
    private Integer isDelete;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getLogicCode() {
        return logicCode;
    }

    public void setLogicCode(String logicCode) {
        this.logicCode = logicCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getModifyUserCode() {
        return modifyUserCode;
    }

    public void setModifyUserCode(String modifyUserCode) {
        this.modifyUserCode = modifyUserCode;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}