package INT222.Project.Services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DeleteUserDTO {
    private Integer userId;
    private Integer adminId;
    private String adminPassword;
}
