import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SmartPhoneOperations {
    public void onLocation(List<SmartPhone> smartPhones, TreeSet<Brand> brands) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Yapmak istediğiniz işlemi seçiniz:");
            System.out.println("1 - Cep telefonu listele");
            System.out.println("2 - Cep telefonu ekle");
            System.out.println("3 - Cep telefonu sil");
            System.out.println("4 - Çıkış yap");

            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    listSmartPhones(smartPhones);
                    break;
                case 2:
                    addSmartphone(scanner, smartPhones, brands);
                    break;
                case 3:
                    deleteSmartPhone(scanner, smartPhones);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }

    void listSmartPhones(List<SmartPhone> smartPhones) {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-9s | %-10s | %-10s | %-9s | %-9s | %-9s | %-9s | %-9s |%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (SmartPhone smartPhone : smartPhones) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-10s | %-10d | %-9.1f | %-9d | %-9.1f | %-9d | %-9s |%n",
                    smartPhone.getUrunId(), smartPhone.getUrunAdi(), smartPhone.getBirimFiyat(),
                    smartPhone.getMarka(), smartPhone.getDepolama(), smartPhone.getEkranBoyutu(),
                    smartPhone.getKamera(), smartPhone.getPilGucu(), smartPhone.getRam(), smartPhone.getRenk());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }

    void addSmartphone(Scanner scanner, List<SmartPhone> smartPhones, TreeSet<Brand> brands) {
        System.out.print("Ürün ID: ");
        int urunId = scanner.nextInt();
        System.out.print("Birim Fiyat: ");
        double birimFiyat = scanner.nextDouble();
        System.out.print("İndirim Oranı: ");
        double indirimOrani = scanner.nextDouble();
        System.out.print("Stok Miktarı: ");
        int stokMiktari = scanner.nextInt();
        System.out.print("Ürün Adı: ");
        String urunAdi = scanner.next();

        // Marka seçimi
        System.out.println("Mevcut markalar:");
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " - " + brand.getName());
        }
        System.out.print("Marka ID'sini girin: ");
        int markaId = scanner.nextInt();
        String marka = getBrandName(markaId, brands);

        System.out.print("Ekran Boyutu (inç): ");
        double ekranBoyutu = scanner.nextDouble();
        System.out.print("RAM (MB): ");
        int ram = scanner.nextInt();
        System.out.print("Depolama (GB): ");
        int depolama = scanner.nextInt();
        System.out.print("Renk: ");
        String renk = scanner.next();

        SmartPhone yeniSmartPhone = new SmartPhone(urunId, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, ekranBoyutu, ram, depolama, renk);
        smartPhones.add(yeniSmartPhone);
        System.out.println("Cep telefonu başarıyla eklendi.");
    }

    void deleteSmartPhone(Scanner scanner, List<SmartPhone> smartPhones) {
        System.out.print("Silmek istediğiniz ürünün ID'sini girin: ");
        int urunId = scanner.nextInt();

        boolean found = false;
        for (SmartPhone smartPhone : smartPhones) {
            if (smartPhone.getUrunId() == urunId) {
                smartPhones.remove(smartPhone);
                found = true;
                System.out.println("Cep telefonu başarıyla silindi.");
                break;
            }
        }

        if (!found) {
            System.out.println("Belirtilen ID'ye sahip bir cep telefonu bulunamadı.");
        }
    }

    String getBrandName(int markaId, TreeSet<Brand> brands) {
        for (Brand brand : brands) {
            if (brand.getId() == markaId) {
                return brand.getName();
            }
        }
        return "Bilinmeyen Marka";
    }
}