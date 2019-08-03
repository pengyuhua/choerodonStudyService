package io.choerodon.study.app.service.impl;

import com.github.pagehelper.PageHelper;
import io.choerodon.study.app.service.ProjectService;
import io.choerodon.study.infra.dto.ProjectDTO;
import io.choerodon.study.infra.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectMapper projectMapper;

    @Override
    public boolean insertListProject(List<ProjectDTO> projectDTOList) {
        return projectMapper.insertListProject(projectDTOList) >= 0 ? true: false;
    }

    @Override
    public List<ProjectDTO> listProject(String page, String pageSize) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(pageSize));
        return projectMapper.selectAll();
    }
}
