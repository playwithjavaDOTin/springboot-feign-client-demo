package playwithjava.in.service;

import org.springframework.transaction.annotation.Transactional;
import playwithjava.in.bean.EmployeeResponse;

@Transactional
public interface EmpRemoteService {
public EmployeeResponse getRemoteEmployeeById(Long empId);

}
