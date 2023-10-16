import java.util.TreeSet;

public class Brand implements Comparable<Brand> {
    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    static TreeSet<Brand> brandTreeSet = new TreeSet<>();

    static {
        brandTreeSet.add(new Brand(1,"Samsung"));
        brandTreeSet.add(new Brand(2,"Lenovo"));
        brandTreeSet.add(new Brand(3,"Apple"));
        brandTreeSet.add(new Brand(4,"Huawai"));
        brandTreeSet.add(new Brand(5,"Casper"));
        brandTreeSet.add(new Brand(6,"Asus"));
        brandTreeSet.add(new Brand(7,"HP"));
        brandTreeSet.add(new Brand(8,"Xaomi"));
        brandTreeSet.add(new Brand(9,"Monster"));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Brand o) {
        return this.getName().compareTo(o.getName());
    }
}
