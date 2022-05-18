package tran.tuananh.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import tran.tuananh.tacocloud.entity.Ingredient;
import tran.tuananh.tacocloud.entity.Order;

@Slf4j
@Controller
@RequestMapping("/ingredient")
public class IngredientController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "addIngredient";
    }

    @PostMapping
    public String processAddIngredient(Ingredient ingredient) {
        System.out.println(ingredient);
        rest.postForObject("http://localhost:8080/ingredients", ingredient, Ingredient.class);
        return "redirect:/";
    }
}
