package io.choerodon.study.infra.mapper;


import io.choerodon.study.infra.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends io.choerodon.mybatis.common.Mapper<UserDTO> {}
