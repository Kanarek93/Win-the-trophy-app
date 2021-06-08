package canary.domain.team;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class TeamDto {

    private Long id;
    private String name;
    private String tla;
    private String crestUrl;
}
