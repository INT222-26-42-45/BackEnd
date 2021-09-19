package INT222.Project.Payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {

    private String token;

    private String type = "Bearer";

    private int userId;

    private String username;

    private String email;

    private List<String> roles;

    public JwtResponse(String token, int userId, String username, String email, List<String> roles) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
