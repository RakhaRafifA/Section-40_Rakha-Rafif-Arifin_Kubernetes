package com.rakharafifa.miniproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakharafifa.miniproject.model.entity.Transaction;
import com.rakharafifa.miniproject.repository.TransactionRepository;
import com.rakharafifa.miniproject.service.TransactionService;

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
public class TransactionControllerTest {
    
    @MockBean
    private TransactionService service;

    @MockBean
    private TransactionRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Get All transaction")
    public void getAlltransaction() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/transaction")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post transaction Without Data")
    public void posttransactionNoData() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/transaction")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post transaction With Correct Data")
    public void posttransactionWithData() throws Exception{
        Transaction transaction = new Transaction();
        transaction.setTransaction_id(1L);
        transaction.setPrice(20000L);
        transaction.setTotal_price(50000L);

        JSONObject payload = new JSONObject();
        payload.put("transaction_id", transaction.getTransaction_id());
        payload.put("price", transaction.getPrice());
        payload.put("total_price", transaction.getTotal_price());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/transaction")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString());

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Get transaction With id")
    public void gettransactionWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/transaction/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Delete transaction")
    public void deletetransactionWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .delete("/miniproject/transaction/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(204, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Update transaction")
    public void updatetransaction() throws Exception{
        Transaction transaction = new Transaction();
        transaction.setTransaction_id(1L);
        transaction.setPrice(20000L);
        transaction.setTotal_price(50000L);

        JSONObject payload = new JSONObject();
        payload.put("transaction_id", transaction.getTransaction_id());
        payload.put("price", transaction.getPrice());
        payload.put("total_price", transaction.getTotal_price());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/miniproject/transaction/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }
}
