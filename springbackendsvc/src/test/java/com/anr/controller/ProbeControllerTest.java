package com.anr.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProbeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static final String URI_WELCOME = "/hello";
    private static final String URI_READINESS = "/probe/readiness";
    private static final String URI_LIVENESS = "/probe/liveness";

    @Test
    public void test_welcome() throws Exception {
        MockHttpServletRequestBuilder reqBldr = get(URI_WELCOME);
        mockMvc.perform(reqBldr).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void test_readiness() throws Exception {
        MockHttpServletRequestBuilder reqBldr = get(URI_READINESS);
        mockMvc.perform(reqBldr).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void test_liveness() throws Exception {
        MockHttpServletRequestBuilder reqBldr = get(URI_LIVENESS);
        mockMvc.perform(reqBldr).andDo(print()).andExpect(status().isOk());
    }
}
