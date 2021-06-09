package canary.domain.team;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamDto {

    private Long id;
    private String name;
    private String tla;
    private String crestUrl;
}
