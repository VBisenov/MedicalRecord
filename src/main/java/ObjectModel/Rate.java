package ObjectModel;

import java.util.Objects;

public class Rate {
    private int id;
    private int rateDelay;
    private int rateFriendly;
    private String comment;

    public Rate(int id, int rateDelay, int rateFriendly, String comment) {
        this.id = id;
        this.rateDelay = rateDelay;
        this.rateFriendly = rateFriendly;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRateDelay() {
        return rateDelay;
    }

    public void setRateDelay(int rateDelay) {
        this.rateDelay = rateDelay;
    }

    public int getRateFriendly() {
        return rateFriendly;
    }

    public void setRateFriendly(int rateFriendly) {
        this.rateFriendly = rateFriendly;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", rateDelay=" + rateDelay +
                ", rateFriendly=" + rateFriendly +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rate)) return false;
        Rate rate = (Rate) o;
        return getId() == rate.getId() &&
                getRateDelay() == rate.getRateDelay() &&
                getRateFriendly() == rate.getRateFriendly() &&
                getComment().equals(rate.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRateDelay(), getRateFriendly(), getComment());
    }
}
