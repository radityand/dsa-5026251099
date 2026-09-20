package lw01.prelab;

public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    public PrintJob(String id, int pages) {
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return this.id;
    }

    public int getPages() {
        return this.pages;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("Copies tidak boleh dibawah nol");
        }
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}