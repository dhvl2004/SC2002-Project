package branch;


/**
 * <li>Class used for setting an opening time for branch
 * <li>Branch also verifies the validity of the timespan of opening hours
 * @author FDAB 2
 * @version 1.0 
 * 
 */
public class OpeningTimeEditor {
    private Branch branch;

    
    /**
     * Base Constructor
     * @param branch Branch whose opening hours will be changed
     */
    public OpeningTimeEditor(Branch branch) {
        this.branch = branch;
    }

    /**
     * CHecks to see if the given hour is valid, based on 24hour clock
     * @param hour intended hour to verify
     * @return true meaning the time input is valid
     */
    private boolean isValidHour(int hour) {
        if (hour < 0 || hour > 2400) {
            return false;
        }
        return true;
    }

    /**
     * Verifies if the timespan is logical for a fast-food branch 
     * @param beginHour Start hour of time frame
     * @param endHour end hour of time frame
     * @return True : meaning that the timeframe in question is valid
     */
    private boolean isValidTimeSpan(int beginHour, int endHour) {
        if (beginHour > endHour) {
            return false;
        }
        return true;
    }
    
    
    /**
     * Directly sets the opening hours of the branch 
     * @param openingHour When the branch will be opened for business
     * @param closingHour When the branch will be closed for business
     * @return <li> True if the time frame is valid and can be applied to the branch
     *         <li> False if the Time frame given is not logical in the context of a fast-food branch
     */
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
