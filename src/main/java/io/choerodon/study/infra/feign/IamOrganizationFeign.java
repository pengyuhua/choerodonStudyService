package io.choerodon.study.infra.feign;


import io.choerodon.study.infra.dto.OrganizationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "iam-service")
public interface IamOrganizationFeign {
    @GetMapping(value = "/v1/organizations/{organization_id}")
    ResponseEntity<OrganizationDTO> getOrganizationData(@PathVariable("organization_id")String organization_id);
}
