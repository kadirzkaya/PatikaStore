import java.util.LinkedList;
import java.util.List;

public class Brand implements Comparable<Brand>{
    private int id;
    private String name;
    static LinkedList<Brand> brandList=new LinkedList<>();
    public Brand(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(Brand b) {
        return this.name.compareTo(b.getName());
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

    public static List<Brand> addBrand(){
        brandList.add(new Brand(1,"Samsung"));
        brandList.add(new Brand(2,"Lenovo"));
        brandList.add(new Brand(3,"Apple"));
        brandList.add(new Brand(4,"Huawei"));
        brandList.add(new Brand(5,"Casper"));
        brandList.add(new Brand(6,"Asus"));
        brandList.add(new Brand(7,"HP"));
        brandList.add(new Brand(8,"Xiaomi"));
        brandList.add(new Brand(9,"Monster"));
        return brandList;
    }

    public static LinkedList<Brand> listBrand(){
        return brandList;
    }

    public static Brand getBrand(int i){
        Brand br = null;
        for (Brand b:brandList){
            if (b.getId()==i){
                br=b;
                return br;
            }
        }
        return br;
    }
}
