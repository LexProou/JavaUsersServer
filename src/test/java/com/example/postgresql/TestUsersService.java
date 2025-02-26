package com.example.postgresql;

import com.example.postgresql.model.Users;
import com.example.postgresql.repository.UsersRepository;
import com.example.postgresql.service.UsersService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersService usersService;

    private Users user;

    // Инициализация перед каждым тестом
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new Users(1L, "John Doe", "john.doe@example.com"); // Пример пользователя
    }

    @Test
    void testGetAllUsers() {
    // 1. Настройка поведения мока
    when(usersRepository.findAll()).thenReturn(Arrays.asList(user));

    // 2. Вызов метода, который тестируется
    var usersList = usersService.getAllUsers();

    // 3. Проверка результатов
    assertEquals(1, usersList.size());
    assertEquals("John Doe", usersList.get(0).getName());

    // 4. Проверка вызова метода findAll()
    verify(usersRepository, times(1)).findAll();
}

@Test
void testGetUserById() {

    when(usersRepository.findById(1L)).thenReturn(Optional.of(user));

    Optional<Users> foundUser = usersService.getUserById(1L);

    assertTrue(foundUser.isPresent());
    assertEquals("John Doe", foundUser.get().getName());

    verify(usersRepository, times(1)).findById(1L);
}





   

 
}
