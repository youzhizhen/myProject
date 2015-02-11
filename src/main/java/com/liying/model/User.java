package com.liying.model;

import java.util.Date;

public class User {

    private String id;
    
    private String username;

    private String password;

    private String nickname;

    private String typeCode;

    private String typeName;

    private String statusCode;

    private boolean hasQuestionnaire;

    private String dealerCode;

    private String dealerName;

    private String usbKeyInfo;

    private String usbKeyId;

    private String secretKey;

    private Date createdDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;

    private boolean requiredUK;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isHasQuestionnaire() {
        return hasQuestionnaire;
    }

    public void setHasQuestionnaire(boolean hasQuestionnaire) {
        this.hasQuestionnaire = hasQuestionnaire;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getUsbKeyInfo() {
        return usbKeyInfo;
    }

    public void setUsbKeyInfo(String usbKeyInfo) {
        this.usbKeyInfo = usbKeyInfo;
    }

    public String getUsbKeyId() {
        return usbKeyId;
    }

    public void setUsbKeyId(String usbKeyId) {
        this.usbKeyId = usbKeyId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public boolean isRequiredUK() {
        return requiredUK;
    }

    public void setRequiredUK(boolean requiredUK) {
        this.requiredUK = requiredUK;
    }
}
