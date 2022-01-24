package com.example.springboot;

import com.example.springboot.controller.AccountController;
import com.example.springboot.model.AccountBalance;
import com.example.springboot.model.AccountTransaction;
import com.example.springboot.model.Transaction;
import com.example.springboot.service.RestService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AccountController.class)
class AccountRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RestService restService;

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    @Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    void getAccountBalance() throws Exception {

        AccountBalance balance = new AccountBalance();
        balance.setStatus("OK");
        balance.setAvailableBalance(7L);
        balance.setBalance(7L);

        String uri = "14537780/balance";

        when(restService.getResponseEntity(uri)).thenReturn(objectMapper.writeValueAsString(balance));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/account/14537780/balance/").accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        AccountBalance bal = mapFromJson(content, AccountBalance.class);
        assertEquals(balance.toString(), bal.toString());
    }

    @Test
    void getAccountTransactions() throws Exception {

        AccountTransaction transactions = new AccountTransaction();
        transactions.setStatus("OK");
        List<Transaction> list = new ArrayList<>();
        Transaction trans = new Transaction();
        trans.setTransactionId("282831");
        list.add(trans);
        transactions.setList(list);

        String uri = "14537780/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01";

        when(restService.getResponseEntity(uri)).thenReturn(objectMapper.writeValueAsString(transactions));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/account/14537780/transactions/").accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        AccountTransaction resultTransactions = mapFromJson(content, AccountTransaction.class);
        assertTrue(resultTransactions.getList().size() > 0);
    }

}

