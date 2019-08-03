package io.choerodon.study.app.service.impl;

import io.choerodon.core.exception.CommonException;
import io.choerodon.study.app.service.UserService;
import io.choerodon.study.infra.dto.UserDTO;
import io.choerodon.study.infra.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public boolean insertUser(UserDTO userDTO) {
        return userMapper.insertSelective(userDTO) >= 0 ? true: false;
    }

    @Override
    public List<UserDTO> listUser() {
        return userMapper.selectAll();
    }
}
