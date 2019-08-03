package io.choerodon.study.api.controller.v1;


import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.study.infra.feign.IamOrganizationFeign;
import io.choerodon.study.infra.feign.IamUserFeign;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/v1/organizations")
public class OrganizationController {
    private Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @Resource
    private IamOrganizationFeign iamOrganizationFeign;
    @Resource
    private IamUserFeign iamUserFeign;

    @ApiOperation(value = "根据organization_id查询organization信息")
    @GetMapping(value = "/{organization_id}")
    @Permission(type = ResourceType.SITE)
    public ResponseEntity<String> listOrganization(
            @PathVariable("organization_id")String organization_id){
        logger.trace("传入参数:" + organization_id);
        return new ResponseEntity<>(iamOrganizationFeign.getOrganizationData(organization_id), HttpStatus.OK);
    }

    @ApiOperation(value = "根据organization_id,user_id查询user信息")
    @GetMapping(value = "/{organization_id}/users/{user_id}")
    @Permission(type = ResourceType.SITE)
    public ResponseEntity<String> listUser(@PathVariable("organization_id") String organization_id,
                           @PathVariable("user_id") String user_id){
        logger.trace("传入参数:" + organization_id + "user_id:"+ user_id);
        return new ResponseEntity<>(iamUserFeign.getUserData(organization_id, user_id), HttpStatus.OK);

    }
}
