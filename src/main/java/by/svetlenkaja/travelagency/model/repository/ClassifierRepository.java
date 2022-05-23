package by.svetlenkaja.travelagency.model.repository;

import by.svetlenkaja.travelagency.model.entity.Classifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifierRepository extends CrudRepository<Classifier, Long> {
    List<Classifier> findByType(int type);
}
