package branch;

public class OpeningTimeEditor {
    private Branch branch;

    public OpeningTimeEditor(Branch branch) {
        this.branch = branch;
    }

    private boolean isValidHour(int hour) {
        if (hour < 0 || hour > 2400) {
            return false;
        }
        return true;
    }

    private boolean isValidTimeSpan(int beginHour, int endHour) {
        if (beginHour > endHour) {
            return false;
        }
        return true;
    }
    
    public boolean setOpeningTime(int openingHour, int closingHour) {
        if (!isValidHour(openingHour) || !isValidHour(closingHour) || 
        !isValidTimeSpan(openingHour, closingHour)) {
            return false;
        }
        
        this.branch.setOpeningHour(openingHour);
        this.branch.setClosingHour(closingHour);
        return true;
    }
}
