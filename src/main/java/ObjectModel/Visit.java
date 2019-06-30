package ObjectModel;

import java.time.LocalDate;
import java.sql.Date;
import java.util.Objects;

public class Visit {
    private int id;
    private String doctorFullName, doctorJobTitle, time;
    Date date;

    public Visit(int id, String doctorFullName, String doctorJobTitle, String time, Date date) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", doctorFullName='" + doctorFullName + '\'' +
                ", doctorJobTitle='" + doctorJobTitle + '\'' +
                ", time='" + time + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit)) return false;
        Visit visit = (Visit) o;
        return getId() == visit.getId() &&
                Objects.equals(getDoctorFullName(), visit.getDoctorFullName()) &&
                Objects.equals(getDoctorJobTitle(), visit.getDoctorJobTitle()) &&
                Objects.equals(getTime(), visit.getTime()) &&
                Objects.equals(getDate(), visit.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDoctorFullName(), getDoctorJobTitle(), getTime(), getDate());
    }
}
