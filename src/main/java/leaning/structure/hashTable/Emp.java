package leaning.structure.hashTable;

/**
 * 员工
 */
public class Emp {
    public int id;
    public String name;
    public Emp next;  //next 默认为null

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
