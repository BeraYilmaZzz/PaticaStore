public class SmartPhone extends Product {
    private int depolama;
    private double ekranBoyutu;
    private int ram;
    private String renk;
    private int kamera;
    private double pilGucu;

    public SmartPhone(int urunId, double birimFiyat, double indirimOrani, int stokMiktari, String urunAdi, String marka, double ekranBoyutu, int ram, int depolama, String renk) {
        super(urunId, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, ekranBoyutu, ram, depolama);
        this.depolama = depolama;
        this.ekranBoyutu = ekranBoyutu;
        this.ram = ram;
        this.renk = renk;
        this.kamera = 0; // Başlangıçta kamera değeri 0 olacak.
        this.pilGucu = 0; // Başlangıçta pil gücü değeri 0 olacak.
    }

    public int getDepolama() {
        return depolama;
    }

    public void setDepolama(int depolama) {
        this.depolama = depolama;
    }

    public double getEkranBoyutu() {
        return ekranBoyutu;
    }

    public void setEkranBoyutu(double ekranBoyutu) {
        this.ekranBoyutu = ekranBoyutu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getKamera() {
        return kamera;
    }

    public void setKamera(int kamera) {
        this.kamera = kamera;
    }

    public double getPilGucu() {
        return pilGucu;
    }

    public void setPilGucu(double pilGucu) {
        this.pilGucu = pilGucu;
    }
}