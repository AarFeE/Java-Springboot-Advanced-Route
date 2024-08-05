public class SpecificProduct extends Product {
    private String category;
    private String brand;

    public SpecificProduct(String id, String name, Double price, String category, String brand) {
        super(id, name, price);
        this.category = category;
        this.brand = brand;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
