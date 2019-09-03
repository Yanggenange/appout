package com.talkingdata.tds.page;

import com.talkingdata.tds.base.page.BasePage;

import java.util.Date;

/**
 * <b>功能：</b>handle_data HandleDataPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-08-29 <br>
 * <b>版权所有：<b>Copyright(C) 2015, Beijing TendCloud Science & Technology Co., Ltd.<br>
 */
public class HandleDataPage extends BasePage {

    private String id;
    private String idOperator = "=";
    private String monitorDate;
    private String monitorDate1;
    private String monitorDate2;
    private String monitorDateOperator = "=";
    private String batch;
    private String batchOperator = "=";
    private String batchNum;
    private String batchNumOperator = "=";
    private String gid;
    private String gidOperator = "=";
    private String appName;
    private String appNameOperator = "=";
    private String appNameEn;
    private String appNameEnOperator = "=";
    private String packageName;
    private String packageNameOperator = "=";
    private String packageHash;
    private String packageHashOperator = "=";
    private String iconUrl;
    private String iconUrlOperator = "=";
    private String developer;
    private String developerOperator = "=";
    private String referenceUrl;
    private String referenceUrlOperator = "=";
    private String typeName;
    private String typeNameOperator = "=";
    private String typeCode;
    private String typeCodeOperator = "=";
    private String inspectName;
    private String inspectNameOperator = "=";
    private String inspectCode;
    private String inspectCodeOperator = "=";
    private String tips;
    private String tipsOperator = "=";
    private String status;
    private String statusOperator = "=";
    private String failureCause;
    private String failureCauseOperator = "=";
    private String createTime;
    private String createTime1;
    private String createTime2;
    private String createTimeOperator = "=";
    private String updateTime;
    private String updateTime1;
    private String updateTime2;
    private String updateTimeOperator = "=";
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOperator() {
        return this.idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

    public String getMonitorDate() {
        return this.monitorDate;
    }

    public void setMonitorDate(String monitorDate) {
        this.monitorDate = monitorDate;
    }

    public String getMonitorDate1() {
        return this.monitorDate1;
    }

    public void setMonitorDate1(String monitorDate1) {
        this.monitorDate1 = monitorDate1;
    }

    public String getMonitorDate2() {
        return this.monitorDate2;
    }

    public void setMonitorDate2(String monitorDate2) {
        this.monitorDate2 = monitorDate2;
    }

    public String getMonitorDateOperator() {
        return this.monitorDateOperator;
    }

    public void setMonitorDateOperator(String monitorDateOperator) {
        this.monitorDateOperator = monitorDateOperator;
    }

    public String getBatch() {
        return this.batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBatchOperator() {
        return this.batchOperator;
    }

    public void setBatchOperator(String batchOperator) {
        this.batchOperator = batchOperator;
    }

    public String getBatchNum() {
        return this.batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getBatchNumOperator() {
        return this.batchNumOperator;
    }

    public void setBatchNumOperator(String batchNumOperator) {
        this.batchNumOperator = batchNumOperator;
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGidOperator() {
        return this.gidOperator;
    }

    public void setGidOperator(String gidOperator) {
        this.gidOperator = gidOperator;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppNameOperator() {
        return this.appNameOperator;
    }

    public void setAppNameOperator(String appNameOperator) {
        this.appNameOperator = appNameOperator;
    }

    public String getAppNameEn() {
        return this.appNameEn;
    }

    public void setAppNameEn(String appNameEn) {
        this.appNameEn = appNameEn;
    }

    public String getAppNameEnOperator() {
        return this.appNameEnOperator;
    }

    public void setAppNameEnOperator(String appNameEnOperator) {
        this.appNameEnOperator = appNameEnOperator;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageNameOperator() {
        return this.packageNameOperator;
    }

    public void setPackageNameOperator(String packageNameOperator) {
        this.packageNameOperator = packageNameOperator;
    }

    public String getPackageHash() {
        return this.packageHash;
    }

    public void setPackageHash(String packageHash) {
        this.packageHash = packageHash;
    }

    public String getPackageHashOperator() {
        return this.packageHashOperator;
    }

    public void setPackageHashOperator(String packageHashOperator) {
        this.packageHashOperator = packageHashOperator;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIconUrlOperator() {
        return this.iconUrlOperator;
    }

    public void setIconUrlOperator(String iconUrlOperator) {
        this.iconUrlOperator = iconUrlOperator;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getDeveloperOperator() {
        return this.developerOperator;
    }

    public void setDeveloperOperator(String developerOperator) {
        this.developerOperator = developerOperator;
    }

    public String getReferenceUrl() {
        return this.referenceUrl;
    }

    public void setReferenceUrl(String referenceUrl) {
        this.referenceUrl = referenceUrl;
    }

    public String getReferenceUrlOperator() {
        return this.referenceUrlOperator;
    }

    public void setReferenceUrlOperator(String referenceUrlOperator) {
        this.referenceUrlOperator = referenceUrlOperator;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeNameOperator() {
        return this.typeNameOperator;
    }

    public void setTypeNameOperator(String typeNameOperator) {
        this.typeNameOperator = typeNameOperator;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCodeOperator() {
        return this.typeCodeOperator;
    }

    public void setTypeCodeOperator(String typeCodeOperator) {
        this.typeCodeOperator = typeCodeOperator;
    }

    public String getInspectName() {
        return this.inspectName;
    }

    public void setInspectName(String inspectName) {
        this.inspectName = inspectName;
    }

    public String getInspectNameOperator() {
        return this.inspectNameOperator;
    }

    public void setInspectNameOperator(String inspectNameOperator) {
        this.inspectNameOperator = inspectNameOperator;
    }

    public String getInspectCode() {
        return this.inspectCode;
    }

    public void setInspectCode(String inspectCode) {
        this.inspectCode = inspectCode;
    }

    public String getInspectCodeOperator() {
        return this.inspectCodeOperator;
    }

    public void setInspectCodeOperator(String inspectCodeOperator) {
        this.inspectCodeOperator = inspectCodeOperator;
    }

    public String getTips() {
        return this.tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getTipsOperator() {
        return this.tipsOperator;
    }

    public void setTipsOperator(String tipsOperator) {
        this.tipsOperator = tipsOperator;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusOperator() {
        return this.statusOperator;
    }

    public void setStatusOperator(String statusOperator) {
        this.statusOperator = statusOperator;
    }

    public String getFailureCause() {
        return this.failureCause;
    }

    public void setFailureCause(String failureCause) {
        this.failureCause = failureCause;
    }

    public String getFailureCauseOperator() {
        return this.failureCauseOperator;
    }

    public void setFailureCauseOperator(String failureCauseOperator) {
        this.failureCauseOperator = failureCauseOperator;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime1() {
        return this.createTime1;
    }

    public void setCreateTime1(String createTime1) {
        this.createTime1 = createTime1;
    }

    public String getCreateTime2() {
        return this.createTime2;
    }

    public void setCreateTime2(String createTime2) {
        this.createTime2 = createTime2;
    }

    public String getCreateTimeOperator() {
        return this.createTimeOperator;
    }

    public void setCreateTimeOperator(String createTimeOperator) {
        this.createTimeOperator = createTimeOperator;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTime1() {
        return this.updateTime1;
    }

    public void setUpdateTime1(String updateTime1) {
        this.updateTime1 = updateTime1;
    }

    public String getUpdateTime2() {
        return this.updateTime2;
    }

    public void setUpdateTime2(String updateTime2) {
        this.updateTime2 = updateTime2;
    }

    public String getUpdateTimeOperator() {
        return this.updateTimeOperator;
    }

    public void setUpdateTimeOperator(String updateTimeOperator) {
        this.updateTimeOperator = updateTimeOperator;
    }

}
