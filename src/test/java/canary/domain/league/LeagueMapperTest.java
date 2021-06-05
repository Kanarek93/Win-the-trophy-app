package canary.domain.league;

import canary.domain.User;
import canary.domain.UserDto;
import canary.domain.UserMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class LeagueMapperTest {
    private LeagueMapper mapper = Mappers.getMapper(LeagueMapper.class);

    @Test
    public void entityToDto_whenMaps_thenCorrect(){

        League user = new League();
        user.setName("Kanarek");
        user.setId(15);
        user.setCode("OC");

        LeagueDto uDto = mapper.leagueToLeagueDto(user);

        assertEquals(user.getName(), uDto.getName());
        assertEquals(user.getId(), uDto.getId());
        assertEquals(user.getCode(), uDto.getCode());
    }

}