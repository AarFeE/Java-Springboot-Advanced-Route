
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (this.products.contains(this.getProductByName(product.getName()))) {
            System.out.println("El producto ya existe");
            return;
        }

        this.products.add(product);
    }

    public List<String> getProducts() {
        List<String> list = new ArrayList<>();
        for (Product product : this.products) {
            list.add(product.getId() + " " + product.getName() + " " + product.getPrice());
        }
        return list;
    }

    public List<String> getProductsByCategory(String category) {
        List<String> list = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                list.add(product.getId() + " " + product.getName() + " " + product.getPrice());
            }
        }
        return list;
    }

    public Product getProductByName (String name) {
        for (Product product : this.products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void deleteProductByName(String name) {
        Product toRemove = new Product();
        boolean flag = false;
        for (Product product : this.products) {
            if (product.getName().equals(name)) {
                toRemove = product;
                flag = true;
            }
        }

        if (flag) {
            this.products.remove(toRemove);
        }
    }
}
