package TestAppRedo.source.App.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList();


}
