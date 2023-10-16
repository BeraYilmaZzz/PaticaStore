class NoteBook extends Product {
    private int depolama;
    private double ekranBoyutu;
    private int ram;
    public NoteBook(int urunId, double birimFiyat, double indirimOrani, int stokMiktari, String urunAdi, String marka, int depolama, double ekranBoyutu, int ram) {
        super(urunId, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, ekranBoyutu, ram, depolama);
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
}