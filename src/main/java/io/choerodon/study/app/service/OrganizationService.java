package io.choerodon.study.app.service;

import io.choerodon.study.infra.dto.OrganizationDTO;
import io.swagger.annotations.ApiOperation;

import java.util.List;


public interface OrganizationService {

    @ApiOperation(value = "添加OrganizationDTO信息至数据库")
    boolean insertOrganization(OrganizationDTO organizationDTO);

    @ApiOperation(value = "使用common-mapper查询所有本地组织信息")
    List<OrganizationDTO> listOrganization();
}
