package DSProject;

public class Mobile extends Node
{
    String kode;
    String number , operator;
    public Mobile(String kode, String number, String operator) {
        super((number.charAt(0)=='0')?number = number.substring(1):number);
        this.kode = kode;
        this.number = number;
        this.operator = operator;
    }
}
