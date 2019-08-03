package io.choerodon.study.infra.mapper;

import io.choerodon.mybatis.common.Mapper;
import io.choerodon.study.infra.dto.ProjectDTO;
import io.choerodon.study.infra.dto.UserDTO;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ProjectMapper extends Mapper<ProjectDTO> {

    Integer insertListProject(List<ProjectDTO> projectDTOList);
}
