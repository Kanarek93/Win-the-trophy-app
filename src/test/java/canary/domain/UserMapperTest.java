package canary.domain;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
            public void entityToDto_whenMaps_thenCorrect(){

        User user = new User();
        user.setName("Kanarek");
        user.setPassword("QWERTY12");

        UserDto uDto = mapper.userToUserDto(user);

        assertEquals(user.getName(), uDto.getName());
        assertEquals(user.getPassword(), uDto.getPassword());
    }


}