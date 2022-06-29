package by.svetlenkaja.travelagency.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "by.svetlenkaja.travelagency")
@EnableAspectJAutoProxy
public class AspectConfiguration {
}
