package com.phoosop.reactive.converter;

import com.phoosop.reactive.model.command.UserCommand;
import com.phoosop.reactive.model.enums.UserLevel;
import com.phoosop.reactive.model.enums.UserStatus;
import com.phoosop.reactive.model.enums.UserType;
import com.phoosop.reactive.model.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserCommandToUserResponseConverterTest {

    @InjectMocks
    private UserCommandToUserResponseConverterImpl userCommandToUserResponseConverter;

    @Test
    public void testConvert() {
        UserCommand source = new UserCommand()
                .setId(1L)
                .setCardId("cardId")
                .setFirstName("firstName")
                .setSecondName("secondName")
                .setDateOfBirth("27-11-1991")
                .setType(UserType.USER)
                .setStatus(UserStatus.ACTIVE)
                .setLevel(UserLevel.LEVEL_1)
                .setAge(18);
        UserResponse result = userCommandToUserResponseConverter.convert(source);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getCardId()).isEqualTo("cardId");
        assertThat(result.getFirstName()).isEqualTo("firstName");
        assertThat(result.getSecondName()).isEqualTo("secondName");
        assertThat(result.getDateOfBirth()).isEqualTo("27-11-1991");
        assertThat(result.getType()).isEqualTo(UserType.USER.getValue());
        assertThat(result.getStatus()).isEqualTo(UserStatus.ACTIVE.getValue());
        assertThat(result.getLevel()).isEqualTo(UserLevel.LEVEL_1.getValue());
        assertThat(result.getAge()).isEqualTo(18);
    }

}