package by.svetlenkaja.travelagency.configuration;

import by.svetlenkaja.travelagency.constant.*;
import by.svetlenkaja.travelagency.model.repository.ClassifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = ClassifierRepository.class)
@RequiredArgsConstructor
public class ClassifierConfiguration {
    final ClassifierRepository classifierRepository;

    @Bean
    public void enumsInitializer(){

        for(TourType tourType : TourType.values()){
            tourType.setClassifier(classifierRepository.findByTypeAndCode(ClassifierType.TOUR.getType(), tourType.getCode()));
        }
        for (FoodType foodType : FoodType.values()) {
            foodType.setClassifier(classifierRepository.findByTypeAndCode(ClassifierType.FOOD.getType(), foodType.getCode()));
        }
        for (StateType stateType : StateType.values()) {
            stateType.setClassifier(classifierRepository.findByTypeAndCode(ClassifierType.STATE.getType(), stateType.getCode()));
        }

        for (BookingStatusType statusType : BookingStatusType.values()) {
            statusType.setClassifier(classifierRepository.findByTypeAndCode(ClassifierType.BOOKING_STATUS.getType(), statusType.getCode()));
        }

    }
}
