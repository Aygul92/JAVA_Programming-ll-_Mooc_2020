
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elev
 */
public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void add(String product, int price) {
        Item tempItem = new Item(product, 1, price);
        if (items.contains(tempItem)) {
            tempItem = items.get(items.indexOf(tempItem));
            tempItem.increaseQuantity();
        } else {
            items.add(tempItem);
        }
    }

    public int price() {
        return items.stream().mapToInt(item -> item.price()).sum();
    }

    public void print() {
        items.stream().forEach(System.out::println);
    }
}