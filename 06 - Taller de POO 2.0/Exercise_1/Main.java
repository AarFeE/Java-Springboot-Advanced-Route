public class Main {
    public static void main(String[] args) {
        SpecificProduct a = new SpecificProduct("0", "Colgate Total White", 1.0, "higiene", "Colgate");
        SpecificProduct b = new SpecificProduct("1", "Margarita Pollo 250gr", 2.0, "comestibles", "Margarita");
        SpecificProduct c = new SpecificProduct("2", "Zenu Pollo 500gr", 3.0, "comestibles", "Zenu");
        SpecificProduct d = new SpecificProduct("3", "LGTV 55'' 4k", 4.0, "electronicos", "LG");

        Inventory inventory = new Inventory();

        inventory.addProduct(a);
        inventory.addProduct(b);
        inventory.addProduct(c);
        inventory.addProduct(d);
        
        inventory.deleteProductByName("Margarita Pollo 250gr");

        System.out.println(inventory.getProducts().toString());

        System.out.println(inventory.getProductsByCategory("comestibles").toString());
    }
}