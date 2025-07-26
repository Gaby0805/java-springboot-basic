package dev.gaby.Fridge.controller;

import dev.gaby.Fridge.model.Food;
import dev.gaby.Fridge.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService ;


    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    @GetMapping
    public List<Food> getall(){
        return foodService.getAll();
    }
    @PostMapping
    public  Food saveFood(@RequestBody Food food){
        return foodService.save(food);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         foodService.Delete(id);
    }
    @PutMapping("/{id}")
    public Food editFood(@PathVariable Long id, @RequestBody Food food) {
        food.setId(id);
        return foodService.save(food);

    }
}

