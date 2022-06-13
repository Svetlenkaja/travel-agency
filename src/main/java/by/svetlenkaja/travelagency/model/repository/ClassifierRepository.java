package by.svetlenkaja.travelagency.model.repository;

import by.svetlenkaja.travelagency.model.entity.Classifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifierRepository extends JpaRepository<Classifier, Long> {
    List<Classifier> findByType(int type);
    Classifier findByTypeAndCode(int type, int code);
}
