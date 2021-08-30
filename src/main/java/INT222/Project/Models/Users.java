package INT222.Project.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String firstname;

    private String lastname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private String gender;

    private String email;

    private String tel;

    private String username;

    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "roles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Set<Roles> roles;

}
