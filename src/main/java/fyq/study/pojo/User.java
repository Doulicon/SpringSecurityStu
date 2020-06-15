package fyq.study.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String userName;

    private String realName;

    private String password;

    private Integer roleId;

    private Integer groupId;

    private String schoolName;

    private Integer classroom;

    private String provinceName;

    private String groupName;

    private Integer writingType;

    private String cityName;

    private String teacherName;

    private Integer delFlag;

    private Date updateTime;

    @ApiModelProperty(value = "所在活动（外键，指向活动表）")
    private Integer activity;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getClassroom() {
        return classroom;
    }

    public void setClassroom(Integer classroom) {
        this.classroom = classroom;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getWritingType() {
        return writingType;
    }

    public void setWritingType(Integer writingType) {
        this.writingType = writingType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", realName=").append(realName);
        sb.append(", password=").append(password);
        sb.append(", roleId=").append(roleId);
        sb.append(", groupId=").append(groupId);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", classroom=").append(classroom);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", groupName=").append(groupName);
        sb.append(", writingType=").append(writingType);
        sb.append(", cityName=").append(cityName);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", activity=").append(activity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}