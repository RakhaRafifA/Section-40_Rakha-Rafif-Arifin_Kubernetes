package com.rakharafifa.miniproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakharafifa.miniproject.model.entity.User;
import com.rakharafifa.miniproject.repository.UserRepository;
import com.rakharafifa.miniproject.service.UserService;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Get All Users")
    public void getAllUsers()throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/user")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post Users without Data")
    public void postUsersNoData()throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/user")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post User With Correct Data")
    public void postUserWithData() throws Exception{
        User user = new User();
        user.setUser_id(1L);
        user.setName("Rakha");
        user.setUsername("rakha");
        user.setPassword("password");

        JSONObject payload = new JSONObject();
        payload.put("user_id", user.getUser_id());
        payload.put("name", user.getName());
        payload.put("username", user.getUsername());
        payload.put("password", user.getPassword());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/user")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Get User With id")
    public void getUserWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/user/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Delete User")
    public void deleteUserWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .delete("/miniproject/user/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(204, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Update User")
    public void updateUser() throws Exception{
        User user = new User();
        user.setName("Rakha");
        user.setUsername("rakha");
        user.setPassword("password");

        JSONObject payload = new JSONObject();
        payload.put("name", user.getName());
        payload.put("username", user.getUsername());
        payload.put("password", user.getPassword());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/miniproject/user/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }
}
