package DSProject;

public class Relation extends Edge
{
    String role , time;
    public Relation(Person from, Person to, String role, String time) {
        super(from.kode + to.kode, from, to);
        this.role = role;
        this.time = time;
    }
}
