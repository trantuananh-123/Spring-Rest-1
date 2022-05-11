package tran.tuananh.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import tran.tuananh.tacocloud.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
