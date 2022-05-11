package tran.tuananh.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import tran.tuananh.tacocloud.entity.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
