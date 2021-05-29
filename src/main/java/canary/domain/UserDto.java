package canary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter @Getter
@NoArgsConstructor
public class UserDto {

    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty
    private String password;

}
