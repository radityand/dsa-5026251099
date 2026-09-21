package lw01.unguided;

public class ProjectorRental extends Rental {
    
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    public int calculateCharge() {
        int days = getDays();
        int projectorCharge = 20000;
        
        if (days <= 3) {
            return projectorCharge + (days * 60000);
        } else {
            return projectorCharge + (3 * 60000) + ((days - 3) * 45000);
        }
    }

    public String label() {
        return "Projector";
    }
}