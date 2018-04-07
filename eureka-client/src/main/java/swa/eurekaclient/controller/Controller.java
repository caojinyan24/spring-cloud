package swa.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jinyan on 4/7/18 8:28 PM.
 */
@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    private DiscoveryClient client;//获得当前配置文件中配置的注册地址的所有服务

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public List<String> service() {
        List<String> services = client.getServices();
        logger.info("services:", services);
        return services;
    }
}
