package lw01.prelab;

public class ColourPrint extends PrintJob {
    
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    public int calculateCharge() {
        int pages = getPages();
        int colourCharge = 2000;
        
        if (pages <= 10) {
            return colourCharge + (pages * 1500);
        } else {
            return colourCharge + (10 * 1500) + ((pages - 10) * 1000);
        }
    }

    public String label() {
        return "Colour";
    }
}