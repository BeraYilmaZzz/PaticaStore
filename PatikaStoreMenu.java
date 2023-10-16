import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class PatikaStoreMenu {
    boolean isZero = true;
    TreeSet<Brand> brands = new TreeSet<>();
    List<SmartPhone> smartPhones = new ArrayList<>();
    List<NoteBook> notebooks = new ArrayList<>();

    public PatikaStoreMenu() {
        // Markaların eklenmesi
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));

        // Örnek ürünlerin eklenmesi (Notebook ve Cep Telefonu)
        notebooks.add(new NoteBook(1, 7000.0, 0.0, 10, "HUAWEI Matebook 14", "Huawei",512, 14.0, 16));
        notebooks.add(new NoteBook(2, 3699.0, 0.0, 5, "LENOVO V14 IGL", "Lenovo", 1024,14.0, 8));
        notebooks.add(new NoteBook(3, 8199.0, 0.0, 3, "ASUS Tuf Gaming", "Asus", 2048,15.6, 32));

        smartPhones.add(new SmartPhone(1, 3199.0, 0.0, 20, "SAMSUNG GALAXY A51", "Samsung", 6.5, 6, 128, "Siyah"));
        smartPhones.add(new SmartPhone(2, 7379.0, 0.0, 15, "iPhone 11 64 GB", "Apple", 6.1, 6, 64, "Mavi"));
        smartPhones.add(new SmartPhone(3, 4012.0, 0.0, 30, "Redmi Note 10 Pro 8GB", "Xiaomi", 6.5, 12, 128, "Beyaz"));
    }

    void printMenu() {
        System.out.println("!! PATİKA MAĞAZSINA HOŞGELDİNİZ !!");

        while (isZero) {
            System.out.println();
            Scanner scan = new Scanner(System.in);
            System.out.println("Patika ürün yönetimi panelindesiniz");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış yap");
            int select = scan.nextInt();
            System.out.println("Tercihiniz = " + select);

            switch (select) {
                case 0:
                    System.out.println("Çıkış yapıldı");
                    isZero = false;
                    break;
                case 1:
                    new NotebookOperations().onLocation(notebooks, brands);
                    break;
                case 2:
                    new SmartPhoneOperations().onLocation(smartPhones, brands);
                    break;
                case 3:
                    listBrands();
                    break;
                default:
                    System.out.println("Geçersiz işlem");
            }
        }
    }

    void listBrands() {
        System.out.println("Markalar");
        System.out.println("--------------");
        for (Brand brand : brands) {
            System.out.println("- " + brand.getName());
        }
    }
}
