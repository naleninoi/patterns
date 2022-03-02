package ru.gb.patterns.service.implementation;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.patterns.model.Order;
import ru.gb.patterns.repository.OrderRepository;
import ru.gb.patterns.service.OrderService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static ru.gb.patterns.model.Customer.CUSTOMER_ANY;
import static ru.gb.patterns.model.Warehouse.WAREHOUSE_ANY;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll(Date dateFrom, Date dateTo, Long warehouseId, Long customerId) {
        Specification<Order> specDateFrom = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> orderRoot, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (dateFrom != null) {
                    return criteriaBuilder.greaterThanOrEqualTo( orderRoot.get("created"), dateFrom);
                }
                return criteriaBuilder.and();
            }
        };

        Specification<Order> specDateTo = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> orderRoot, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (dateTo != null) {
                    Date nextDay = new Date( dateTo.getTime() + (1000 * 60 * 60 * 24) );
                    return criteriaBuilder.lessThan( orderRoot.get("created"), nextDay);
                }
                return criteriaBuilder.and();
            }
        };

        Specification<Order> specWarehouseId = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> orderRoot, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (!warehouseId.equals(WAREHOUSE_ANY) ) {
                    return criteriaBuilder.equal( orderRoot.get("warehouse"), warehouseId);
                }
                return criteriaBuilder.and();
            }
        };

        Specification<Order> specCustomerId = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> orderRoot, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (!customerId.equals(CUSTOMER_ANY)) {
                    return criteriaBuilder.equal( orderRoot.get("customer"), customerId);
                }
                return criteriaBuilder.and();
            }
        };
        return orderRepository.findAll(specDateFrom.and(
                specDateTo.and(
                        specWarehouseId.and(
                                specCustomerId.and(
                                        OrderRepository.notDeleted())))));
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        order.setDeleted(true);
        orderRepository.save(order);
    }

}
