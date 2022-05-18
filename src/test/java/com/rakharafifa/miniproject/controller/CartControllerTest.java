package com.rakharafifa.miniproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakharafifa.miniproject.model.entity.CartEntity;
import com.rakharafifa.miniproject.repository.CartRepository;
import com.rakharafifa.miniproject.service.interfaces.CartService;

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
public class CartControllerTest {
    
    @MockBean
    private CartService service;

    @MockBean
    private CartRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Get All Cart")
    public void getAllCart() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/cart")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post Cart Without Data")
    public void postCartNoData() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/cart")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post Cart With Correct Data")
    public void postCartWithData() throws Exception{
        CartEntity cart = new CartEntity();
        cart.setCart_id(1L);
        cart.setTotal_price(100000L);
        cart.setQuantity(5L);

        JSONObject payload = new JSONObject();
        payload.put("cart_id", cart.getCart_id());
        payload.put("total_price", cart.getTotal_price());
        payload.put("quantity", cart.getQuantity());


        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/cart")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString());

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Get Cart With id")
    public void getCartWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/cart/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Delete Cart")
    public void deleteCartWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .delete("/miniproject/cart/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(204, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Update Cart")
    public void updateCart() throws Exception{
        CartEntity cart = new CartEntity();
        cart.setTotal_price(150000L);
        cart.setQuantity(7L);

        JSONObject payload = new JSONObject();
        payload.put("total_price", cart.getTotal_price());
        payload.put("quantity", cart.getQuantity());


        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/miniproject/cart/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }
}
