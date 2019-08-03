package io.choerodon.study.app.service;

import io.choerodon.study.infra.dto.ProjectDTO;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface ProjectService {

    @ApiOperation(value = "添加项目信息")
    boolean insertListProject(List<ProjectDTO> projectDTOList);

    @ApiOperation(value = "分页查询项目信息")
    List<ProjectDTO> listProject(String page, String pageSize);
}
