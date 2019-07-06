package ObjectModel;

import java.sql.Time;
import java.sql.Date;
import java.util.Objects;

public class Visit {
    private int id;
    private String doctorFullName, doctorJobTitle;
    private Time time;
    private Date date;
    private Rate rate;

    public Visit(int id, String doctorFullName, String doctorJobTitle, Time time, Date date, Rate rate) {
        this.id = id;
        this.doctorFullName = doctorFullName;
        this.doctorJobTitle = doctorJobTitle;
        this.time = time;
        this.date = date;
        this.rate = rate;
    }

    public Visit(int id, String doctorFullName, String doctorJobTitle, Time time, Date date) {
        this.id = id;
        this.doctorFullName = doctorFullName;
        this.doctorJobTitle = doctorJobTitle;
        this.time = time;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public String getDoctorJobTitle() {
        return doctorJobTitle;
    }

    public void setDoctorJobTitle(String doctorJobTitle) {
        this.doctorJobTitle = doctorJobTitle;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", doctorFullName='" + doctorFullName + '\'' +
                ", doctorJobTitle='" + doctorJobTitle + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit)) return false;
        Visit visit = (Visit) o;
        return getId() == visit.getId() &&
                getDoctorFullName().equals(visit.getDoctorFullName()) &&
                getDoctorJobTitle().equals(visit.getDoctorJobTitle()) &&
                getTime().equals(visit.getTime()) &&
                getDate().equals(visit.getDate()) &&
                getRate().equals(visit.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDoctorFullName(), getDoctorJobTitle(), getTime(), getDate(), getRate());
    }
}
