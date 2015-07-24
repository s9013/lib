package app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Jay
 * @time 2015年5月21日
 */
@Configuration
@ImportResource(value = {"classpath*:applicationContext*.xml"})
//@ImportResource(value = "classpath*:META-INF/spring/applicationContext*.xml")"classpath*:META-INF/logback.xml",
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = { "com" })
@EnableAspectJAutoProxy
public class ApplicationConfig {


}
