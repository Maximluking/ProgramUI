package services.impl;

import model.Product;
import services.FileApp;
import services.ProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private FileApp fileApp;
    private BufferedReader reader;
    private List<Product> products;

    public ProductServiceImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.products = new ArrayList<>();
        this.fileApp = new FileApp();
    }

    @Override
    public void addProduct() throws IOException {
        System.out.println("Enter ID:");
        int id = readNumber();
        System.out.println("Enter name:");
        String name = reader.readLine();
        System.out.println("Enter number:");
        int number = readNumber();
        System.out.println("Enter value:");
        int value = readNumber();
        System.out.println("Enter weight:");
        int weight = readNumber();
        System.out.println("Enter volume:");
        int volume = readNumber();
        boolean flag = true;
        for (Product product: products) {
            if(product.getProductId() == id){
                product.setProductName(name);
                product.setProductNumber(number);
                product.setProductValue(value);
                product.setProductWeight(weight);
                product.setProductVolume(volume);
                flag = false;
            }
        }
        if(flag){
            products.add(new Product(id, name, number, value, weight, volume));
        }
    }

    @Override
    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Base empty!\n");
        } else {
            System.out.println("All products:\n");
            for (Product product : products) {
                System.out.println(product.productToString(product));
            }
        }
    }

    @Override
    public void removeProduct() throws IOException {
        if (products.isEmpty()) {
            System.out.println("Base empty!\n");
        } else {
            System.out.println("Enter ID to DELETE from BASE:\n");
            int id = readNumber();
            Boolean flag = true;
            try {
                for (Product product : products) {
                    if (product.getProductId() == id) {
                        products.remove(product);
                        System.out.println("Product deleted");
                        flag = false;
                    }
                }
                if (flag) System.out.println("there is no product with this ID\n");
            }catch (ConcurrentModificationException err){
            }
        }
    }

    @Override
    public void modifyProduct() throws IOException {
        if (products.isEmpty()) {
            System.out.println("Base empty!\n");
        } else {
            System.out.println("Enter ID for change INFO:\n");
            int id = readNumber();
            Boolean flag = true;
            for (Product product: products) {
                if (product.getProductId() == id) {
                    do {
                        System.out.println("Select the parameter to change:\n 1) Name.\n 2) Number.\n 3) Value.\n 4) Weight.\n 5) Volume\n 6) Exit.\n");
                        String s = reader.readLine();
                        switch (s) {
                            case "1":
                                System.out.println("Enter name:");
                                product.setProductName(reader.readLine());
                                break;
                            case "2":
                                System.out.println("Enter number:");
                                product.setProductNumber(readNumber());
                                break;
                            case "3":
                                System.out.println("Enter value:");
                                product.setProductValue(readNumber());
                                break;
                            case "4":
                                System.out.println("Enter weight:\n");
                                product.setProductWeight(readNumber());
                                break;
                            case "5":
                                System.out.println("Enter volume:\n");
                                product.setProductVolume(readNumber());
                                break;
                            case "6":
                                flag = false;
                                break;
                            default:
                                System.out.println("Invalid input!\n");
                        }
                    } while (flag);
                }
            }
            if (flag) System.out.printf("Product with this ID = %s is not found", id);
        }
    }

    @Override
    public void findProduct() throws IOException {
        if (products.isEmpty()) {
            System.out.println("Base empty!\n");
        } else {
            Boolean flag = true;
            Boolean containsParam = false;
            do {
                System.out.println("Select the parameter to search:\n 1) ID.\n 2) Name.\n 3) Exit.\n");
                String s = reader.readLine();
                switch (s) {
                    case "1":
                        System.out.println("Enter ID:");
                        int id = readNumber();
                        for (Product product : products) {
                            if (product.getProductId() == id) {
                                System.out.println("Coincidence:\n" + product.productToString(product));
                                containsParam = true;
                            }
                        }
                        break;
                    case "2":
                        System.out.println("Enter name:");
                        String name = reader.readLine();
                        for (Product product : products) {
                            if (name.equals(product.getProductName())) {
                                System.out.println("Coincidence:\n" + product.productToString(product));
                                containsParam = true;
                            }
                        }
                        break;
                    case "3":
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid input!\n");
                }
                if (!containsParam) {
                    System.out.println("Product not found!\n");
                    containsParam = true;
                }
            } while (flag);
        }
    }

    @Override
    public void saveProductBase() throws IOException {
        fileApp.saveProductBase(products);
    }

    @Override
    public void loadProductBase() throws IOException {
        fileApp.loadProductBase(products);
    }

    @Override
    public void clearProductBase() {
        System.out.println("Base clear successfully!\n");
        products.clear();
    }

    private int readNumber() throws IOException {
        int id;
        while (true) {
            try {
                id = Integer.valueOf(reader.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter the number!");
            }
        }
        return id;
    }
}
