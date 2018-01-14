package services.impl;

import DAO.ClientDao;
import model.Client;
import services.ClientService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ClientServiceDb implements ClientService{
    private ClientDao clientDao;
    private BufferedReader reader;

    public ClientServiceDb() throws IOException {
        this.clientDao = new ClientDao();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void addClient() throws IOException {
//        System.out.println("Enter ID:");
//        int id = readNumber();
        int id = 0;
        System.out.println("Enter name:");
        String name = reader.readLine();
        System.out.println("Enter surname:");
        String surname = reader.readLine();
        System.out.println("Enter age:");
        int age = readNumber();
        clientDao.addClient(new Client(id, name, surname, age));
    }

    @Override
    public void removeClient() throws IOException {
        System.out.println("Enter ID of client to remove:");
        int id = readNumber();
        clientDao.removeClient(id);
    }

    @Override
    public void modifyClient() throws IOException {
        System.out.println("Enter ID to change:");
        int id = readNumber();
        System.out.println("Enter name:");
        String name = reader.readLine();
        System.out.println("Enter surname:");
        String surname = reader.readLine();
        System.out.println("Enter age:");
        int age = readNumber();
        clientDao.updateClient(new Client(id, name, surname, age));
    }

    @Override
    public void findClient() throws IOException {
        Boolean flag = true;
        do {
            System.out.println("Select the parameter to search:\n 1) ID.\n 2) Name.\n 3) Surname.\n 4) Age.\n 0) Exit.\n");
            String s = reader.readLine();
            switch (s) {
                case "1":
                    System.out.println("Enter ID:");
                    int id = readNumber();
                    String idS = "" + id;
                    clientDao.findClient("1", idS);
                    break;
                case "2":
                    System.out.println("Enter name:");
                    String name = reader.readLine();
                    clientDao.findClient("2", name);
                    break;
                case "3":
                    System.out.println("Enter surname:");
                    String surname = reader.readLine();
                    clientDao.findClient("3", surname);
                    break;
                case "4":
                    System.out.println("Enter age:");
                    int age = readNumber();
                    String ageS = "" + age;
                    clientDao.findClient("4", ageS);
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input!\n");
            }
        }while (flag) ;
    }

    @Override
    public List<Client> showAllClients(){
        return clientDao.getAll();
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