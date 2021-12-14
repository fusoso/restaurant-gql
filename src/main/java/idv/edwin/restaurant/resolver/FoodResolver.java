package idv.edwin.restaurant.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import idv.edwin.restaurant.domain.Food;
import idv.edwin.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodResolver implements GraphQLQueryResolver {

    private final RestaurantService foodService;

    @Autowired
    public FoodResolver(RestaurantService foodService) {
        this.foodService = foodService;
    }

    public List<Food> listFoods(int count, int offset) {
        return foodService.listFoods(count, offset);
    }
}
