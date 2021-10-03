package INT222.Project.Payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class JwtResponse {

    private int userId;

    private String username;

    private String email;

    private List<String> roles;

    private String token;

    private String type = "Bearer";

    public JwtResponse(int userId, String username, String email, List<String> roles, String accessToken) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.token = accessToken;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
