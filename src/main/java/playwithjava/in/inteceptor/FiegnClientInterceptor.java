package playwithjava.in.inteceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FiegnClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("#################  Request intercepted ...");

        requestTemplate.header("JRF-ACK","TOKEN");


    }
}
