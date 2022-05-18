package com.rakharafifa.miniproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakharafifa.miniproject.model.entity.AddressEntity;
import com.rakharafifa.miniproject.repository.AddressRepository;
import com.rakharafifa.miniproject.service.interfaces.AddressService;

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
public class AddressControllerTest {
    
    @MockBean
    private AddressService service;

    @MockBean
    private AddressRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Get All Address")
    public void getAllAddress() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/address")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post address Without Data")
    public void postaddressNoData() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/address")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post address With Correct Data")
    public void postaddressWithData() throws Exception{
        AddressEntity address = new AddressEntity();
        address.setAddress_id(1L);
        address.setProvince("Jawa Barat");
        address.setCity("Bekasi");
        address.setPost(17158L);
        address.setDetail("Kec Mustikajaya");

        JSONObject payload = new JSONObject();
        payload.put("address_id", address.getAddress_id());
        payload.put("province", address.getProvince());
        payload.put("city", address.getCity());
        payload.put("post", address.getPost());
        payload.put("detail", address.getDetail());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/address")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Get address With id")
    public void getaddressWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/address/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Delete address")
    public void deleteaddressWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .delete("/miniproject/address/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(204, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Update address")
    public void updateaddress() throws Exception{
        AddressEntity address = new AddressEntity();
        address.setProvince("Jawa Barat");
        address.setCity("Bekasi");
        address.setPost(17158L);
        address.setDetail("Kec Mustikajaya");

        JSONObject payload = new JSONObject();
        payload.put("province", address.getProvince());
        payload.put("city", address.getCity());
        payload.put("post", address.getPost());
        payload.put("detail", address.getDetail());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/miniproject/address/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }
}
