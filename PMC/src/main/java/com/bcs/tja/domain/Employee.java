package com.bcs.tja.domain;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    /**  v_sys_employee.EMPID */
    private String empid;

    /**  v_sys_employee.EMPNAME */
    private String empname;

    /**  v_sys_employee.DISPLAYORDER */
    private String displayorder;

    /**  v_sys_employee.ORGID */
    private String orgid;

    /**  v_sys_employee.ORGNAME */
    private String orgname;

    /**  v_sys_employee.DEPTID */
    private String deptid;

    /**  v_sys_employee.DEPTNAME */
    private String deptname;

    /**  v_sys_employee.UNITID */
    private String unitid;

    /**  v_sys_employee.UNITNAME */
    private String unitname;

    /**  v_sys_employee.SALUNITID */
    private String salunitid;

    /**  v_sys_employee.SALUNITNAME */
    private String salunitname;

    /**  v_sys_employee.SBOOKS */
    private String sbooks;

    /**  v_sys_employee.ISSALARYPAY */
    private String issalarypay;

    /**  v_sys_employee.POSSERIAL */
    private String posserial;

    /**  v_sys_employee.POSSERIALLEVEL */
    private String posseriallevel;

    /**  v_sys_employee.CLIENTMNGTYPE */
    private String clientmngtype;

    /**  v_sys_employee.POSID */
    private String posid;

    /**  v_sys_employee.POSNAME */
    private String posname;

    /**  v_sys_employee.POSCLASSIFYID */
    private String posclassifyid;

    /**  v_sys_employee.POSCLASSIFYNAME */
    private String posclassifyname;

    /**  v_sys_employee.EMPTYPE */
    private String emptype;

    /**  v_sys_employee.WORKSTATUS */
    private String workstatus;

    /**  v_sys_employee.ADMINDUTYID */
    private String admindutyid;

    /**  v_sys_employee.ADMINDUTY */
    private String adminduty;

    /**  v_sys_employee.IDENTITYNO */
    private String identityno;

    /**  v_sys_employee.BIRTHDATE */
    private String birthdate;

    /**  v_sys_employee.AGE */
    private String age;

    /**  v_sys_employee.WORKDATE */
    private String workdate;

    /**  v_sys_employee.JOINBCSDATE */
    private String joinbcsdate;

    /**  v_sys_employee.JOINBCSTYPE */
    private String joinbcstype;

    /**  v_sys_employee.FINANCEWYBEFOREBCS */
    private String financewybeforebcs;

    /**  v_sys_employee.WORKYEAR */
    private String workyear;

    /**  v_sys_employee.BCSWORKYEAR */
    private String bcsworkyear;

    /**  v_sys_employee.FINANCEWORKYEAR */
    private String financeworkyear;

    /**  v_sys_employee.PROFTITLE */
    private String proftitle;

    /**  v_sys_employee.ONDUTYTIME */
    private String ondutytime;

    /**  v_sys_employee.FAMILYTEL */
    private String familytel;

    /**  v_sys_employee.MOBILE */
    private String mobile;

    /**  v_sys_employee.SCHOOL */
    private String school;

    /**  v_sys_employee.EDUDEGREE */
    private String edudegree;

    /**  v_sys_employee.ACADEGREE */
    private String acadegree;

    /**  v_sys_employee.EDUYEAR */
    private String eduyear;

    /**  v_sys_employee.PROFTYPE */
    private String proftype;

    /**  v_sys_employee.MAJOR */
    private String major;

    /**  v_sys_employee.EDUTYPE */
    private String edutype;

    /**  v_sys_employee.USEDNAME */
    private String usedname;

    /**  v_sys_employee.GENDER */
    private String gender;

    /**  v_sys_employee.RACE */
    private String race;

    /**  v_sys_employee.ARCHIVENO */
    private String archiveno;

    /**  v_sys_employee.POLITICAL */
    private String political;

    /**  v_sys_employee.FAMILYADDR */
    private String familyaddr;

    /**  v_sys_employee.MARRIAGE */
    private String marriage;

    /**  v_sys_employee.ORIGIN */
    private String origin;

    /**  v_sys_employee.ORIGINADDR */
    private String originaddr;

    /**  v_sys_employee.EMPPHOTO */
    private String empphoto;

    /**  v_sys_employee.EMAIL */
    private String email;

    /**  v_sys_employee.USERSN */
    private Double usersn;

    /**  v_sys_employee.PASSWORD */
    private String password;

    /**  v_sys_employee.is_assigned */
    private Integer isAssigned;

    /**  v_sys_employee.assign_employee_id */
    private String assignEmployeeId;

    /**  v_sys_employee.assign_employee_name */
    private String assignEmployeeName;

    /**  v_sys_employee.assign_start_time */
    private Date assignStartTime;

    /**  v_sys_employee.assign_end_time */
    private Date assignEndTime;

    /**  v_sys_employee.CORNET */
    private String cornet;

    /**  v_sys_employee.WORKTEL */
    private String worktel;

    /**  v_sys_employee.org_code */
    private String orgCode;

    /**  v_sys_employee.update_time */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     *  获取 v_sys_employee.EMPID
     */
    public String getEmpid() {
        return empid;
    }

    /**
     *  设置 v_sys_employee.EMPID
     */
    public void setEmpid(String empid) {
        this.empid = empid == null ? null : empid.trim();
    }

    /**
     *  获取 v_sys_employee.EMPNAME
     */
    public String getEmpname() {
        return empname;
    }

    /**
     *  设置 v_sys_employee.EMPNAME
     */
    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    /**
     *  获取 v_sys_employee.DISPLAYORDER
     */
    public String getDisplayorder() {
        return displayorder;
    }

    /**
     *  设置 v_sys_employee.DISPLAYORDER
     */
    public void setDisplayorder(String displayorder) {
        this.displayorder = displayorder == null ? null : displayorder.trim();
    }

    /**
     *  获取 v_sys_employee.ORGID
     */
    public String getOrgid() {
        return orgid;
    }

    /**
     *  设置 v_sys_employee.ORGID
     */
    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    /**
     *  获取 v_sys_employee.ORGNAME
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     *  设置 v_sys_employee.ORGNAME
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    /**
     *  获取 v_sys_employee.DEPTID
     */
    public String getDeptid() {
        return deptid;
    }

    /**
     *  设置 v_sys_employee.DEPTID
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    /**
     *  获取 v_sys_employee.DEPTNAME
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     *  设置 v_sys_employee.DEPTNAME
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    /**
     *  获取 v_sys_employee.UNITID
     */
    public String getUnitid() {
        return unitid;
    }

    /**
     *  设置 v_sys_employee.UNITID
     */
    public void setUnitid(String unitid) {
        this.unitid = unitid == null ? null : unitid.trim();
    }

    /**
     *  获取 v_sys_employee.UNITNAME
     */
    public String getUnitname() {
        return unitname;
    }

    /**
     *  设置 v_sys_employee.UNITNAME
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    /**
     *  获取 v_sys_employee.SALUNITID
     */
    public String getSalunitid() {
        return salunitid;
    }

    /**
     *  设置 v_sys_employee.SALUNITID
     */
    public void setSalunitid(String salunitid) {
        this.salunitid = salunitid == null ? null : salunitid.trim();
    }

    /**
     *  获取 v_sys_employee.SALUNITNAME
     */
    public String getSalunitname() {
        return salunitname;
    }

    /**
     *  设置 v_sys_employee.SALUNITNAME
     */
    public void setSalunitname(String salunitname) {
        this.salunitname = salunitname == null ? null : salunitname.trim();
    }

    /**
     *  获取 v_sys_employee.SBOOKS
     */
    public String getSbooks() {
        return sbooks;
    }

    /**
     *  设置 v_sys_employee.SBOOKS
     */
    public void setSbooks(String sbooks) {
        this.sbooks = sbooks == null ? null : sbooks.trim();
    }

    /**
     *  获取 v_sys_employee.ISSALARYPAY
     */
    public String getIssalarypay() {
        return issalarypay;
    }

    /**
     *  设置 v_sys_employee.ISSALARYPAY
     */
    public void setIssalarypay(String issalarypay) {
        this.issalarypay = issalarypay == null ? null : issalarypay.trim();
    }

    /**
     *  获取 v_sys_employee.POSSERIAL
     */
    public String getPosserial() {
        return posserial;
    }

    /**
     *  设置 v_sys_employee.POSSERIAL
     */
    public void setPosserial(String posserial) {
        this.posserial = posserial == null ? null : posserial.trim();
    }

    /**
     *  获取 v_sys_employee.POSSERIALLEVEL
     */
    public String getPosseriallevel() {
        return posseriallevel;
    }

    /**
     *  设置 v_sys_employee.POSSERIALLEVEL
     */
    public void setPosseriallevel(String posseriallevel) {
        this.posseriallevel = posseriallevel == null ? null : posseriallevel.trim();
    }

    /**
     *  获取 v_sys_employee.CLIENTMNGTYPE
     */
    public String getClientmngtype() {
        return clientmngtype;
    }

    /**
     *  设置 v_sys_employee.CLIENTMNGTYPE
     */
    public void setClientmngtype(String clientmngtype) {
        this.clientmngtype = clientmngtype == null ? null : clientmngtype.trim();
    }

    /**
     *  获取 v_sys_employee.POSID
     */
    public String getPosid() {
        return posid;
    }

    /**
     *  设置 v_sys_employee.POSID
     */
    public void setPosid(String posid) {
        this.posid = posid == null ? null : posid.trim();
    }

    /**
     *  获取 v_sys_employee.POSNAME
     */
    public String getPosname() {
        return posname;
    }

    /**
     *  设置 v_sys_employee.POSNAME
     */
    public void setPosname(String posname) {
        this.posname = posname == null ? null : posname.trim();
    }

    /**
     *  获取 v_sys_employee.POSCLASSIFYID
     */
    public String getPosclassifyid() {
        return posclassifyid;
    }

    /**
     *  设置 v_sys_employee.POSCLASSIFYID
     */
    public void setPosclassifyid(String posclassifyid) {
        this.posclassifyid = posclassifyid == null ? null : posclassifyid.trim();
    }

    /**
     *  获取 v_sys_employee.POSCLASSIFYNAME
     */
    public String getPosclassifyname() {
        return posclassifyname;
    }

    /**
     *  设置 v_sys_employee.POSCLASSIFYNAME
     */
    public void setPosclassifyname(String posclassifyname) {
        this.posclassifyname = posclassifyname == null ? null : posclassifyname.trim();
    }

    /**
     *  获取 v_sys_employee.EMPTYPE
     */
    public String getEmptype() {
        return emptype;
    }

    /**
     *  设置 v_sys_employee.EMPTYPE
     */
    public void setEmptype(String emptype) {
        this.emptype = emptype == null ? null : emptype.trim();
    }

    /**
     *  获取 v_sys_employee.WORKSTATUS
     */
    public String getWorkstatus() {
        return workstatus;
    }

    /**
     *  设置 v_sys_employee.WORKSTATUS
     */
    public void setWorkstatus(String workstatus) {
        this.workstatus = workstatus == null ? null : workstatus.trim();
    }

    /**
     *  获取 v_sys_employee.ADMINDUTYID
     */
    public String getAdmindutyid() {
        return admindutyid;
    }

    /**
     *  设置 v_sys_employee.ADMINDUTYID
     */
    public void setAdmindutyid(String admindutyid) {
        this.admindutyid = admindutyid == null ? null : admindutyid.trim();
    }

    /**
     *  获取 v_sys_employee.ADMINDUTY
     */
    public String getAdminduty() {
        return adminduty;
    }

    /**
     *  设置 v_sys_employee.ADMINDUTY
     */
    public void setAdminduty(String adminduty) {
        this.adminduty = adminduty == null ? null : adminduty.trim();
    }

    /**
     *  获取 v_sys_employee.IDENTITYNO
     */
    public String getIdentityno() {
        return identityno;
    }

    /**
     *  设置 v_sys_employee.IDENTITYNO
     */
    public void setIdentityno(String identityno) {
        this.identityno = identityno == null ? null : identityno.trim();
    }

    /**
     *  获取 v_sys_employee.BIRTHDATE
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     *  设置 v_sys_employee.BIRTHDATE
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate == null ? null : birthdate.trim();
    }

    /**
     *  获取 v_sys_employee.AGE
     */
    public String getAge() {
        return age;
    }

    /**
     *  设置 v_sys_employee.AGE
     */
    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    /**
     *  获取 v_sys_employee.WORKDATE
     */
    public String getWorkdate() {
        return workdate;
    }

    /**
     *  设置 v_sys_employee.WORKDATE
     */
    public void setWorkdate(String workdate) {
        this.workdate = workdate == null ? null : workdate.trim();
    }

    /**
     *  获取 v_sys_employee.JOINBCSDATE
     */
    public String getJoinbcsdate() {
        return joinbcsdate;
    }

    /**
     *  设置 v_sys_employee.JOINBCSDATE
     */
    public void setJoinbcsdate(String joinbcsdate) {
        this.joinbcsdate = joinbcsdate == null ? null : joinbcsdate.trim();
    }

    /**
     *  获取 v_sys_employee.JOINBCSTYPE
     */
    public String getJoinbcstype() {
        return joinbcstype;
    }

    /**
     *  设置 v_sys_employee.JOINBCSTYPE
     */
    public void setJoinbcstype(String joinbcstype) {
        this.joinbcstype = joinbcstype == null ? null : joinbcstype.trim();
    }

    /**
     *  获取 v_sys_employee.FINANCEWYBEFOREBCS
     */
    public String getFinancewybeforebcs() {
        return financewybeforebcs;
    }

    /**
     *  设置 v_sys_employee.FINANCEWYBEFOREBCS
     */
    public void setFinancewybeforebcs(String financewybeforebcs) {
        this.financewybeforebcs = financewybeforebcs == null ? null : financewybeforebcs.trim();
    }

    /**
     *  获取 v_sys_employee.WORKYEAR
     */
    public String getWorkyear() {
        return workyear;
    }

    /**
     *  设置 v_sys_employee.WORKYEAR
     */
    public void setWorkyear(String workyear) {
        this.workyear = workyear == null ? null : workyear.trim();
    }

    /**
     *  获取 v_sys_employee.BCSWORKYEAR
     */
    public String getBcsworkyear() {
        return bcsworkyear;
    }

    /**
     *  设置 v_sys_employee.BCSWORKYEAR
     */
    public void setBcsworkyear(String bcsworkyear) {
        this.bcsworkyear = bcsworkyear == null ? null : bcsworkyear.trim();
    }

    /**
     *  获取 v_sys_employee.FINANCEWORKYEAR
     */
    public String getFinanceworkyear() {
        return financeworkyear;
    }

    /**
     *  设置 v_sys_employee.FINANCEWORKYEAR
     */
    public void setFinanceworkyear(String financeworkyear) {
        this.financeworkyear = financeworkyear == null ? null : financeworkyear.trim();
    }

    /**
     *  获取 v_sys_employee.PROFTITLE
     */
    public String getProftitle() {
        return proftitle;
    }

    /**
     *  设置 v_sys_employee.PROFTITLE
     */
    public void setProftitle(String proftitle) {
        this.proftitle = proftitle == null ? null : proftitle.trim();
    }

    /**
     *  获取 v_sys_employee.ONDUTYTIME
     */
    public String getOndutytime() {
        return ondutytime;
    }

    /**
     *  设置 v_sys_employee.ONDUTYTIME
     */
    public void setOndutytime(String ondutytime) {
        this.ondutytime = ondutytime == null ? null : ondutytime.trim();
    }

    /**
     *  获取 v_sys_employee.FAMILYTEL
     */
    public String getFamilytel() {
        return familytel;
    }

    /**
     *  设置 v_sys_employee.FAMILYTEL
     */
    public void setFamilytel(String familytel) {
        this.familytel = familytel == null ? null : familytel.trim();
    }

    /**
     *  获取 v_sys_employee.MOBILE
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *  设置 v_sys_employee.MOBILE
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     *  获取 v_sys_employee.SCHOOL
     */
    public String getSchool() {
        return school;
    }

    /**
     *  设置 v_sys_employee.SCHOOL
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     *  获取 v_sys_employee.EDUDEGREE
     */
    public String getEdudegree() {
        return edudegree;
    }

    /**
     *  设置 v_sys_employee.EDUDEGREE
     */
    public void setEdudegree(String edudegree) {
        this.edudegree = edudegree == null ? null : edudegree.trim();
    }

    /**
     *  获取 v_sys_employee.ACADEGREE
     */
    public String getAcadegree() {
        return acadegree;
    }

    /**
     *  设置 v_sys_employee.ACADEGREE
     */
    public void setAcadegree(String acadegree) {
        this.acadegree = acadegree == null ? null : acadegree.trim();
    }

    /**
     *  获取 v_sys_employee.EDUYEAR
     */
    public String getEduyear() {
        return eduyear;
    }

    /**
     *  设置 v_sys_employee.EDUYEAR
     */
    public void setEduyear(String eduyear) {
        this.eduyear = eduyear == null ? null : eduyear.trim();
    }

    /**
     *  获取 v_sys_employee.PROFTYPE
     */
    public String getProftype() {
        return proftype;
    }

    /**
     *  设置 v_sys_employee.PROFTYPE
     */
    public void setProftype(String proftype) {
        this.proftype = proftype == null ? null : proftype.trim();
    }

    /**
     *  获取 v_sys_employee.MAJOR
     */
    public String getMajor() {
        return major;
    }

    /**
     *  设置 v_sys_employee.MAJOR
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     *  获取 v_sys_employee.EDUTYPE
     */
    public String getEdutype() {
        return edutype;
    }

    /**
     *  设置 v_sys_employee.EDUTYPE
     */
    public void setEdutype(String edutype) {
        this.edutype = edutype == null ? null : edutype.trim();
    }

    /**
     *  获取 v_sys_employee.USEDNAME
     */
    public String getUsedname() {
        return usedname;
    }

    /**
     *  设置 v_sys_employee.USEDNAME
     */
    public void setUsedname(String usedname) {
        this.usedname = usedname == null ? null : usedname.trim();
    }

    /**
     *  获取 v_sys_employee.GENDER
     */
    public String getGender() {
        return gender;
    }

    /**
     *  设置 v_sys_employee.GENDER
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     *  获取 v_sys_employee.RACE
     */
    public String getRace() {
        return race;
    }

    /**
     *  设置 v_sys_employee.RACE
     */
    public void setRace(String race) {
        this.race = race == null ? null : race.trim();
    }

    /**
     *  获取 v_sys_employee.ARCHIVENO
     */
    public String getArchiveno() {
        return archiveno;
    }

    /**
     *  设置 v_sys_employee.ARCHIVENO
     */
    public void setArchiveno(String archiveno) {
        this.archiveno = archiveno == null ? null : archiveno.trim();
    }

    /**
     *  获取 v_sys_employee.POLITICAL
     */
    public String getPolitical() {
        return political;
    }

    /**
     *  设置 v_sys_employee.POLITICAL
     */
    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    /**
     *  获取 v_sys_employee.FAMILYADDR
     */
    public String getFamilyaddr() {
        return familyaddr;
    }

    /**
     *  设置 v_sys_employee.FAMILYADDR
     */
    public void setFamilyaddr(String familyaddr) {
        this.familyaddr = familyaddr == null ? null : familyaddr.trim();
    }

    /**
     *  获取 v_sys_employee.MARRIAGE
     */
    public String getMarriage() {
        return marriage;
    }

    /**
     *  设置 v_sys_employee.MARRIAGE
     */
    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    /**
     *  获取 v_sys_employee.ORIGIN
     */
    public String getOrigin() {
        return origin;
    }

    /**
     *  设置 v_sys_employee.ORIGIN
     */
    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    /**
     *  获取 v_sys_employee.ORIGINADDR
     */
    public String getOriginaddr() {
        return originaddr;
    }

    /**
     *  设置 v_sys_employee.ORIGINADDR
     */
    public void setOriginaddr(String originaddr) {
        this.originaddr = originaddr == null ? null : originaddr.trim();
    }

    /**
     *  获取 v_sys_employee.EMPPHOTO
     */
    public String getEmpphoto() {
        return empphoto;
    }

    /**
     *  设置 v_sys_employee.EMPPHOTO
     */
    public void setEmpphoto(String empphoto) {
        this.empphoto = empphoto == null ? null : empphoto.trim();
    }

    /**
     *  获取 v_sys_employee.EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     *  设置 v_sys_employee.EMAIL
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     *  获取 v_sys_employee.USERSN
     */
    public Double getUsersn() {
        return usersn;
    }

    /**
     *  设置 v_sys_employee.USERSN
     */
    public void setUsersn(Double usersn) {
        this.usersn = usersn;
    }

    /**
     *  获取 v_sys_employee.PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     *  设置 v_sys_employee.PASSWORD
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     *  获取 v_sys_employee.is_assigned
     */
    public Integer getIsAssigned() {
        return isAssigned;
    }

    /**
     *  设置 v_sys_employee.is_assigned
     */
    public void setIsAssigned(Integer isAssigned) {
        this.isAssigned = isAssigned;
    }

    /**
     *  获取 v_sys_employee.assign_employee_id
     */
    public String getAssignEmployeeId() {
        return assignEmployeeId;
    }

    /**
     *  设置 v_sys_employee.assign_employee_id
     */
    public void setAssignEmployeeId(String assignEmployeeId) {
        this.assignEmployeeId = assignEmployeeId == null ? null : assignEmployeeId.trim();
    }

    /**
     *  获取 v_sys_employee.assign_employee_name
     */
    public String getAssignEmployeeName() {
        return assignEmployeeName;
    }

    /**
     *  设置 v_sys_employee.assign_employee_name
     */
    public void setAssignEmployeeName(String assignEmployeeName) {
        this.assignEmployeeName = assignEmployeeName == null ? null : assignEmployeeName.trim();
    }

    /**
     *  获取 v_sys_employee.assign_start_time
     */
    public Date getAssignStartTime() {
        return assignStartTime;
    }

    /**
     *  设置 v_sys_employee.assign_start_time
     */
    public void setAssignStartTime(Date assignStartTime) {
        this.assignStartTime = assignStartTime;
    }

    /**
     *  获取 v_sys_employee.assign_end_time
     */
    public Date getAssignEndTime() {
        return assignEndTime;
    }

    /**
     *  设置 v_sys_employee.assign_end_time
     */
    public void setAssignEndTime(Date assignEndTime) {
        this.assignEndTime = assignEndTime;
    }

    /**
     *  获取 v_sys_employee.CORNET
     */
    public String getCornet() {
        return cornet;
    }

    /**
     *  设置 v_sys_employee.CORNET
     */
    public void setCornet(String cornet) {
        this.cornet = cornet == null ? null : cornet.trim();
    }

    /**
     *  获取 v_sys_employee.WORKTEL
     */
    public String getWorktel() {
        return worktel;
    }

    /**
     *  设置 v_sys_employee.WORKTEL
     */
    public void setWorktel(String worktel) {
        this.worktel = worktel == null ? null : worktel.trim();
    }

    /**
     *  获取 v_sys_employee.org_code
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     *  设置 v_sys_employee.org_code
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     *  获取 v_sys_employee.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *  设置 v_sys_employee.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}