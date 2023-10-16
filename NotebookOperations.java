import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class NotebookOperations {
    public void onLocation(List<NoteBook> notebooks, TreeSet<Brand> brands) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Yapmak istediğiniz işlemi seçiniz:");
            System.out.println("1 - Notebook listele");
            System.out.println("2 - Notebook ekle");
            System.out.println("3 - Notebook sil");
            System.out.println("4 - Çıkış yap");

            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    printNotebookList(notebooks);
                    break;
                case 2:
                    addNotebook(scanner, notebooks, brands);
                    break;
                case 3:
                    deleteNotebook(scanner, notebooks);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }

    void printNotebookList(List<NoteBook> notebooks) {
        System.out.println("Notebook Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-9s | %-10s | %-9s | %-9s | %-9s |%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (NoteBook notebook : notebooks) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-10s | %-9d | %-9.1f | %-9d |%n",
                    notebook.getUrunId(), notebook.getUrunAdi(), notebook.getBirimFiyat(),
                    notebook.getMarka(), notebook.getDepolama(), notebook.getEkranBoyutu(),
                    notebook.getRam());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    void addNotebook(Scanner scanner, List<NoteBook> notebooks, TreeSet<Brand> brands) {
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
        System.out.print("RAM (GB): ");
        int ram = scanner.nextInt();
        System.out.print("Depolama (GB): ");
        int depolama = scanner.nextInt();

        NoteBook newNotebook = new NoteBook(urunId, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, depolama, ekranBoyutu, ram);
        notebooks.add(newNotebook);
        System.out.println("Notebook başarıyla eklendi.");
    }

    void deleteNotebook(Scanner scanner, List<NoteBook> notebooks) {
        System.out.print("Silmek istediğiniz ürünün ID'sini girin: ");
        int urunId = scanner.nextInt();

        boolean found = false;
        for (NoteBook notebook : notebooks) {
            if (notebook.getUrunId() == urunId) {
                notebooks.remove(notebook);
                found = true;
                System.out.println("Notebook başarıyla silindi.");
                break;
            }
        }

        if (!found) {
            System.out.println("Belirtilen ID'ye sahip bir notebook bulunamadı.");
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