package ru.gb.patterns.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.patterns.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    static Specification<Order> notDeleted() {
        return (User, cq, cb) -> cb.equal(User.get("deleted"), 0);
    }

    List<Order> findAll(Specification<Order> specification);
}
