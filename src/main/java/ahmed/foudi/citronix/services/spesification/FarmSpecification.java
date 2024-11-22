package ahmed.foudi.citronix.services.spesification;

import ahmed.foudi.citronix.entities.Farm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FarmSpecification {

    public static Specification<Farm> searchFarms(String name, Double superficie, LocalDate dateCreation) {
        return (Root<Farm> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }

            if (superficie != null) {
                predicates.add(cb.equal(root.get("superficie"), superficie));
            }

            if (dateCreation != null) {
                predicates.add(cb.equal(root.get("dateCreation"), dateCreation));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
