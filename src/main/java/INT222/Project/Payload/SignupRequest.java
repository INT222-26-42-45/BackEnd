package INT222.Project.Payload;


import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {


    private String firstname;

    private String lastname;

    private Date birth;

    private String gender;

    private String tel;

    private String username;


    private String email;

    private Set<String> roles;


    private String password;


}
