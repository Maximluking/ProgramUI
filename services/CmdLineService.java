package services;

import model.Client;
import model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineService {

    private final BufferedReader reader;
    private final ClientService clientService;
    private final ProductService productService;

    public CmdLineService(ClientService clientService, ProductService productService) {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.productService = productService;
        this.clientService = clientService;
    }

    private static void showMainMenu(){
        System.out.println("1. Clients");
        System.out.println("2. Products");
        System.out.println("0. Exit");
    }

    private static void showClientMenu(){
        System.out.println("1. Add client");
        System.out.println("2. Show all clients");
        System.out.println("3. Remove client");
        System.out.println("4. Modify client");
        System.out.println("5. Find client");
        System.out.println("0. Go back");
    }

    private static void showProductMenu(){
        System.out.println("1. Add product");
        System.out.println("2. Show all products");
        System.out.println("3. Remove product");
        System.out.println("4. Modify product");
        System.out.println("5. Find product");
        System.out.println("0. Go back");
    }

    public void mainMenu() throws IOException {
        boolean isWork = true;
        do {
            showMainMenu();
            String s = reader.readLine();
            switch (s){
                case "1":
                    clientMenu();
                    break;
                case "2":
                    productMenu();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Invalid input!\n");
            }
        }
        while (isWork);
    }

    private void clientMenu() throws IOException {
        boolean isWork = true;
        do {
            showClientMenu();
            String s = reader.readLine();
            switch (s) {
                case "1":
                    clientService.addClient();
                    break;
                case "2":
                    for (Client client : clientService.showAllClients()) {
                        System.out.println(client);
                    }
                    System.out.println();
                    break;
                case "3":
                    clientService.removeClient();
                    break;
                case "4":
                    clientService.modifyClient();
                    break;
                case "5":
                    clientService.findClient();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Invalid input!\n");
            }
        }
        while (isWork);
    }

    private void productMenu() throws IOException {
        boolean isWork = true;
        do {
            showProductMenu();
            String s = reader.readLine();
            switch (s) {
                case "1":
                    productService.addProduct();
                    break;
                case "2":
                    for (Product product : productService.showAllProducts()) {
                        System.out.println(product);
                    }
                    System.out.println();
                    break;
                case "3":
                    productService.removeProduct();
                    break;
                case "4":
                    productService.modifyProduct();
                    break;
                case "5":
                    productService.findProduct();
                    break;
                case "0":
                    isWork = false;
                    break;
                default:
                    System.out.println("Invalid input!\n");
            }
        }
        while (isWork);
    }
}
