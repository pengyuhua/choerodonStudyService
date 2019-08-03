package io.choerodon.study.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.study.app.service.ProjectService;
import io.choerodon.study.infra.dto.ProjectDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @ApiOperation(value = "分页查询本地数据插入的项目信息")
    @PostMapping(value = "/all")
    @Permission(type = ResourceType.SITE)
    public ResponseEntity listProjectAll(@RequestParam(value = "page", defaultValue = "1")String page,
                                      @RequestParam(value = "page_size", defaultValue = "10")String page_size){
        List<ProjectDTO> projectDTOList = projectService.listProject(page, page_size);
        ResponseEntity<List<ProjectDTO>> responseEntity = new ResponseEntity<>(projectDTOList, HttpStatus.OK);

        return responseEntity;
    }
}
