package canary.service;

import canary.domain.league.LeagueDto;
import canary.domain.league.LeagueMapper;
import canary.domain.league.LeagueTeamDto;
import canary.domain.match.Match;
import canary.domain.match.MatchMainDto;
import canary.domain.match.MatchMainMapper;
import canary.domain.team.Team;
import canary.domain.team.TeamMapper;
import lombok.RequiredArgsConstructor;
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
public class DataClient {

    private static final String URL = "https://api.football-data.org/v2/competitions/";

    private static final String AUTHORIZATION_HEADER_KEY = "X-Auth-Token";
    private static final String AUTHORIZATION_TOKEN = "2e2241d932ec479483c631d5b531450e";

    private final TeamMapper teamMapper;
    private final MatchMainMapper matchMainMapper;
    private final LeagueMapper leagueMapper;
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
                .map(team -> teamMapper.teamDtoToTeam(team))
                .peek(team -> team.setLeague(leagueMapper.leagueDtoToLeague(leagueDto)))
                .collect(Collectors.toList());

        leagueDto.setCounts(exchangeTeam.getBody().getCounts());
        leagueDto.setTeams(teams);
        return leagueDto;

    }

    public List<Match> getLeagueMatches(String code) {
        ResponseEntity<MatchMainDto> exchangeMatches = restTemplate.exchange(
                URL + code.toUpperCase() + "/matches",
                HttpMethod.GET,
                createEntity(),
                new ParameterizedTypeReference<MatchMainDto>() {}
        );
        return matchMainMapper.getListOfMatches(exchangeMatches.getBody());
    }

    private HttpEntity createEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER_KEY, AUTHORIZATION_TOKEN);
        return new HttpEntity(httpHeaders);
    }

}
