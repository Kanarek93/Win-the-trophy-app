package canary.service.league;

import canary.domain.league.LeagueDto;
import canary.domain.league.LeagueMapper;
import canary.domain.league.LeagueTeamDto;
import canary.domain.match.Match;
import canary.domain.team.Team;
import canary.domain.team.TeamDto;
import canary.domain.team.TeamMapper;
import canary.repository.LeagueRepository;
import canary.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.mapstruct.factory.Mappers;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LeagueDataClient {

    private static final String URL = "https://api.football-data.org/v2/competitions/";

    private static final String AUTHORIZATION_HEADER_KEY = "X-Auth-Token";
    private static final String AUTHORIZATION_TOKEN = "2e2241d932ec479483c631d5b531450e";

    private final TeamMapper mapper;
    private final RestTemplate restTemplate;

    public LeagueDto getLeagueData(String code){

        ResponseEntity<LeagueDto> exchangeLeague = restTemplate.exchange(
                URL + code.toUpperCase(),
                HttpMethod.GET,
                createEntity(),
                LeagueDto.class);
        LeagueDto leagueDto = exchangeLeague.getBody();

        ResponseEntity<LeagueTeamDto> exchangeTeam = restTemplate.exchange(
                        URL + code.toUpperCase() + "/teams",
                        HttpMethod.GET,
                        createEntity(),
                        new ParameterizedTypeReference<LeagueTeamDto>() {}
                );

        List<Team> teams = exchangeTeam.getBody().getTeams().stream()
                .map(team -> mapper.teamDtoToTeam(team))
                .collect(Collectors.toList());

        leagueDto.setTeams(teams);
        return leagueDto;

    }

    public List<Match> getLeagueMatches(String code) {
        ResponseEntity<LeagueTeamDto> exchangeTeam = restTemplate.exchange(
                URL + code.toUpperCase() + "/matches",
                HttpMethod.GET,
                createEntity(),
                new ParameterizedTypeReference<LeagueTeamDto>() {}
        );
    }

    private HttpEntity createEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER_KEY, AUTHORIZATION_TOKEN);
        return new HttpEntity(httpHeaders);
    }

}
