package io.choerodon.study.infra.feign;


import io.choerodon.study.infra.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "iam-service")
public interface IamUserFeign {
    @GetMapping(value = "/v1/organizations/{organization_id}/users/{user_id}")
    ResponseEntity<UserDTO> getUserData(@PathVariable("organization_id") String organization_id,
                                        @PathVariable("user_id") String user_id);
}
