package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class lombokTest {
    private int price;
    private String name;

    public static void main(String[] args) {
        lombokTest item = new lombokTest();
        item.setName("itemA");
        item.setPrice(10000);

        System.out.println("item = " + item);
    }
}
