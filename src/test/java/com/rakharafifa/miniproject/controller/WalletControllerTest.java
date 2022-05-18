package com.rakharafifa.miniproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakharafifa.miniproject.model.entity.WalletEntity;
import com.rakharafifa.miniproject.repository.WalletRepository;
import com.rakharafifa.miniproject.service.interfaces.WalletService;

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
public class WalletControllerTest {
    
    @MockBean
    private WalletService service;

    @MockBean
    private WalletRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Get All wallet")
    public void getAllwallet() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/wallet")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post wallet Without Data")
    public void postwalletNoData() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/wallet")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post wallet With Correct Data")
    public void postwalletWithData() throws Exception{
        WalletEntity wallet = new WalletEntity();
        wallet.setWallet_id(1L);
        wallet.setName("Dompet Rakha");
        wallet.setAmount(500000L);

        JSONObject payload = new JSONObject();
        payload.put("wallet_id", wallet.getWallet_id());
        payload.put("name", wallet.getName());
        payload.put("amount", wallet.getAmount());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/wallet")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Get wallet With id")
    public void getwalletWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/wallet/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Delete wallet")
    public void deletewalletWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .delete("/miniproject/wallet/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(204, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Update wallet")
    public void updatewallet() throws Exception{
        WalletEntity wallet = new WalletEntity();
        wallet.setName("Dompet Rakha");
        wallet.setAmount(500000L);

        JSONObject payload = new JSONObject();
        payload.put("name", wallet.getName());
        payload.put("amount", wallet.getAmount());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/miniproject/wallet/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }
}
