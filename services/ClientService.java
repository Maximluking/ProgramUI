package services;

import model.Client;
import java.io.IOException;
import java.util.List;

public interface ClientService {

    void addClient() throws IOException;

    void removeClient() throws IOException;

    void modifyClient() throws IOException;

    void findClient() throws IOException;

    List<Client> showAllClients();

}
