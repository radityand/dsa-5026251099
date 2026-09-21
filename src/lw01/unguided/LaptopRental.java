package lw01.unguided;

public class LaptopRental extends Rental {
    
    public LaptopRental(String id, int days) {
        super(id, days);
    }

    public int calculateCharge() {
        int days = getDays();
        int laptopCharge = 10000;
        return (days*40000) + laptopCharge;
    }

    public String label() {
        return "Laptop";
    }
}
