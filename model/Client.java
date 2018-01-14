package model;

import java.io.Serializable;

public class Client implements Serializable {

    private static final long serialVersionUID = 123L;
    private transient long clientId;
    private String clientName;
    private String clientSurname;
    private int clientAge;

    public Client(long clientId, String clientName, String clientSurname, int clientAge) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientAge = clientAge;
    }

    public long getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    @Override
    public String toString() {
        return "id: " + clientId + ", " +
                "name: " + clientName + ", " +
                "surname: " + clientSurname + ", " +
                "age: " + clientAge;
    }

}
