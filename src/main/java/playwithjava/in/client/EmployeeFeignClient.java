package playwithjava.in.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.constant.EmployeeServiceConstants;

@FeignClient(name = "employee/employee-service",url = "localhost:9003")
public interface EmployeeFeignClient {
    @GetMapping(EmployeeServiceConstants.EMPLOYEE_GET_REMOTE_EMPLOYEE_ENDPOINT+"/{sid}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long sid);
    }
