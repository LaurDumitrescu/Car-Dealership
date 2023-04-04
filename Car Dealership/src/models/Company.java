package models;

import models.Car;
import models.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Company {

    private String name;
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Dealer> dealers = new ArrayList<>();
    private HashMap<String, String> submissions = new HashMap<>();
    private TreeSet<Car> carStock = new TreeSet<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public TreeSet<Car> getCarStock() {
        return carStock;
    }

    public void setCarStock(TreeSet<Car> carStock) {
        this.carStock = carStock;
    }

    public ArrayList<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(ArrayList<Dealer> dealers) {
        this.dealers = dealers;
    }

    public HashMap<String, String> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(HashMap<String, String> submissions) {
        this.submissions = submissions;
    }
}
