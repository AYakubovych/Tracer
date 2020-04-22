package ddns.net.data.entities;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class LocationData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private long targetId;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @Column
    private String  date;

    @Column
    private String  time;

    public LocationData(){}

    @Override
    public String toString(){
        return id + " " + targetId + " " + latitude + " " + longitude + " " + date + " " + time;
    }

    public long getTargetId() {
        return targetId;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
