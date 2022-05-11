package tran.tuananh.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import tran.tuananh.tacocloud.entity.Ingredient;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
