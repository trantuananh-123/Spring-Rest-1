package tran.tuananh.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import tran.tuananh.tacocloud.entity.Order;
import tran.tuananh.tacocloud.entity.Taco;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    private RestTemplate rest = new RestTemplate();
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            System.err.println(order);
            return "orderForm";
        }
        System.out.println(order);
        log.info("Order submitted: " + order);
        rest.postForObject("http://localhost:8080/order", order, Order.class);
        return "redirect:/";
    }
}