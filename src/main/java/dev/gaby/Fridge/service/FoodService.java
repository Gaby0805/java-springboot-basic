package dev.gaby.Fridge.service;

import dev.gaby.Fridge.model.Food;
import dev.gaby.Fridge.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    //Constructor
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    //get
    public List<Food> getAll(){
        return foodRepository.findAll();
    }
    //Create and edit
    public Food save(Food food){
        return foodRepository.save(food);
    }
    //Delete
    public void Delete(Long id){
         foodRepository.deleteById(id);
    }

}
