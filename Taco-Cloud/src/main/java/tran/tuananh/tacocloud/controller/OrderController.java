package tran.tuananh.tacocloud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tran.tuananh.tacocloud.entity.Order;
import tran.tuananh.tacocloud.entity.Taco;
import tran.tuananh.tacocloud.repository.OrderRepository;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {
    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/recent")
    public Iterable<Order> recentTacos() {
        return orderRepo.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order postTaco(@RequestBody Order order) {
        return orderRepo.save(order);
    }

}
