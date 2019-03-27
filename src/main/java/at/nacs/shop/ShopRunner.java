package at.nacs.shop;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class ShopRunner {
    @Bean
    ApplicationRunner runner(List<Item>items, ItemRepository repository) {
        return args -> {
            System.out.println("------------------------------------------DELETE---");
            repository.deleteAll();

            System.out.println("------------------------------------------Save---");
            repository.saveAll(items);

            System.out.println("------------------------------------------FIND---");
            List<Item> all = repository.findAll();
            all.forEach(System.out::println);

            System.out.println("------------------------------------------FIND ONE---");
            Optional<Item> keyboard = repository.findByName("keyboard");
            keyboard.ifPresent(System.out::println);

            System.out.println("------------------------------------------FIND TYPE---");
            List<Item> electronics = repository.findByType("electronics");
            electronics.forEach(System.out::println);

            System.out.println("------------------------------------------FIND BY NAME AND PRICE---");
            List<Item> sofas = repository.findByNameAndPrice("sofa", 45.95);
            sofas.forEach(System.out::println);

            System.out.println("------------------------------------------FIND BY PRICE LESS THAN---");
            List<Item> cheapStuff = repository.findByPriceLessThan(50.00);
            cheapStuff.forEach(System.out::println);

            System.out.println("------------------------------------------FIND ORDERED---");
            List<Item> ordered = repository.findByOrderByPriceDesc();
            ordered.forEach(System.out::println);

            System.out.println("------------------------------------------FIND BY PRICE BETWEEN---");
            List<Item> between = repository.findByPriceBetween(50.00, 80.00);
            between.forEach(System.out::println);
        };

    }
}
