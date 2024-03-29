package com.webservicepizzariazeff.www.controller;

import com.webservicepizzariazeff.www.dto.request.UserRequestDTO;
import com.webservicepizzariazeff.www.exception.ExistingUserException;
import com.webservicepizzariazeff.www.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private static UserRequestDTO userRequestDTO;

    @BeforeAll
    static void setUserRequestDTO() {

        userRequestDTO = UserRequestDTO.UserDTOBuilder.builder()
                .name("name")
                .username("username")
                .password("password")
                .build();
    }

    @BeforeEach
    void definitionOfBehaviorsForMocks() {

        BDDMockito.when(this.userService.registerUser(ArgumentMatchers.any(UserRequestDTO.class), ArgumentMatchers.anyString()))
                .thenReturn(1L);
    }

    @Test
    void authenticateUser_returnsAStatusCodeNoContent_wheneverCalled() {

        Assertions.assertThatCode(() -> this.userController.authenticateUser())
                .doesNotThrowAnyException();

        Assertions.assertThat(this.userController.authenticateUser())
                .isNotNull()
                .isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @Test
    void registerNewUser_returnsTheIdOfTheUserThatWasSavedAndAStatusCodeCreated_WhenTheUserIsNotRegistered() {

        Assertions.assertThatCode(() -> this.userController.registerNewUser(userRequestDTO, ""))
                .doesNotThrowAnyException();

        Assertions.assertThat(this.userController.registerNewUser(userRequestDTO, ""))
                .isNotNull()
                .isEqualTo(new ResponseEntity<>(1L, HttpStatus.CREATED));
    }

    @Test
    void registerNewUser_throwsExistingUserException_whenTheUserIsAlreadyRegistered() {

        BDDMockito.when(this.userService.registerUser(ArgumentMatchers.any(UserRequestDTO.class), ArgumentMatchers.anyString()))
                .thenThrow(ExistingUserException.class);

        Assertions.assertThatExceptionOfType(ExistingUserException.class)
                .isThrownBy(() -> this.userController.registerNewUser(userRequestDTO, ""));
    }
}