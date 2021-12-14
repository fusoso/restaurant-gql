package idv.edwin.restaurant.service;

import idv.edwin.restaurant.domain.Food;

import java.util.List;

public interface RestaurantService {

    List<Food> listFoods(int count, int offset);
}
