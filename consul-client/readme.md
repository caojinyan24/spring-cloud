使用consul做服务注册
只需要在pom文件添加consul依赖
然后在配置文件添加consul的相关配置即可
其他和eureka的客户端注册一致



在本地通过命令`consul agent -dev`启动consul.
如果未安装consul的话,需要首先安装consul.
```
下载consul包：https://www.consul.io/downloads.html
解压:#unzip consul_1.0.2_linux_amd64.zip
添加到环境变量中:#cp -a consul  /usr/bin
启动:#consul
```

启动consul后,默认的consul端口号为8500,页面访问地址为:`http://localhost:8500/ui/`
>tips:配置文件总配置的consul的地址要和这里的保持一致
>tips:注解`@EnableDiscoveryClient`标示服务是否要被注册