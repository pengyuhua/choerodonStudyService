package io.choerodon.study.app.service.impl;

import io.choerodon.core.exception.CommonException;
import io.choerodon.study.app.service.UserService;
import io.choerodon.study.infra.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    private UserMapper userMapper;

//    public UserServiceImpl(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    @Override
    public UserDTO createOne(UserDTO userDTO) {
//        if (userMapper.insert(userDTO) != 1) {
//            throw new CommonException("error.user.insert");
//        }
        return userDTO;
    }
}
