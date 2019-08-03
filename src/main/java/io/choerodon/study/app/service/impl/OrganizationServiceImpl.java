package io.choerodon.study.app.service.impl;

import io.choerodon.study.app.service.OrganizationService;
import io.choerodon.study.infra.dto.OrganizationDTO;
import io.choerodon.study.infra.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public boolean insertOrganization(OrganizationDTO organizationDTO) {
        return organizationMapper.insertSelective(organizationDTO)>= 0 ? true: false;
    }

    @Override
    public List<OrganizationDTO> listOrganization() {
        return organizationMapper.selectAll();
    }
}
