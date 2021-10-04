package INT222.Project.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private int roleid;

//    @Column(name = "RoleName")
//    private String rolename;

    @Enumerated(EnumType.STRING)
    @Column(name = "RoleName")
    private ERole rolename;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roles")
    Set<Users> users;

    public Roles(ERole rolename) {
        this.rolename = rolename;
    }
}
