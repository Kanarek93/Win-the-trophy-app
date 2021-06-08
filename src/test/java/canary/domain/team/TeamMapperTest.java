package canary.domain.team;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class TeamMapperTest {

    private TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);

    @Test

    public void dtoToEntity_whenMaps_thenCorrect(){

        TeamDto teamDto = new TeamDto();
        teamDto.setId(1l);
        teamDto.setName("Real");
        teamDto.setTla("RMD");
        teamDto.setCrestUrl("logo");

        Team team = teamMapper.teamDtoToTeam(teamDto);

        assertEquals(teamDto.getName(), team.getName());
        assertEquals(team.getId(), teamDto.getId());
        assertEquals(team.getCrestUrl(), teamDto.getCrestUrl());
        assertEquals(team.getTla(), teamDto.getTla());

    }
}