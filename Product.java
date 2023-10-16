public abstract class Product {
    private int urunId;
    private double birimFiyat;
    private double indirimOrani;
    private int stokMiktari;
    private String urunAdi;
    private String marka;

    public Product(int urunId, double birimFiyat, double indirimOrani, int stokMiktari, String urunAdi, String marka, double ekranboyutu, int ram, int depolama) {
        this.urunId = urunId;
        this.birimFiyat = birimFiyat;
        this.indirimOrani = indirimOrani;
        this.stokMiktari = stokMiktari;
        this.urunAdi = urunAdi;
        this.marka = marka;
    }

    public int getUrunId() {
        return urunId;
    }

    public double getBirimFiyat() {
        return birimFiyat;
    }

    public double getIndirimOrani() {
        return indirimOrani;
    }

    public int getStokMiktari() {
        return stokMiktari;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public String getMarka() {
        return marka;
    }
}