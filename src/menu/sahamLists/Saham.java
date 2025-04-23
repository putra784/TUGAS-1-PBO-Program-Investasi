package menu.sahamLists;

public class Saham {
    private String code;
    private String companyName;
    private double price;

    public Saham(String code, String companyName, double price) {
        this.code = code;
        this.companyName = companyName;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Kode: %s - %s || harga: Rp.%.2f", code, companyName, price);
    }

    public String getCode(){
        return code;
    }

    public String getCompanyName(){
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
