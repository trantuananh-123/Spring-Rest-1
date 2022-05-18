package tran.tuananh.tacocloud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tran.tuananh.tacocloud.entity.Ingredient;
import tran.tuananh.tacocloud.repository.IngredientRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/ingredients", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController {
    private IngredientRepository ingredientRepo;

    public IngredientController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient ingredientById(@PathVariable("id") String id) {
        Optional<Ingredient> optIngredient = ingredientRepo.findById(id);
        if (optIngredient.isPresent()) {
            return optIngredient.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    private Ingredient postIngredient(@RequestBody Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }
}
