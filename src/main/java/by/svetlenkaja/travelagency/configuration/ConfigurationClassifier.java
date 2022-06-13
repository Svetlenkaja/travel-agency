package by.svetlenkaja.travelagency.configuration;

import by.svetlenkaja.travelagency.model.entity.Classifier;
import by.svetlenkaja.travelagency.model.repository.ClassifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Configuration
@EnableJpaRepositories(basePackageClasses = ClassifierRepository.class)
@RequiredArgsConstructor
public class ConfigurationClassifier {
    final ClassifierRepository classifierRepository;

    @Bean
    public List<Classifier> getTourTypes(){
        return classifierRepository.findByType(3);
    }
}
