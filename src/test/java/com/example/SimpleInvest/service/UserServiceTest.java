package com.example.SimpleInvest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.SimpleInvest.dtos.UserDto;
import com.example.SimpleInvest.entity.User;
import com.example.SimpleInvest.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Captor
    private ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Nested
    class createUser {

        @Test
        @DisplayName("Should create a new user with success")
        void shouldCreateAUserWithSuccess() {

            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email@gmail.com",
                    "123",
                    Instant.now(),
                    null);

            doReturn(user).when(userRepository).save(userArgumentCaptor.capture());
            var input = new UserDto("username", "email@gmail.com", "123");

            var output = userService.createUser(input);
            assertNotNull(output);

            var captured = userArgumentCaptor.getValue();

            assertEquals(input.name(), captured.getName());
            assertEquals(input.email(), captured.getEmail());
            assertEquals(input.password(), captured.getPassword());

        }

        @Test
        @DisplayName("Should throw exception when error occurs")
        void shouldThrowExceptionWhenErrorOccurs() {
            doThrow(new RuntimeException()).when(userRepository).save(any());

            var input = new UserDto("username",
                    "email@gmail.com",
                    "123");

            assertThrows(RuntimeException.class, () -> userService.createUser(input));

            assertNotNull(input);
        }
    }

    @Nested
    class getUserById {

        @Test
        @DisplayName("Shoul get user by id with a success when optional is present")
        void shouldGetUserByIdWithASuccessWhenOptionalIsPresent() {
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email@gmail.com",
                    "123",
                    Instant.now(),
                    null);

            doReturn(Optional.of(user)).when(userRepository).findById(uuidArgumentCaptor.capture());

            var output = userService.findUserById(user.getUserId());

            assertTrue(output.isPresent());
            assertEquals(user.getUserId(), uuidArgumentCaptor.getValue());

        }

        @Test
        @DisplayName("Shoul get user by id with a success when optional is empty")
        void shouldGetUserByIdWithASuccessWhenOptionalIsEmpty() {

            var userId = UUID.randomUUID();

            doReturn(Optional.empty()).when(userRepository).findById(uuidArgumentCaptor.capture());

            var output = userService.findUserById(userId);

            assertTrue(output.isEmpty());
            assertEquals(userId, uuidArgumentCaptor.getValue());

        }
    }
}
