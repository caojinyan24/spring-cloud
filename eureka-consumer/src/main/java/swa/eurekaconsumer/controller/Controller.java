package swa.eurekaconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by jinyan on 4/7/18 10:58 PM.
 */
@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @Resource
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");//从"eureka-client"应用集群中选中一个服务实例
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/service";
        logger.info("url:{}", url);
        return restTemplate.getForObject(url, String.class);

    }

}
