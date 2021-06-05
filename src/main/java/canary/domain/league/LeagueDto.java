package canary.domain.league;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class LeagueDto {

    private long id;
    private String name;
    private String code;


}
