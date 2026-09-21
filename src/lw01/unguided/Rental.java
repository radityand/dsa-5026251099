package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    public Rental(String id, int days) {
        this.id = id;
        this.days = days;
    }

    public String getId() {
        return this.id;
    }

    public int getDays() {
        return this.days;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("Units tidak boleh dibawah nol");
        }
        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary(int units) {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}