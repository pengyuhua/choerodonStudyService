package io.choerodon.study.app.service;

import io.choerodon.study.infra.dto.UserDTO;

public interface UserService {
    UserDTO createOne(UserDTO userDTO);
}
