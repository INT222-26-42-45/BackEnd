package INT222.Project.Payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    private Set<String> roles;

    @NotBlank
    private String password;


}
