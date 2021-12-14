package idv.edwin.restaurant.domain;

// temporary class for generating hard-coded food data
public class FoodBuilder {

    private int id;
    private String name;
    private String genre;
    private int price;
    private String cookingMethod;

    public Food build() {
        Food food = new Food();
        food.setId(id);
        food.setName(name);
        food.setGenre(genre);
        food.setPrice(price);
        food.setCookingMethod(cookingMethod);
        return food;
    }

    public FoodBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public FoodBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FoodBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public FoodBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public FoodBuilder setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
        return this;
    }
}
