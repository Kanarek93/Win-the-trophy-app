package canary.config;

import canary.domain.league.LeagueMapper;
import canary.domain.team.TeamMapper;
import canary.domain.user.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public TeamMapper getTeamMapper(){
        return Mappers.getMapper(TeamMapper.class);
    }

    @Bean
    public LeagueMapper getLeagueMapper(){
        return Mappers.getMapper(LeagueMapper.class);
    }

    @Bean
    public UserMapper getUserMapper(){
        return Mappers.getMapper(UserMapper.class);
    }
}
