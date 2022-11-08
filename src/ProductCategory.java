import java.util.LinkedList;

public class ProductCategory {
    private int id;
    private double price;
    private String name;
    private Brand brand;
    private  int ram;
    private double screen;
    private int discountRate;
    private int capacity;
    private int stock;
    private static LinkedList<NoteBook> _p=new LinkedList<>();
    private static LinkedList<Phone> _ph=new LinkedList<>();

    public ProductCategory(int id, double price, String name, Brand brand, int ram, double screen, int discountRate, int capacity, int stock) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.screen = screen;
        this.discountRate = discountRate;
        this.capacity = capacity;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static void addProduct(NoteBook p){
            _p.add( p);
    }

    public static void addProduct(Phone p){
            _ph.add(p);
    }

    public static void deleteProduct(int id,int type){
        if (type==1){
            if (_p.size()==0){
                System.out.println("Hiç bir ürün bulunmadığından silme yapamazsınız!");
            }
            else {
                for (int i=0;i< _p.size();i++){
                    if(_p.get(i).getId()==id){
                        _p.remove(_p.get(i));
                    }                }
            }
        }else if(type==2){
            if (_ph.size()==0){
                System.out.println("Hiç bir ürün bulunmadığından silme yapamazsınız!");
            }
            else {
                for (int i=0;i< _ph.size();i++){
                    if(_ph.get(i).getId()==id){
                        _ph.remove(_ph.get(i));
                    }
                }
            }
        }
    }

    public static void listProduct(int type){
        if (type==1){
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("| %3s | %11s | %8s | %10s | %5s | %4s | %4s  |", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran","RAM");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");

            for (NoteBook n:_p){
                System.out.format("| %3d | %11s | %8.2f | %10s | %8d | %5.1f | %4d |",+n.getId(),n.getName(),+n.getPrice(),n.getBrand().getName(),n.getCapacity(),n.getScreen(),n.getRam());
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------");
            }
        }else if(type==2){
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("| %3s | %11s | %8s | %10s | %5s | %4s | %5s | %4s |%8s |", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran","Pil","RAM","Renk");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");

            for (Phone n:_ph){
                System.out.format("| %3d | %11s | %8.2f | %10s | %8d | %4.1f | %5d | %4d | %8s |",+n.getId(),n.getName(),+n.getPrice(),n.getBrand().getName(),n.getCapacity(),n.getScreen(),n.getBattery(),n.getRam(),n.getColor());
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------");
            }
        }
    }
    public static void listProductNotebook(LinkedList<NoteBook> nt){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("| %3s | %11s | %8s | %10s | %5s | %4s | %4s  |", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran","RAM");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for (NoteBook n:nt){
            System.out.format("| %3d | %11s | %8.2f | %10s | %8d | %5.1f | %4d |",+n.getId(),n.getName(),+n.getPrice(),n.getBrand().getName(),n.getCapacity(),n.getScreen(),n.getRam());
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }

    public static void listProduct(LinkedList<Phone> p){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("| %3s | %11s | %8s | %10s | %5s | %4s | %5s | %4s |%8s |", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran","Pil","RAM","Renk");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Phone n:p){
            System.out.format("| %3d | %11s | %8.2f | %10s | %8d | %4.1f | %5d | %4d | %8s |",+n.getId(),n.getName(),+n.getPrice(),n.getBrand().getName(),n.getCapacity(),n.getScreen(),n.getBattery(),n.getRam(),n.getColor());
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }

    public static boolean idCheck(int id,int type){
        if (type==1){
            if (_p.size()==0){
                return true;
            }
            else {
                for (int i=0;i< _p.size();i++){
                    return _p.get(i).getId()!=id;
                }
            }
        }else if(type==2){
            if (_ph.size()==0){
                return true;
            }
            else {
                for (int i=0;i< _ph.size();i++){
                    if(_ph.get(i).getId()==id){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void filterProduct(int filterNo, int type,int id) {
        LinkedList<NoteBook> _pNew=new LinkedList<>();
        LinkedList<Phone> _phNew=new LinkedList<>();
        Brand brand=Brand.getBrand(id);
        if (type==1){
            if (filterNo==1){
                for (NoteBook p:_p) {
                    if (p.getId()==id){
                        _pNew.add(p);
                    }
                }
                listProductNotebook(_pNew);
            } else if (filterNo==2) {
                for (NoteBook p:_p) {
                    if (p.getBrand().getId()==brand.getId()){
                        _pNew.add(p);
                    }
                }
                listProductNotebook(_pNew);
            }
        }else if (type==2){
            if (filterNo==1){
                for (Phone p:_ph) {
                    if (p.getId()==id){
                        _phNew.add(p);
                    }
                }
                listProduct(_phNew);
            } else if (filterNo==2) {
                for (Phone p:_ph) {
                    if (p.getBrand().getId()==brand.getId()){
                        _phNew.add(p);
                    }
                }
                listProduct(_phNew);
            }
        }

    }
}
