package com.bcs.tja.domain;

import java.io.Serializable;
import java.util.Date;

public class Organization implements Serializable {
    /**  v_sys_organization.ORGID */
    private String orgid;

    /**  v_sys_organization.ORGNAME */
    private String orgname;

    /**  v_sys_organization.PORGID */
    private String porgid;

    /**  v_sys_organization.UNITID */
    private String unitid;

    /**  v_sys_organization.UNITNAME */
    private String unitname;

    /**  v_sys_organization.DEPTID */
    private String deptid;

    /**  v_sys_organization.DEPTNAME */
    private String deptname;

    /**  v_sys_organization.ORGCODE */
    private String orgcode;

    /**  v_sys_organization.ORGTYPE */
    private String orgtype;

    /**  v_sys_organization.CANCELDATE */
    private String canceldate;

    /**  v_sys_organization.CREATEDATE */
    private String createdate;

    /**  v_sys_organization.ISLEAF */
    private String isleaf;

    /**  v_sys_organization.DESCRIPTION */
    private String description;

    /**  v_sys_organization.DISPLAYORDER */
    private String displayorder;

    /**  v_sys_organization.ORGSTATUS */
    private String orgstatus;

    /**  v_sys_organization.SALUNITID */
    private String salunitid;

    /**  v_sys_organization.SALUNITNAME */
    private String salunitname;

    /**  v_sys_organization.ORGLEVEL */
    private String orglevel;

    /**  v_sys_organization.OBJECTTYPEID */
    private String objecttypeid;

    /**  v_sys_organization.OBJECTTYPENAME */
    private String objecttypename;

    /**  v_sys_organization.ORGSN */
    private Double orgsn;

    /**  v_sys_organization.update_time */
    private Date updateTime;

    /**  v_sys_organization.delete_status */
    private Integer deleteStatus;

    private static final long serialVersionUID = 1L;

    /**
     *  获取 v_sys_organization.ORGID
     */
    public String getOrgid() {
        return orgid;
    }

    /**
     *  设置 v_sys_organization.ORGID
     */
    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    /**
     *  获取 v_sys_organization.ORGNAME
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     *  设置 v_sys_organization.ORGNAME
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    /**
     *  获取 v_sys_organization.PORGID
     */
    public String getPorgid() {
        return porgid;
    }

    /**
     *  设置 v_sys_organization.PORGID
     */
    public void setPorgid(String porgid) {
        this.porgid = porgid == null ? null : porgid.trim();
    }

    /**
     *  获取 v_sys_organization.UNITID
     */
    public String getUnitid() {
        return unitid;
    }

    /**
     *  设置 v_sys_organization.UNITID
     */
    public void setUnitid(String unitid) {
        this.unitid = unitid == null ? null : unitid.trim();
    }

    /**
     *  获取 v_sys_organization.UNITNAME
     */
    public String getUnitname() {
        return unitname;
    }

    /**
     *  设置 v_sys_organization.UNITNAME
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    /**
     *  获取 v_sys_organization.DEPTID
     */
    public String getDeptid() {
        return deptid;
    }

    /**
     *  设置 v_sys_organization.DEPTID
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    /**
     *  获取 v_sys_organization.DEPTNAME
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     *  设置 v_sys_organization.DEPTNAME
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    /**
     *  获取 v_sys_organization.ORGCODE
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     *  设置 v_sys_organization.ORGCODE
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    /**
     *  获取 v_sys_organization.ORGTYPE
     */
    public String getOrgtype() {
        return orgtype;
    }

    /**
     *  设置 v_sys_organization.ORGTYPE
     */
    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype == null ? null : orgtype.trim();
    }

    /**
     *  获取 v_sys_organization.CANCELDATE
     */
    public String getCanceldate() {
        return canceldate;
    }

    /**
     *  设置 v_sys_organization.CANCELDATE
     */
    public void setCanceldate(String canceldate) {
        this.canceldate = canceldate == null ? null : canceldate.trim();
    }

    /**
     *  获取 v_sys_organization.CREATEDATE
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     *  设置 v_sys_organization.CREATEDATE
     */
    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    /**
     *  获取 v_sys_organization.ISLEAF
     */
    public String getIsleaf() {
        return isleaf;
    }

    /**
     *  设置 v_sys_organization.ISLEAF
     */
    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf == null ? null : isleaf.trim();
    }

    /**
     *  获取 v_sys_organization.DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     *  设置 v_sys_organization.DESCRIPTION
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     *  获取 v_sys_organization.DISPLAYORDER
     */
    public String getDisplayorder() {
        return displayorder;
    }

    /**
     *  设置 v_sys_organization.DISPLAYORDER
     */
    public void setDisplayorder(String displayorder) {
        this.displayorder = displayorder == null ? null : displayorder.trim();
    }

    /**
     *  获取 v_sys_organization.ORGSTATUS
     */
    public String getOrgstatus() {
        return orgstatus;
    }

    /**
     *  设置 v_sys_organization.ORGSTATUS
     */
    public void setOrgstatus(String orgstatus) {
        this.orgstatus = orgstatus == null ? null : orgstatus.trim();
    }

    /**
     *  获取 v_sys_organization.SALUNITID
     */
    public String getSalunitid() {
        return salunitid;
    }

    /**
     *  设置 v_sys_organization.SALUNITID
     */
    public void setSalunitid(String salunitid) {
        this.salunitid = salunitid == null ? null : salunitid.trim();
    }

    /**
     *  获取 v_sys_organization.SALUNITNAME
     */
    public String getSalunitname() {
        return salunitname;
    }

    /**
     *  设置 v_sys_organization.SALUNITNAME
     */
    public void setSalunitname(String salunitname) {
        this.salunitname = salunitname == null ? null : salunitname.trim();
    }

    /**
     *  获取 v_sys_organization.ORGLEVEL
     */
    public String getOrglevel() {
        return orglevel;
    }

    /**
     *  设置 v_sys_organization.ORGLEVEL
     */
    public void setOrglevel(String orglevel) {
        this.orglevel = orglevel == null ? null : orglevel.trim();
    }

    /**
     *  获取 v_sys_organization.OBJECTTYPEID
     */
    public String getObjecttypeid() {
        return objecttypeid;
    }

    /**
     *  设置 v_sys_organization.OBJECTTYPEID
     */
    public void setObjecttypeid(String objecttypeid) {
        this.objecttypeid = objecttypeid == null ? null : objecttypeid.trim();
    }

    /**
     *  获取 v_sys_organization.OBJECTTYPENAME
     */
    public String getObjecttypename() {
        return objecttypename;
    }

    /**
     *  设置 v_sys_organization.OBJECTTYPENAME
     */
    public void setObjecttypename(String objecttypename) {
        this.objecttypename = objecttypename == null ? null : objecttypename.trim();
    }

    /**
     *  获取 v_sys_organization.ORGSN
     */
    public Double getOrgsn() {
        return orgsn;
    }

    /**
     *  设置 v_sys_organization.ORGSN
     */
    public void setOrgsn(Double orgsn) {
        this.orgsn = orgsn;
    }

    /**
     *  获取 v_sys_organization.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *  设置 v_sys_organization.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *  获取 v_sys_organization.delete_status
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     *  设置 v_sys_organization.delete_status
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}