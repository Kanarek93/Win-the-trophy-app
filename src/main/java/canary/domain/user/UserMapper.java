package canary.domain.user;

import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
}
