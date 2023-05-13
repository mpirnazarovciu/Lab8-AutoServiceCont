package uz.muu;

public class AutoServiceRating {
    private AutoService autoService;
    private int averageRating;

    public AutoServiceRating(AutoService autoService, int averageRating, String comment) {
        this.autoService = autoService;
        this.averageRating = averageRating;
    }

    public AutoService getAutoService() {
        return autoService;
    }

    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "AutoServiceRating{" +
                "autoService=" + autoService +
                ", averageRating=" + averageRating +
                '}';
    }
}
