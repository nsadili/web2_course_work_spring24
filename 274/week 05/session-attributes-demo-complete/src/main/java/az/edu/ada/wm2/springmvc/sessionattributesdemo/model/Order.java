package az.edu.ada.wm2.springmvc.sessionattributesdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    String customerName;
    List<String> products;

    public void addProduct(String product) {
        if (CollectionUtils.isEmpty(products)) {
            products = new ArrayList<>();
        }
        products.add(product);
    }
}
