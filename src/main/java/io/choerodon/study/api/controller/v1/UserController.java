package io.choerodon.study.api.controller.v1;


import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.study.app.service.UserService;
import io.choerodon.study.infra.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    @ApiOperation("查询本地插入的所有用户信息")
    @Permission(type = ResourceType.SITE)
    public ResponseEntity listUserAll(){
        List<UserDTO> userDTOList = userService.listUser();
//
        ResponseEntity<List<UserDTO>> organizationDTOResponseEntity =
                new ResponseEntity<>(userDTOList, HttpStatus.OK);

        return organizationDTOResponseEntity;
    }
}
