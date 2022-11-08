import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Brand.addBrand();
        selectMenu();

    }

    public static void selectMenu(){
        boolean isCon=true;
        while (isCon){
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1-Notebook İşlemleri");
            System.out.println("2-Cep Telefonu İşlemleri");
            System.out.println("3-Marka Listele");
            System.out.println("0-Çıkış Yap");
            System.out.print("Tercihiniz :");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                case 2:
                    productAction(choice);
                    break;
                case 3:
                    LinkedList<Brand> brands= Brand.listBrand();
                    TreeSet<Brand> t=new TreeSet<>(brands);
                    Iterator<Brand> itr=t.iterator();
                    while (itr.hasNext()){
                        System.out.println("- "+itr.next().getName());
                    }
                    break;
                case 0:
                    isCon=false;
                    System.out.println("Mağazadan çıkış yapılıyor.");
                    break;
            }
        }
    }




    public static void productAction(int productNo){
        boolean isContinue=true;
        while (isContinue){
            System.out.println("1-Ürün Listele");
            System.out.println("2-Ürün Ekle");
            System.out.println("3-Ürün Sil");
            System.out.println("4-Ürün Filtrele");
            System.out.println("0-Çıkış Yap");
            int action=sc.nextInt();
            if (productNo==1){
                switch (action){
                    case 1:
                        ProductCategory.listProduct(productNo);
                        break;
                    case 2:
                        addProduct(productNo);
                        break;
                    case 3:
                        deleteProduct(productNo);
                        break;
                    case 4:
                        productList(productNo);
                        break;
                    case 0:
                        isContinue=false;
                        break;
                }
            }else if(productNo==2){
                switch (action){
                    case 1:
                        ProductCategory.listProduct(productNo);
                        break;
                    case 2:
                        addProduct(productNo);
                        break;
                    case 3:
                        deleteProduct(productNo);
                        break;
                    case 4:
                        productList(productNo);
                        break;
                    case 0:
                        isContinue=false;
                        break;
                }
            }
        }

    }

    public static void addProduct(int a){
        int id=0,ram = 0,disRate=0,capacity=0,stock=0,battery=0;
        double price=0.0,screen=0.0;
        String name="",color="";

        if(a==1){
            System.out.println("Bilgisayar özelliklerini giriniz : ");
            setElement(id,ram,disRate,capacity,stock,price,screen,name,a,battery,color);
        }else if(a==2){
            System.out.println("Telefon özelliklerini giriniz : ");
            setElement(id,ram,disRate,capacity,stock,price,screen,name,a,battery,color);
        }
    }

    public static void setElement(int id,int ram,int disRate,int capacity,int stock,double price,double screen,String name,int a,int battery,String color){
        String n="";
        System.out.print("Id giriniz: ");
        id=sc.nextInt();
        if (ProductCategory.idCheck(id,a)){
            System.out.print("Ad giriniz: ");
            n=sc.nextLine();
            name=sc.nextLine();
            System.out.print("Marka Seçiniz :");
            orderBrandList();
            int b=sc.nextInt();
            Brand brand=Brand.getBrand(b);
            System.out.print("Fiyat giriniz: ");
            price=sc.nextDouble();
            System.out.print("Ekran giriniz: ");
            screen=sc.nextDouble();
            System.out.print("Ram giriniz: ");
            ram=sc.nextInt();
            System.out.print("İndirim oranı giriniz: ");
            disRate=sc.nextInt();
            System.out.print("Kapasite giriniz: ");
            capacity=sc.nextInt();
            System.out.print("Stok miktarını giriniz: ");
            stock=sc.nextInt();
            if (a==2){
                System.out.print("Batarya giriniz: ");
                battery=sc.nextInt();
                System.out.print("Renk giriniz: ");
                n=sc.nextLine();
                color=sc.nextLine();
                ProductCategory.addProduct(new Phone(id,price,name,brand,ram,screen,disRate,capacity,stock,color,battery));

            }
            ProductCategory.addProduct(new NoteBook(id,price,name,brand,ram,screen,disRate,capacity,stock));
        }else {
            System.out.println(id+" id numaralı ürün daha önceden eklenmiştir. Ürünü yeni bir id numarası ile ekleyiniz.");
        }
    }

    public static void deleteProduct(int type){
        System.out.print("Silmek istediğiniz ürünün id numarasını giriniz :");
        int pId=sc.nextInt();
        ProductCategory.deleteProduct(pId,type);
    }

    public static void productList(int type){
        System.out.println("Filtreleme işlemi seçiniz: \n1-Id ile Filtreleme\n2-Marka ile Filtreleme");
        int id=0;
        int filterNo=sc.nextInt();
        if (filterNo==1){
            System.out.println("Filtrelenecek ürünün id değerini giriniz : ");
            id=sc.nextInt();
        }else if(filterNo==2){
            System.out.println("Filtrelenecek ürünün marka id değerini giriniz : ");
            orderBrandList();
            id=sc.nextInt();
        }
        ProductCategory.filterProduct(filterNo,type,id);
    }

    public static void orderBrandList(){
        LinkedList<Brand> brands= Brand.listBrand();
        Iterator<Brand> itr=brands.iterator();
        while (itr.hasNext()){
            Brand brn=itr.next();
            System.out.println(brn.getId()+"- "+brn.getName());
        }
    }
}
