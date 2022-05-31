package hr.tvz.versic.hardwareapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.versic.hardwareapp.command.HardwareCommand;
import hr.tvz.versic.hardwareapp.enums.HardwareType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HardwareControllerTest {


    private static final String TEST_NAME = "test";
    private static final String TEST_CODE = "1234";
    private static final Double TEST_PRICE = Double.valueOf(123);
    private static final HardwareType TEST_TYPE = HardwareType.GPU;
    private static final Integer TEST_STOCK = 12345;

    @Autowired
    private MockMvc mockMvc;

    static HardwareCommand hardwareCommand;

    @BeforeEach
    public void setup(){
        this.hardwareCommand = new HardwareCommand(TEST_NAME,TEST_CODE,TEST_PRICE,TEST_TYPE,TEST_STOCK);
    }

    @Test
    void save() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(
                        post("/hardware")
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN")
                                )
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(hardwareCommand))
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    void getAllHardwares() throws Exception {
        Map<String,Object> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "admin");
        ObjectMapper objectMapper = new ObjectMapper();

        MvcResult mvcResult = this.mockMvc.perform(
                post("/authentication/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))

        ).andExpect(status().isOk()).andReturn();

        String token = mvcResult.getResponse().getContentAsString();

        token = token.replace("{\"jwt\":\"", "")
                .replace("\"}", "");


        this.mockMvc.perform(
                get("/hardware")
                        .with(csrf())
                        .header(HttpHeaders.AUTHORIZATION,"Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )       .andExpect(status().isOk());
    }

    @Test
    void returnByValue() throws Exception{
        this.mockMvc.perform(
                get("/hardware/value/a")
                        .with(user("admin")
                                .password("admin")
                                .roles("ADMIN")
                        )
                        .with(csrf())
                        .header(HttpHeaders.AUTHORIZATION,"Bearer ")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )       .andExpect(status().isOk());
    }

    @Test
    void hardwareType() throws Exception{

        Map<String,Object> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "admin");
        ObjectMapper objectMapper = new ObjectMapper();

        MvcResult mvcResult = this.mockMvc.perform(
                post("/authentication/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))

        ).andExpect(status().isOk()).andReturn();

        String token = mvcResult.getResponse().getContentAsString();

        token = token.replace("{\"jwt\":\"", "")
                .replace("\"}", "");


        this.mockMvc.perform(
                get("/hardware/type")
                        .with(csrf())
                        .header(HttpHeaders.AUTHORIZATION,"Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )       .andExpect(status().isOk());
    }

    @Test
    void returnByCode() throws Exception{
        this.mockMvc.perform(
                get("/hardware/0001")
                        .with(user("admin")
                                .password("admin")
                                .roles("ADMIN")
                        )
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(hardwareCommand))
                        .accept(MediaType.APPLICATION_JSON)
        )  .andExpect(status().isOk());
    }

}