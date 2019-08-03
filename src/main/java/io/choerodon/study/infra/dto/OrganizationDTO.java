package io.choerodon.study.infra.dto;

import io.choerodon.mybatis.entity.BaseDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Table(name = "study_organization")
public class OrganizationDTO  extends BaseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键/非必填")
    private Long id;

    @ApiModelProperty(value = "组织名/必填")
    @NotEmpty(message = "error.organization.name.empty")
    @Size(min = 1, max = 32, message = "error.organization.name.size")
    private String name;

    @ApiModelProperty(value = "组织编码/必填")
    @NotEmpty(message = "error.code.empty")
    @Size(min = 1, max = 15, message = "error.organization.code.size")
    private String code;

    private Long userId;

    private String address;

    @ApiModelProperty(value = "组织类别")
    private String category;

    @ApiModelProperty(value = "组织图标url")
    private String imageUrl;

    @Column(name = "is_enabled")
    @ApiModelProperty(value = "是否启用/非必填/默认：true")
    private Boolean enabled;

    @ApiModelProperty(value = "组织官网地址")
    private String homePage;

    @ApiModelProperty(value = "组织规模")
    private Integer scale;

    @ApiModelProperty(value = "组织所在行业")
    private String businessType;

    @ApiModelProperty(value = "邮箱后缀，唯一。注册时必输，数据库非必输")
    private String emailSuffix;

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    private List<ProjectDTO> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getEmailSuffix() {
        return emailSuffix;
    }

    public void setEmailSuffix(String emailSuffix) {
        this.emailSuffix = emailSuffix;
    }

    @Override
    public String toString() {
        return "OrganizationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", enabled=" + enabled +
                ", homePage='" + homePage + '\'' +
                ", scale=" + scale +
                ", businessType='" + businessType + '\'' +
                ", emailSuffix='" + emailSuffix + '\'' +
                ", projects=" + projects +
                '}';
    }
}

