package com.rakharafifa.miniproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakharafifa.miniproject.model.entity.ProductEntity;
import com.rakharafifa.miniproject.repository.ProductRepository;
import com.rakharafifa.miniproject.service.interfaces.ProductService;

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
public class ProductControllerTest {

    @MockBean
    private ProductService service;

    @MockBean
    private ProductRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Get All Product")
    public void getAllProduct() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/product")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post Product Without Data")
    public void postProductNoData() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/product")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Post Product With Correct Data")
    public void postProductWithData() throws Exception{
        ProductEntity product = new ProductEntity();
        product.setProduct_id(1L);
        product.setName("Chiki");
        product.setDescription("Makanan Ringan");
        product.setPrice(2000L);
        product.setQuantity(50L);

        JSONObject payload = new JSONObject();
        payload.put("product_id", product.getProduct_id());
        payload.put("name", product.getName());
        payload.put("description", product.getDescription());
        payload.put("price", product.getPrice());
        payload.put("quantity", product.getQuantity());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/miniproject/product")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Get Product With id")
    public void getProductWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/miniproject/product/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Delete Product")
    public void deleteProductWithId() throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .delete("/miniproject/product/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(204, response.getResponse().getStatus());
    }

    @Test
    @DisplayName("Update Product")
    public void updateProduct() throws Exception{
        ProductEntity product = new ProductEntity();
        product.setName("Rendang");
        product.setDescription("Makanan Berat");
        product.setPrice(15000L);
        product.setQuantity(20L);

        JSONObject payload = new JSONObject();
        payload.put("name", product.getName());
        payload.put("description", product.getDescription());
        payload.put("price", product.getPrice());
        payload.put("quantity", product.getQuantity());


        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/miniproject/product/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }
}
