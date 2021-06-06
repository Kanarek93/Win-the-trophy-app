package canary.domain.user;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-06T12:47:10+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userDto.getName() );
        user.setPassword( userDto.getPassword() );
        user.setEmail( userDto.getEmail() );

        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( user.getName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }
}
