package javaapplication1;

import javax.swing.*;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDragEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) {
            System.out.println("File not selected");
        }
//        return chooser.getSelectedFile();
    }
}
class Node {
    String key;
    HashMap<String, Node> connected = new HashMap<>();
    HashMap<String, Edge> edges = new HashMap<>();
    public Node(String key) {
        this.key = key;
    }
    void connect(Node to, Edge edge)
    {
        connected.put(to.key , to);
        edges.put(edge.key , edge);
    }
}
class Edge {
    String key;
    Node from, to;
    public Edge(String key, Node from, Node to) {
        this.key = key;
        this.from = from;
        this.to = to;
    }
}
class Person extends Node {
    String firstname , lastname;
    String kode;
    String birthplace , job , birthday;
    public Person(String firstname, String lastname, String kode, String birthday, String birthplace, String job) {
        super(kode);
        this.firstname = firstname;
        this.lastname = lastname;
        this.kode = kode;
        this.birthplace = birthplace;
        this.job = job;
        this.birthday = birthday;
    }
}
class BankAccount extends Node {
    long kode;
    String bankName , shaba;
    String accountNumber;
    public BankAccount(long kode, String bankName, String shaba, String accountNumber) {
        super(accountNumber);
        this.kode = kode;
        this.bankName = bankName;
        this.shaba = shaba;
        this.accountNumber = accountNumber;
    }
}
class Home extends Node {
    long kode;
    String price , address;
    String postal;
    int metraj;
    public Home(long kode, String price , String postal , int metraj , String address) {
        super(postal);
        this.kode = kode;
        this.price = price;
        this.address = address;
        this.postal = postal;
        this.metraj = metraj;
    }
}
class Car extends Node {
    String pelak , kode;
    String Model , color;

    public Car(String pelak, String kode, String model, String color) {
        super(pelak);
        this.pelak = pelak;
        this.kode = kode;
        Model = model;
        this.color = color;
    }
}
class Mobile extends Node {
    long kode;
    String number , operator;
    public Mobile(long kode, String number, String operator) {
        super((number.charAt(0)=='0')?number = number.substring(1):number);
        this.kode = kode;
        this.number = number;
        this.operator = operator;
    }
}
class Own extends Edge {
    String shomare;
    String time, price;

    public Own(Node from, Node to, String shomare, String time, String price) {
        super(shomare, from, to);
        this.shomare = shomare;
        this.time = time;
        this.price = price;
    }
}
class Transaction extends Edge {
    String time, price;
    String shomare;
    public Transaction(Node from, Node to, String shomare , String time , String price) {
        super(shomare, from, to);
        this.time = time;
        this.price = price;
        this.shomare = shomare;
    }
}
class Call extends Edge {
    String shomare;
    String time;
    int duration;
    public Call(Node from, Node to, String shomare, String time, int duration) {
        super(shomare, from, to);
        this.shomare = shomare;
        this.time = time;
        this.duration = duration;
    }
}
class Relation extends Edge {
    String role , time;
    public Relation(Node from, Node to, String role, String time) {
        super(from.key + to.key, from, to);
        this.role = role;
        this.time = time;
    }
}
class CityGraph {
   HashMap<String , Node> nodes = new HashMap<>();
   HashMap<String , Edge> edges = new HashMap<>();
   HashMap<String , Person> persons = new HashMap<>();
   HashMap<String , BankAccount>  bankAccounts= new HashMap<>();
   HashMap<String , Call> calls = new HashMap<>();
   HashMap<String , Car> cars = new HashMap<>();
   HashMap<String , Home> homes = new HashMap<>();
   HashMap<String , Own> owns =new HashMap<>();
   HashMap<String , Mobile> mobiles = new HashMap<>();
   HashMap<String , Relation> relations =new HashMap<>();
   HashMap<String , Transaction> transactions =new HashMap<>();
   //-------------add nodes-------------------
   void add_nodes(Node n){
       nodes.put(n.key, n);
   }
   void add_person(Person p){
       persons.put(p.key, p);
       this.add_nodes(p);
   }
   void add_bankAccount(BankAccount ba){
       bankAccounts.put(ba.key, ba);
       this.add_nodes(ba);
   }
   void add_mobile(Mobile m){
       mobiles.put(m.key, m);
       this.add_nodes(m);
   }
   void add_car(Car c){
       cars.put(c.key, c);
       this.add_nodes(c);
   }
   void add_home(Home h){
       homes.put(h.key, h);
       this.add_nodes(h);
   }
   //-----------add edges-----------------
   void add_edge(Edge e){
       edges.put(e.key, e);
   }
   void add_call(Call c){
       calls.put(c.key, c);
       this.add_edge(c);
   }
   void add_own(Own o){
       owns.put(o.key, o);
       this.add_edge(o);
   }
   void add_relation(Relation r){
       relations.put(r.key, r);
       this.add_edge(r);
   }
   void add_transaction(Transaction t){
       transactions.put(t.key, t);
       this.add_edge(t);
   }
}
