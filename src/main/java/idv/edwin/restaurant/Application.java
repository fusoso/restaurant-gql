package idv.edwin.restaurant;

import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import idv.edwin.restaurant.resolver.FoodResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private final FoodResolver foodResolver;

    @Autowired
    public Application(FoodResolver foodResolver) {
        this.foodResolver = foodResolver;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    GraphQLSchema schema() {
        return SchemaParser.newParser()
            .file("schema/restaurant.graphqls")
            .resolvers(foodResolver)
            .build()
            .makeExecutableSchema();
    }
}
