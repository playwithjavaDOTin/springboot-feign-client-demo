package playwithjava.in.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.service.EmpRemoteService;

import java.util.Arrays;

@Service
@Slf4j
public class EmpRemoteServiceImpl implements EmpRemoteService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public EmployeeResponse getRemoteEmployeeById(Long empId) {

        String remoteUrl="http://localhost:9003/employee/emp/getEmployee/"+empId;
        String remoteEndPoint="/emp/getEmployee/"+empId;
        String remoteServerBaseUrl="http://localhost:9003";

       return getEmployeeUsingRestTemplate(remoteUrl,remoteEndPoint,remoteServerBaseUrl);
    }


    private EmployeeResponse getEmployeeUsingRestTemplate(String url,String remoteEndPoint,String remoteServerBaseUrl){
        log.info("###########  calling getEmployeeData ::");
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        final HttpEntity<?> body = new HttpEntity<>(headers);
        ResponseEntity<EmployeeResponse> data= restTemplate.exchange(url, HttpMethod.GET, body,EmployeeResponse.class);
        log.info("####### resp data ::  "+data);
        return data.getBody();
    }
}
