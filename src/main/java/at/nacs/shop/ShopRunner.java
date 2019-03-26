package at.nacs.shop;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShopRunner {
    @Bean
    ApplicationRunner runner(List<Item>items, ItemRepository repository) {
        return args -> {
            System.out.println("---DELETE---");
            repository.deleteAll();

            System.out.println("---Save---");
            repository.saveAll(items);

            System.out.println("---FIND---");
            List<Item> all = repository.findAll();
            all.forEach(System.out::println);

        };
    }
}
