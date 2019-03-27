package at.nacs.shop;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends MongoRepository<Item, String> {
    Optional<Item> findByName(String name);

    List<Item> findByType(String type);

    List<Item> findByNameAndPrice(String name, Double price);

    List<Item> findByPriceLessThan(Double price);

    List<Item> findByOrderByPriceDesc();

    List<Item> findByPriceBetween(double priceOne, double priceTwo);
}
