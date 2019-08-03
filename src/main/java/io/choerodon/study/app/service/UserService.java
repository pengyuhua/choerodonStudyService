package io.choerodon.study.app.service;

import io.choerodon.study.infra.dto.UserDTO;

import java.util.List;

public interface UserService {

    boolean insertUser(UserDTO userDTO);

    List<UserDTO> listUser();
}
