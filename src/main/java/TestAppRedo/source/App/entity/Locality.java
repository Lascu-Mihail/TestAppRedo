package TestAppRedo.source.App.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "locality")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Locality {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column(name = "locality_name")
        private String localityName;
        @Column(name = "county_code")
        private String countyCode;


    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLocalityName() {
            return localityName;
        }

        public void setLocalityName(String localityName) {
            this.localityName = localityName;
        }

        public String getCountyCode() {
            return countyCode;
        }

        public void setCountyCode(String countyCode) {
            this.countyCode = countyCode;
        }

        @Override
        public String toString() {
            return "Locality{" +
                    "id=" + id +
                    ", localityName='" + localityName + '\'' +
                    ", countyCode='" + countyCode + '\'' +
                    '}';
        }
    }

