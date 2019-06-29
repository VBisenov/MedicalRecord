package ObjectModel;

import java.util.Objects;

public class Client {
    private int id;
    private String name, surname, father_name;
    private String address;
    private String phone_number;
    private String password;

    public Client(int id, String name, String surname, String father_name, String address, String phone_number, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.father_name = father_name;
        this.address = address;
        this.phone_number = phone_number;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", father_name='" + father_name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getId() == client.getId() &&
                getName().equals(client.getName()) &&
                getSurname().equals(client.getSurname()) &&
                getFather_name().equals(client.getFather_name()) &&
                getAddress().equals(client.getAddress()) &&
                getPhone_number().equals(client.getPhone_number()) &&
                getPassword().equals(client.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getFather_name(), getAddress(), getPhone_number(), getPassword());
    }
}
