/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tunbe
 */
public class CartObject implements Serializable {

    private Map<String, Integer> Items;

    public Map<String, Integer> getItems() {
        return Items;
    }

    public void addItemToCart(String name) {
        if (name == null) {
            return;
        }
        if (name.trim().isEmpty()) {
            return;
        }
        if (this.Items == null) {
            this.Items = new HashMap<>();
        }
        int quantity = 1;
        if (this.Items.containsKey(name)) {
            quantity = this.Items.get(name) + 1;
        }
        this.Items.put(name, quantity);
    }

    public void removeItemFromCart(String name) {
        if (this.Items == null) {
            return;
        }
        if (this.Items.containsKey(name)) {
            this.Items.remove(name);
            if (this.Items.isEmpty()) {
                this.Items = null;
            }
        }
    }

}
