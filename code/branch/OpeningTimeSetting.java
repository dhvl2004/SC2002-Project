package branch;

public class OpeningTimeSetting {
    private Branch branch;

    public OpeningTimeSetting(Branch branch) {
        this.branch = branch;
    }

    private boolean validHour(int hour) {
        if (hour < 0 || hour > 2400) {
            return false;
        }
        return true;
    }

    private boolean validTimeSpan(int beginHour, int endHour) {
        if (beginHour > endHour) {
            return false;
        }
        return true;
    }
    
    public boolean setOpeningTime(int newOpeningHour, int newClosingHour) {
        if (!validHour(newOpeningHour) || !validHour(newClosingHour) || 
        !validTimeSpan(newOpeningHour, newClosingHour)) {
            return false;
        }
        
        this.branch.openingHour = newOpeningHour;
        this.branch.closingHour = newClosingHour;
        return true;
    }
}
