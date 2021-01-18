package DSProject;

public class Home extends Node
{
    String kode;
    String price , address;
    String postal;
    String metraj;
    public Home(String kode, String price , String postal , String metraj , String address) {
        super(postal);
        this.kode = kode;
        this.price = price;
        this.address = address;
        this.postal = postal;
        this.metraj = metraj;
    }
}
