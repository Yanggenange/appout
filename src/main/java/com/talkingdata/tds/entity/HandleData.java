package com.talkingdata.tds.entity;

import com.talkingdata.tds.base.entity.BaseEntity;

import java.util.Date;

/**
 * <b>功能：</b>handle_data HandleDataEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-08-29 <br>
 * <b>版权所有：<b>Copyright(C) 2015, Beijing TendCloud Science & Technology Co., Ltd.<br>
 */
public class HandleData extends BaseEntity {

    private Integer id;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date monitorDate;
    private Integer batch;
    private Integer batchNum;
    private Integer gid;
    private String appName;
    private String appNameEn;
    private String packageName;
    private Long packageHash;
    private String iconUrl;
    private String developer;
    private String referenceUrl;
    private String typeName;
    private String typeCode;
    private String inspectName;
    private String inspectCode;
    private String tips;
    private Integer status;
    private String failureCause;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>monitorDate -> monitor_date</li>
     * <li>batch -> batch</li>
     * <li>batchNum -> batch_num</li>
     * <li>gid -> gid</li>
     * <li>appName -> app_name</li>
     * <li>appNameEn -> app_name_en</li>
     * <li>packageName -> package_name</li>
     * <li>packageHash -> package_hash</li>
     * <li>iconUrl -> icon_url</li>
     * <li>developer -> developer</li>
     * <li>referenceUrl -> reference_url</li>
     * <li>typeName -> type_name</li>
     * <li>typeCode -> type_code</li>
     * <li>inspectName -> inspect_name</li>
     * <li>inspectCode -> inspect_code</li>
     * <li>tips -> tips</li>
     * <li>status -> status</li>
     * <li>failureCause -> failure_cause</li>
     * <li>createTime -> create_time</li>
     * <li>updateTime -> update_time</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "monitorDate": return "monitor_date";
            case "batch": return "batch";
            case "batchNum": return "batch_num";
            case "gid": return "gid";
            case "appName": return "app_name";
            case "appNameEn": return "app_name_en";
            case "packageName": return "package_name";
            case "packageHash": return "package_hash";
            case "iconUrl": return "icon_url";
            case "developer": return "developer";
            case "referenceUrl": return "reference_url";
            case "typeName": return "type_name";
            case "typeCode": return "type_code";
            case "inspectName": return "inspect_name";
            case "inspectCode": return "inspect_code";
            case "tips": return "tips";
            case "status": return "status";
            case "failureCause": return "failure_cause";
            case "createTime": return "create_time";
            case "updateTime": return "update_time";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>monitor_date -> monitorDate</li>
     * <li>batch -> batch</li>
     * <li>batch_num -> batchNum</li>
     * <li>gid -> gid</li>
     * <li>app_name -> appName</li>
     * <li>app_name_en -> appNameEn</li>
     * <li>package_name -> packageName</li>
     * <li>package_hash -> packageHash</li>
     * <li>icon_url -> iconUrl</li>
     * <li>developer -> developer</li>
     * <li>reference_url -> referenceUrl</li>
     * <li>type_name -> typeName</li>
     * <li>type_code -> typeCode</li>
     * <li>inspect_name -> inspectName</li>
     * <li>inspect_code -> inspectCode</li>
     * <li>tips -> tips</li>
     * <li>status -> status</li>
     * <li>failure_cause -> failureCause</li>
     * <li>create_time -> createTime</li>
     * <li>update_time -> updateTime</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "monitor_date": return "monitorDate";
            case "batch": return "batch";
            case "batch_num": return "batchNum";
            case "gid": return "gid";
            case "app_name": return "appName";
            case "app_name_en": return "appNameEn";
            case "package_name": return "packageName";
            case "package_hash": return "packageHash";
            case "icon_url": return "iconUrl";
            case "developer": return "developer";
            case "reference_url": return "referenceUrl";
            case "type_name": return "typeName";
            case "type_code": return "typeCode";
            case "inspect_name": return "inspectName";
            case "inspect_code": return "inspectCode";
            case "tips": return "tips";
            case "status": return "status";
            case "failure_cause": return "failureCause";
            case "create_time": return "createTime";
            case "update_time": return "updateTime";
            default: return null;
        }
    }
    
    /** 主键自增ID **/
    public Integer getId() {
        return this.id;
    }

    /** 主键自增ID **/
    public void setId(Integer id) {
        this.id = id;
    }

    /** 被统计日期(天、月) **/
    public Date getMonitorDate() {
        return this.monitorDate;
    }

    /** 被统计日期(天、月) **/
    public void setMonitorDate(Date monitorDate) {
        this.monitorDate = monitorDate;
    }

    /** 数据批次 **/
    public Integer getBatch() {
        return this.batch;
    }

    /** 数据批次 **/
    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    /** 同一批次推送次数 **/
    public Integer getBatchNum() {
        return this.batchNum;
    }

    /** 同一批次推送次数 **/
    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    /** 分组ID(默认分组id为1) **/
    public Integer getGid() {
        return this.gid;
    }

    /** 分组ID(默认分组id为1) **/
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /** App名称 **/
    public String getAppName() {
        return this.appName;
    }

    /** App名称 **/
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /** 英文名称 **/
    public String getAppNameEn() {
        return this.appNameEn;
    }

    /** 英文名称 **/
    public void setAppNameEn(String appNameEn) {
        this.appNameEn = appNameEn;
    }

    /** App包名 **/
    public String getPackageName() {
        return this.packageName;
    }

    /** App包名 **/
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /** 包名Hash **/
    public Long getPackageHash() {
        return this.packageHash;
    }

    /** 包名Hash **/
    public void setPackageHash(Long packageHash) {
        this.packageHash = packageHash;
    }

    /** 图标地址 **/
    public String getIconUrl() {
        return this.iconUrl;
    }

    /** 图标地址 **/
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /** 开发者 **/
    public String getDeveloper() {
        return this.developer;
    }

    /** 开发者 **/
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    /** 参考URL **/
    public String getReferenceUrl() {
        return this.referenceUrl;
    }

    /** 参考URL **/
    public void setReferenceUrl(String referenceUrl) {
        this.referenceUrl = referenceUrl;
    }

    /** 二级分类名称 **/
    public String getTypeName() {
        return this.typeName;
    }

    /** 二级分类名称 **/
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /** 二级分类code **/
    public String getTypeCode() {
        return this.typeCode;
    }

    /** 二级分类code **/
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /** 质检分类名称 **/
    public String getInspectName() {
        return this.inspectName;
    }

    /** 质检分类名称 **/
    public void setInspectName(String inspectName) {
        this.inspectName = inspectName;
    }

    /** 质检分类code **/
    public String getInspectCode() {
        return this.inspectCode;
    }

    /** 质检分类code **/
    public void setInspectCode(String inspectCode) {
        this.inspectCode = inspectCode;
    }

    /** 人工备注 **/
    public String getTips() {
        return this.tips;
    }

    /** 人工备注 **/
    public void setTips(String tips) {
        this.tips = tips;
    }

    /** 数据状态(1、未推送;4、质检失败;5、质检成功) **/
    public Integer getStatus() {
        return this.status;
    }

    /** 数据状态(1、未推送;4、质检失败;5、质检成功) **/
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 质检失败的原因 **/
    public String getFailureCause() {
        return this.failureCause;
    }

    /** 质检失败的原因 **/
    public void setFailureCause(String failureCause) {
        this.failureCause = failureCause;
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
