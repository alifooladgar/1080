package DSProject;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner sc = null;
    static JFileChooser chooser = new JFileChooser("D:\\Alireza\\Tuturials\\Uni\\Data Structure\\Project\\SampleData (2)\\");
    static CityGraph graph = new CityGraph();
    public static void main(String[] args) {
        selectFolder();
        showMainMenu();
    }
    static void selectFolder()
    {
        chooser.setDragEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) {
            System.out.println("File not selected");
        }
    }
    static void showMainMenu()
    {
        JFrame frameMain = new JFrame();
        JButton people = new JButton("People");
        JButton accounts = new JButton("Accounts");
        JButton calls = new JButton("Calls");
        JButton cars = new JButton("Cars");
        JButton homes = new JButton("Homes");
        JButton ownerships = new JButton("Ownerships");
        JButton phones = new JButton("Phones");
        JButton relationships = new JButton("Relationships");
        JButton transactions = new JButton("Transactions");
        JPanel panel = new JPanel(new GridLayout(3 , 3));
        panel.add(people);
        panel.add(accounts);
        panel.add(calls);
        panel.add(cars);
        panel.add(homes);
        panel.add(ownerships);
        panel.add(phones);
        panel.add(relationships);
        panel.add(transactions);
        frameMain.add(panel);
        frameMain.setLocationRelativeTo(null);
        frameMain.setSize(400 , 200);
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        people.addActionListener(actionEvent -> showPeople());
        accounts.addActionListener(actionEvent -> showAccounts());
        calls.addActionListener(actionEvent -> showCalls());
        cars.addActionListener(actionEvent -> showCars());
        homes.addActionListener(actionEvent -> showHomes());
        ownerships.addActionListener(actionEvent -> showOwn());
        phones.addActionListener(actionEvent -> showPhones());
        relationships.addActionListener(actionEvent -> showRelations());
        transactions.addActionListener(actionEvent -> showTrans());
    }
    static void showPeople()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\people.csv");
        scanner(file, 6);
    }

    private static void scanner(File file, int i2) {
        try {
            sc = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String[]> values = new ArrayList<>();
        assert sc != null;
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            line = line.substring(1 , line.length()-1);
            String[] vals = line.split("\",\"");
            values.add(vals);
        }
        String[][] strings = new String[values.size()-1][i2];
        String[] raw = values.get(0);
        for (int i=1;i<values.size();i++)
            strings[i-1] = values.get(i);
        for (String[] i : strings)
        {
                switch (file.getName())
                {
                    case "people.csv": graph.add_person(new Person(i[0] , i[1] , i[2] , i[3] , i[4] , i[5]));break;
                    case "accounts.csv": graph.add_bankAccount(new BankAccount(i[0], i[1] , i[2] , i[3])); break;
                    case "phones.csv": graph.add_mobile(new Mobile(i[0]  , i[1] , i[2]));break;
                    case "cars.csv": graph.add_car(new Car(i[0] , i[1] , i[2] , i[3]));break;
                    case "homes.csv": graph.add_home(new Home(i[0] , i[1] , i[2] , i[3] , i[4]));break;
                    case "ownerships.csv": graph.add_own(i);break;
                    case "transactions.csv": graph.add_transaction(i); break;
                    case "calls.csv": graph.add_call(i);break;
                    case "relationships.csv": graph.add_relation(i);break;
                }
        }
        JFrame jFrame = new JFrame();
        JTable table = new JTable(strings, raw);
        JScrollPane scrollPane = new JScrollPane(table);
        jFrame.add(scrollPane);
        jFrame.setLocationRelativeTo(null);
        jFrame.setExtendedState( jFrame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        jFrame.setVisible(true);
        System.out.println(table.getRowCount() + " " + file.getName().substring(0 , file.getName().length()-4));
        jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    static void showAccounts()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\accounts.csv");
        scanner(file, 4);
    }
    static void showOwn()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\ownerships.csv");
        scanner(file, 5);
    }
    static void showPhones()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\phones.csv");
        scanner(file, 3);
    }
    static void showRelations()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\relationships.csv");
        scanner(file, 4);
    }
    static void showTrans()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\transactions.csv");
        scanner(file, 5);
    }
    static void showCalls()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\calls.csv");
        scanner(file, 5);
    }
    static void showCars()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\cars.csv");
        scanner(file, 4);
    }
    static void showHomes()
    {
        File file = new File(chooser.getSelectedFile().getAbsolutePath()+"\\homes.csv");
        scanner(file, 5);
    }
}
