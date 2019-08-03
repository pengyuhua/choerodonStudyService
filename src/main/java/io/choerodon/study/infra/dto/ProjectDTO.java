package io.choerodon.study.infra.dto;

import io.choerodon.mybatis.entity.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;


public class ProjectDTO extends BaseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键ID/非必填")
    private Long id;

    @ApiModelProperty(value = "项目名/必填")
    @NotEmpty(message = "error.project.name.empty")
    private String name;

    @ApiModelProperty(value = "项目编码/必填")
    @NotEmpty(message = "error.project.code.empty")
    private String code;

    @ApiParam(name = "organization_id", value = "组织id")
    @ApiModelProperty(value = "组织ID/非必填")
    private Long organizationId;

    @ApiModelProperty(value = "项目图标url")
    private String imageUrl;

    @ApiModelProperty(value = "是否启用/非必填")
    @Column(name = "is_enabled")
    private Boolean enabled;

    @ApiModelProperty(value = "项目类型code/非必填")
    private String type;

    @ApiModelProperty(value = "项目类型（遗留旧字段，一对一）:AGILE(敏捷项目),PROGRAM(普通项目组),ANALYTICAL(分析型项目群)")
    private String category;

    @ApiModelProperty(value = "项目类型")
    private List<Long> categoryIds;

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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", organizationId=" + organizationId +
                ", imageUrl='" + imageUrl + '\'' +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", categoryIds=" + categoryIds +
                '}';
    }
}
