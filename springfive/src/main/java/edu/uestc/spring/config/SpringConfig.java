package edu.uestc.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"edu.uestc.spring" }) // 开启组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true) //开启aspectJ切面动态代理
public class SpringConfig {
}
