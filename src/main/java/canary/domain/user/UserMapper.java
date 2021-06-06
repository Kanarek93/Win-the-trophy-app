package canary.domain.user;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
