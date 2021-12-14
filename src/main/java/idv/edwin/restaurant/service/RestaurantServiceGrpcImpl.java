package idv.edwin.restaurant.service;

import idv.edwin.restaurant.FoodRequest;
import idv.edwin.restaurant.FoodResponse;
import idv.edwin.restaurant.RestaurantServiceGrpc;
import idv.edwin.restaurant.domain.Food;
import idv.edwin.restaurant.domain.FoodBuilder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceGrpcImpl implements RestaurantService {

    public List<Food> listFoods(int count, int offset) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5000)
            .usePlaintext()
            .build();

        RestaurantServiceGrpc.RestaurantServiceBlockingStub stub
            = RestaurantServiceGrpc.newBlockingStub(channel);

        FoodResponse response = stub.listFoods(FoodRequest.newBuilder()
                                                   .setCount(count)
                                                   .setOffset(offset)
                                                   .build());

        channel.shutdown();

        return response.getFoodsList().stream()
            .map(food -> new FoodBuilder()
                .setId(food.getId())
                .setName(food.getName())
                .setPrice(food.getPrice())
                .setGenre(food.getGenre())
                .setCookingMethod(food.getCookingMethod())
                .build())
            .collect(Collectors.toList());
    }
}
