package io.choerodon.study.api.controller.v1;


import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.study.app.service.OrganizationService;
import io.choerodon.study.app.service.UserService;
import io.choerodon.study.app.service.ProjectService;
import io.choerodon.study.infra.dto.OrganizationDTO;
import io.choerodon.study.infra.dto.UserDTO;
import io.choerodon.study.infra.feign.IamOrganizationFeign;
import io.choerodon.study.infra.feign.IamUserFeign;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/organizations")
public class OrganizationController {
    private Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    OrganizationService organizationService;
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Resource
    private IamOrganizationFeign iamOrganizationFeign;
    @Resource
    private IamUserFeign iamUserFeign;

    @ApiOperation(value = "根据organization_id查询organization信息(is_add_local决定是否将读取数据插入到本地数据库：0 不添加| 1 添加)")
    @GetMapping(value = "/{organization_id}/{is_add_local}")
    @Permission(type = ResourceType.SITE)
    public ResponseEntity<OrganizationDTO> listOrganization(
            @PathVariable("organization_id")String organization_id,
            @PathVariable("is_add_local")String is_add_local){
        logger.trace("传入参数:" + organization_id);
        OrganizationDTO result = iamOrganizationFeign.getOrganizationData(organization_id).getBody();
        logger.info(result.toString());
        if (is_add_local.equals("1")){
            boolean insertRe = organizationService.insertOrganization(result);
            boolean insertRePro = projectService.insertListProject(result.getProjects());
            logger.info("数据插入结果:用户：" + insertRe +"insertRePro:" + insertRePro);
        }else {
            logger.info("当前无需进行数据插入");
        }
        return iamOrganizationFeign.getOrganizationData(organization_id);
    }

    @ApiOperation(value = "根据organization_id,user_id查询user信息,is_add_local决定是否插入读取数据到本地数据库:0 不添加| 1 添加")
    @GetMapping(value = "/{organization_id}/users/{user_id}/{is_add_local}")
    @Permission(type = ResourceType.SITE)
    public ResponseEntity<UserDTO> listUser(@PathVariable("organization_id") String organization_id,
                                            @PathVariable("user_id") String user_id,
                                            @PathVariable("is_add_local")String is_add_local){
        logger.trace("传入参数:" + organization_id + "user_id:"+ user_id);
        UserDTO result = iamUserFeign.getUserData(organization_id,user_id).getBody();
        if (is_add_local.equals("1")){
            boolean insertRe = userService.insertUser(result);
            logger.info("数据插入结果:" + insertRe);
        }else {
            logger.info("当前无需进行数据插入");
        }

        return iamUserFeign.getUserData(organization_id, user_id);
    }


    @GetMapping(value = "/all")
    @ApiOperation("查询本地插入的所有组织信息")
    @Permission(type = ResourceType.SITE)
    public ResponseEntity listOrganizationAll(){
        List<OrganizationDTO> organizationDTOList = organizationService.listOrganization();

        ResponseEntity<List<OrganizationDTO>> organizationDTOResponseEntity =
                new ResponseEntity<>(organizationDTOList, HttpStatus.OK);

        return organizationDTOResponseEntity;
    }

}
