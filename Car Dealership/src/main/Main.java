package main;

import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main{

    private Company c = new Company("Vericu SRL");
    private JButton loginButton, showAllCars, submitRequest, logOutClient, approveRequest, logOutAdmin;
    private JFrame loginFrame, clientFrame, adminFrame;
    private JTextField userName, role;
    private JTextArea clientConsole = new JTextArea(), adminConsole = new JTextArea();
    private Client client = new Client();
    private Dealer dealer = new Dealer();
    private DefaultListModel<String> carModel = new DefaultListModel<>(), submissionModel = new DefaultListModel<>();
    private JList<String> carView = new JList<>(carModel), submissionName = new JList<>(submissionModel);


    public Main(){
       populateDB();
       login();
    }

    private TreeSet<Car> loadStock(){
        TreeSet<Car> carList = new TreeSet<>();
        carList.add(new Car("Ford", "Mustang", "2022"));
        carList.add(new Car("Chevrolet", "Camaro", "2022"));
        carList.add(new Car("Dodge", "Challenger", "2022"));
        carList.add(new Car("Tesla", "Model S", "2022"));
        carList.add(new Car("BMW", "M3", "2022"));
        carList.add(new Car("Audi", "R8", "2022"));
        carList.add(new Car("Mercedes-Benz", "AMG GT", "2022"));
        carList.add(new Car("Porsche", "911", "2022"));
        carList.add(new Car("Jaguar", "F-Type", "2022"));
        carList.add(new Car("Lamborghini", "Aventador", "2022"));
        carList.add(new Car("McLaren", "720S", "2022"));
        carList.add(new Car("Ferrari", "812 Superfast", "2022"));
        carList.add(new Car("Aston Martin", "Vantage", "2022"));
        carList.add(new Car("Bentley", "Continental GT", "2022"));
        carList.add(new Car("Rolls-Royce", "Phantom", "2022"));
        carList.add(new Car("Honda", "Civic", "2022"));
        carList.add(new Car("Toyota", "Camry", "2022"));
        carList.add(new Car("Nissan", "Altima", "2022"));
        carList.add(new Car("Mazda", "3", "2022"));
        carList.add(new Car("Hyundai", "Sonata", "2022"));
        carList.add(new Car("Kia", "Optima", "2022"));
        carList.add(new Car("Subaru", "Impreza", "2022"));
        carList.add(new Car("Volkswagen", "Golf", "2022"));
        carList.add(new Car("Volvo", "S60", "2022"));
        carList.add(new Car("Audi", "A4", "2022"));
        carList.add(new Car("Mercedes-Benz", "C-Class", "2022"));
        carList.add(new Car("BMW", "3 Series", "2022"));
        carList.add(new Car("Jeep", "Wrangler", "2022"));
        carList.add(new Car("Ram", "1500", "2022"));
        carList.add(new Car("GMC", "Sierra", "2022"));
        carList.add(new Car("Chevrolet", "Silverado", "2022"));
        carList.add(new Car("Ford", "F-150", "2022"));
        carList.add(new Car("Toyota", "Tundra", "2022"));
        carList.add(new Car("Nissan", "Titan", "2022"));
        carList.add(new Car("Honda", "Ridgeline", "2022"));
        carList.add(new Car("Dodge", "Ram", "2022"));
        carList.add(new Car("Ford", "Ranger", "2022"));

        return carList;
    }

    private void login(){
        //Create login page
        loginFrame = new JFrame("Login");
        Panel p = new Panel();
        loginFrame.add(p);
        loginFrame.setContentPane(p);
        p.setLayout(null);
        loginFrame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 600);
        loginFrame.setVisible(true);

        loginButton = new JButton("Log In");
        p.add(loginButton);
        loginButton.setVisible(true);
        loginButton.setBounds(115, 300, 150, 50);

        userName = new JTextField();
        userName.setSize(50, 20);
        p.add(userName);
        userName.setVisible(true);
        userName.setBounds(20, 175, 120, 40);
        userName.setText("Username");
        userName.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if(userName.getText().isEmpty()) {
                    userName.setText("Username");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(userName.getText().equals("Username")) {
                    userName.setText("");
                }
            }
        });


        role = new JTextField();
        role.setSize(50, 20);
        p.add(role);
        role.setVisible(true);
        role.setBounds(240, 175, 120, 40);
        role.setText("Role");
        role.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if(role.getText().isEmpty()) {
                    role.setText("Role");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(role.getText().equals("Role")) {
                    role.setText("");
                }
            }
        });

        loginButton.addActionListener(e -> {
            for(Client c: c.getClients()){
                if(c.getName().equals(userName.getText()) && role.getText().toUpperCase(Locale.ROOT).equals(Roles.CLIENT.toString())){
                    client = c;
                    clientView();
                }
            }

            for(Dealer d: c.getDealers()){
                if(d.getName().equals(userName.getText()) && role.getText().toUpperCase(Locale.ROOT).equals(Roles.ADMIN.toString())){
                    dealer.setName(userName.getText());
                    adminView();
                }
            }
        });

    }

    private void clientView(){
        loginFrame.dispose();
        clientFrame = new JFrame("models.Company Stock");
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel();
        p.setLayout(null);
        clientFrame.setContentPane(p);
        clientFrame.setSize(400, 600);
        clientFrame.setVisible(true);



        for(Car car: c.getCarStock()){
            carModel.addElement(car.getBrand() + " " + car.getModel() + " " + car.getYearOfFabrication());
        }

        JScrollPane scrollPane = new JScrollPane(carView);
        scrollPane.setBounds(60, 10, 265, 200);
        p.add(scrollPane);

        p.add(clientConsole);
        JScrollPane areaScroll = new JScrollPane(clientConsole);
        p.add(areaScroll);
        areaScroll.setBounds(60, 250, 265, 70);
        areaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        carView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    if(client.getClientCars().contains(new Car(carView.getSelectedValue().split(" ")[0], carView.getSelectedValue().split(" ")[1], carView.getSelectedValue().split(" ")[2]))){
                        clientConsole.setText("models.Car already added");
                    }
                    else{
                        client.getClientCars().add(new Car(carView.getSelectedValue().split(" ")[0], carView.getSelectedValue().split(" ")[1], carView.getSelectedValue().split(" ")[2]));
                        clientConsole.setText(carView.getSelectedValue().split(" ")[0] + " " + carView.getSelectedValue().split(" ")[1] + " " + carView.getSelectedValue().split(" ")[2] + " has been added to your wish list");
                    }
                }
            }
        });


        showAllCars = new JButton("Show All Cars");
        p.add(showAllCars);
        showAllCars.setBounds(30, 360, 120, 40);

        showAllCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clientConsole.setText("");
                for(Car car : client.getClientCars()){
                    clientConsole.append(car.getBrand() + " " + car.getModel() + " " + car.getYearOfFabrication() + "\n");
                }
            }
        });

        submitRequest = new JButton("Submit");
        p.add(submitRequest);
        submitRequest.setBounds(240, 360, 100, 40);

        submitRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.setSubmissions(new HashMap<>());
                String sub = "";
                for(Car car: client.getClientCars()){
                    sub += car.getBrand() + " " + car.getModel() + " " + car.getYearOfFabrication() + "\n";
                    c.getSubmissions().put(client.getName(), sub);
                }
            }
        });

        logOutClient = new JButton("Log Out");
        p.add(logOutClient);
        logOutClient.setBounds(140, 490, 100, 40);

        logOutClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientFrame.dispose();
                login();
            }
        });

        if(client.isApproved()){
            clientConsole.setText("Your request has been approved\n");
            clientConsole.append("Discussion date is: " + client.getDate());
        }


    }

    private void adminView(){
        loginFrame.dispose();

        adminFrame = new JFrame("Submissions");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel();
        p.setLayout(null);
        adminFrame.setContentPane(p);
        adminFrame.setSize(400, 600);
        adminFrame.setVisible(true);

        p.add(adminConsole);

        JScrollPane areaScroll = new JScrollPane(adminConsole);
        p.add(areaScroll);
        areaScroll.setBounds(60, 250, 265, 70);
        areaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane scrollPane = new JScrollPane(submissionName);
        scrollPane.setBounds(60, 10, 265, 150);
        p.add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        for(String name: c.getSubmissions().keySet()){
            submissionModel.addElement(name);
        }

        submissionName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    adminConsole.setText("");
                    adminConsole.setText(c.getSubmissions().get(submissionName.getSelectedValue()));
                }
            }
        });

        approveRequest = new JButton("Approve Request");
        p.add(approveRequest);
        approveRequest.setBounds(85, 370, 200, 40);

        approveRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Client temp2: c.getClients()){
                    if(temp2.getName().equals(submissionName.getSelectedValue())){
                        temp2.setApproved(true);
                        temp2.setDate(new Date(2023, 1 + (int)(Math.random() * ((12 - 1) + 1)), 23));
                    }
                }



            }
        });

        logOutAdmin = new JButton("Log Out");
        p.add(logOutAdmin);
        logOutAdmin.setBounds(140, 490, 100, 40);

        logOutAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.dispose();
                login();
            }
        });




    }

    private void populateDB(){
        c.setCarStock(loadStock());
        c.getClients().add(new Client("Laur"));
        c.getDealers().add(new Dealer("Nour"));
    }

}
