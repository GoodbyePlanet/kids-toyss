package com.kidstoys.kidstoys.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kidstoys.kidstoys.domain.User;
import com.kidstoys.kidstoys.services.UserService;

@SpringBootTest(properties = "spring.liquibase.enabled=false")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserControllerTest {

    private static final User USER = User.builder().name("user").email("user@user").build();

    private static final String API_USERS = "/api/users";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void should_return_status_OK_and_list_of_users() throws Exception {
        when(userService.getUsers()).thenReturn(List.of(USER));

        mockMvc.perform(get(API_USERS)).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("[{\"id\":null,\"name\":\"user\",\"email\":\"user@user\"}]")));
    }

    @Test
    void should_return_status_NOT_FOUND_if_API_url_is_not_found() throws Exception {
        mockMvc.perform(get("/api/")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void should_return_status_CREATED_and_created_user() throws Exception {
        doNothing().when(userService).save(any(User.class));

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = writer.writeValueAsString(USER);

        mockMvc.perform(post(API_USERS)
                .contentType(APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("user"))
            .andExpect(jsonPath("$.email").value("user@user"));
    }
}