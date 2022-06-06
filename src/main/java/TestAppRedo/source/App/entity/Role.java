package TestAppRedo.source.App.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue (strategy = AUTO)
    private Long id;
    private String name;
}