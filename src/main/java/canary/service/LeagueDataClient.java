package canary.service;

import canary.domain.league.LeagueDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LeagueDataClient {

    private static final String URL = "http://api.football-data.org/v2/";

    private static final String AUTHORIZATION_HEADER_KEY = "X-Auth-Token";
    private static final String AUTHORIZATION_TOKEN = "2e2241d932ec479483c631d5b531450e";

    private final RestTemplate restTemplate;

    public LeagueDataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LeagueDto getLeagueData(String code){

        ResponseEntity<LeagueDto> exchange = restTemplate.exchange(
                URL + "/competitions/" + code,
                HttpMethod.GET,
                createEntity(),
                LeagueDto.class);
        return exchange.getBody();

    }

    private HttpEntity createEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER_KEY, AUTHORIZATION_TOKEN);
        return new HttpEntity(httpHeaders);
    }

}
