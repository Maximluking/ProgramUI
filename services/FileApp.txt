package services;

import model.Client;
import model.Product;
import java.io.*;
import java.util.List;

public class FileApp {
    private BufferedWriter bw;
    private BufferedReader br;

    public void saveClientBase(List<Client> arrayList) throws IOException {
        if (arrayList.isEmpty()) {
            System.out.println("Base empty!");
        } else {
            File tempFile = new File("ClientBase.txt");
            bw = new BufferedWriter(new FileWriter(tempFile));
            for (Client client : arrayList) {
                bw.write(baseConvertToFile(client));
            }
            bw.close();
            System.out.printf("BASE is saved successfully to file: %s\n", tempFile.getAbsolutePath());
        }
    }

    public void saveProductBase(List<Product> arrayList) throws IOException {
        if (arrayList.isEmpty()) {
            System.out.println("Base empty!");
        } else {
            File tempFile = new File("ProductBase.txt");
            bw = new BufferedWriter(new FileWriter(tempFile));
            for (Product product:arrayList) {
                bw.write(baseConvertToFile(product));
            }
            bw.close();
            System.out.printf("BASE is saved successfully to file: %s\n", tempFile.getAbsolutePath());
        }
    }

    public void loadClientBase(List<Client> arrayList) throws IOException {
        File tempFile = new File("ClientBase.txt");
        br = new BufferedReader(new FileReader(tempFile));
        String line;
        while ((line = br.readLine())!=null){
            int id = Integer.parseInt(line);
            String name = br.readLine();
            String surname = br.readLine();
            int age = Integer.parseInt(br.readLine());
            arrayList.add(new Client(id, name, surname, age));
        }
        br.close();
        System.out.println("File is load successfully!\n");
    }

    public void loadProductBase(List<Product> arrayList) throws IOException {
        File tempFile = new File("ProductBase.txt");
        br = new BufferedReader(new FileReader(tempFile));
        String line;
        while ((line = br.readLine())!=null){
            int id = Integer.parseInt(line);
            String name = br.readLine();
            int number  = Integer.parseInt(br.readLine());
            int value = Integer.parseInt(br.readLine());
            int weight = Integer.parseInt(br.readLine());
            int volume = Integer.parseInt(br.readLine());
            arrayList.add(new Product(id, name, number, value, weight, volume));
        }
        br.close();
        System.out.println("File is load successfully!\n");
    }

    private String baseConvertToFile(Client client){
        return client.getClientId() + "\r\n"
                + client.getClientName()+ "\r\n"
                + client.getClientSurname() + "\r\n"
                + client.getClientAge() + "\r\n";
    }

    private String baseConvertToFile(Product product) {
        return product.getProductId() + "\r\n"
                + product.getProductName() + "\r\n"
                + product.getProductNumber() + "\r\n"
                + product.getProductValue() + "\r\n"
                + product.getProductWeight() + "\r\n"
                + product.getProductVolume() + "\r\n";
    }
}
