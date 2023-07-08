package playwithjava.in.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.client.EmployeeFeignClient;
import playwithjava.in.constant.EmployeeServiceConstants;
import playwithjava.in.service.EmpRemoteService;

@RestController
@RequestMapping(EmployeeServiceConstants.EMPLOYEE_REMOTE_CONTROLLER_ENDPOINT)
@Slf4j
public class RemoteServiceController {

    @Autowired
    EmpRemoteService service;

    @Autowired
    EmployeeFeignClient employeeFeignClient;

    @GetMapping(EmployeeServiceConstants.EMPLOYEE_GET_EMPLOYEE_ENDPOINT + "/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployeeData(@PathVariable Long employeeId) {
        EmployeeResponse data = service.getRemoteEmployeeById(employeeId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping(EmployeeServiceConstants.GET_EMPLOYEE_FEIGN_BY_ID + "/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long employeeId) {
        log.info("#######  calling employee service using feign ");
        ResponseEntity<EmployeeResponse> data=employeeFeignClient.getEmployeeById(employeeId);
        return new ResponseEntity<>(data.getBody(), HttpStatus.OK);
    }
}
