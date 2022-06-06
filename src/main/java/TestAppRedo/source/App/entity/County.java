package TestAppRedo.source.App.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "county")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "county_name")
    private String countyName;
    @Column(name = "county_code")
    private String countyCode;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountyName() {return Integer.parseInt(countyName);
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    @Override
    public String toString() {
        return "County{" +
                "id=" + id +
                ", countyName='" + countyName + '\'' +
                ", countyCode='" + countyCode + '\'' +
                '}';
    }
}

