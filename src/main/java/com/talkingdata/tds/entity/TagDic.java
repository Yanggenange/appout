package com.talkingdata.tds.entity;

import com.talkingdata.tds.base.entity.BaseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>功能：</b>tag_dic TagDicEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-08-29 <br>
 * <b>版权所有：<b>Copyright(C) 2015, Beijing TendCloud Science & Technology Co., Ltd.<br>
 */
public class TagDic extends BaseEntity {

    private Integer id;
    private Integer tagId;
    private String code;
    private String name;
    private String nameEn;
    private String parentCode;
    private String description;
   /* private Integer level;
    private String tagPath;*/
    private Integer isLeaf;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    //用来封装子级数据
    private List<TagDic> children = new ArrayList<TagDic>(0);
    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>tagId -> tag_id</li>
     * <li>code -> code</li>
     * <li>name -> name</li>
     * <li>nameEn -> name_en</li>
     * <li>parentCode -> parent_code</li>
     * <li>description -> description</li>
     * <li>level -> level</li>
     * <li>tagPath -> tag_path</li>
     * <li>isLeaf -> is_leaf</li>
     * <li>createTime -> create_time</li>
     * <li>updateTime -> update_time</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "tagId": return "tag_id";
            case "code": return "code";
            case "name": return "name";
            case "nameEn": return "name_en";
            case "parentCode": return "parent_code";
            case "description": return "description";
            case "level": return "level";
            case "tagPath": return "tag_path";
            case "isLeaf": return "is_leaf";
            case "createTime": return "create_time";
            case "updateTime": return "update_time";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>tag_id -> tagId</li>
     * <li>code -> code</li>
     * <li>name -> name</li>
     * <li>name_en -> nameEn</li>
     * <li>parent_code -> parentCode</li>
     * <li>description -> description</li>
     * <li>level -> level</li>
     * <li>tag_path -> tagPath</li>
     * <li>is_leaf -> isLeaf</li>
     * <li>create_time -> createTime</li>
     * <li>update_time -> updateTime</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "tag_id": return "tagId";
            case "code": return "code";
            case "name": return "name";
            case "name_en": return "nameEn";
            case "parent_code": return "parentCode";
            case "description": return "description";
            case "level": return "level";
            case "tag_path": return "tagPath";
            case "is_leaf": return "isLeaf";
            case "create_time": return "createTime";
            case "update_time": return "updateTime";
            default: return null;
        }
    }

    public List<TagDic> getChildren() {
        return children;
    }

    public void setChildren(List<TagDic> children) {
        this.children = children;
    }

    /** 主键自增ID **/
    public Integer getId() {
        return this.id;
    }

    /** 主键自增ID **/
    public void setId(Integer id) {
        this.id = id;
    }

    /** 标签ID **/
    public Integer getTagId() {
        return this.tagId;
    }

    /** 标签ID **/
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /** 标签code **/
    public String getCode() {
        return this.code;
    }

    /** 标签code **/
    public void setCode(String code) {
        this.code = code;
    }

    /** 标签名称 **/
    public String getName() {
        return this.name;
    }

    /** 标签名称 **/
    public void setName(String name) {
        this.name = name;
    }

    /** 标签英文名称 **/
    public String getNameEn() {
        return this.nameEn;
    }

    /** 标签英文名称 **/
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /** 父标签code **/
    public String getParentCode() {
        return this.parentCode;
    }

    /** 父标签code **/
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /** 标签描述 **/
    public String getDescription() {
        return this.description;
    }

    /** 标签描述 **/
    public void setDescription(String description) {
        this.description = description;
    }

   /* *//** 层级 **//*
    public Integer getLevel() {
        return this.level;
    }

    *//** 层级 **//*
    public void setLevel(Integer level) {
        this.level = level;
    }

    *//** 标签路径 **//*
    public String getTagPath() {
        return this.tagPath;
    }

    *//** 标签路径 **//*
    public void setTagPath(String tagPath) {
        this.tagPath = tagPath;
    }*/

    /**  **/
    public Integer getIsLeaf() {
        return this.isLeaf;
    }

    /**  **/
    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    /** 创建时间 **/
    public Date getCreateTime() {
        return this.createTime;
    }

    /** 创建时间 **/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 更新时间 **/
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /** 更新时间 **/
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
