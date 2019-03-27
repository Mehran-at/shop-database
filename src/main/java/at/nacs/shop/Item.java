package at.nacs.shop;

import lombok.Data;

@Data
public class Item {
    //POJO plain old java object
    private String id;
    private String name;
    private String type;
    private Double price;
}
