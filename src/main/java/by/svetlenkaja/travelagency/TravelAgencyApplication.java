package by.svetlenkaja.travelagency;

import by.svetlenkaja.travelagency.configuration.ConfigurationClassifier;
import by.svetlenkaja.travelagency.model.entity.Classifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


@SpringBootApplication
public class TravelAgencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyApplication.class, args);

//        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClassifier.class);
//        ConfigurationClassifier collectionsBean = context.getBean(
//                ConfigurationClassifier.class);
//        collectionsBean.getTourTypes();
    }

}
