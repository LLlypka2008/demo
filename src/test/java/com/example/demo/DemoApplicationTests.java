package com.example.demo;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

  @Autowired
  MockMvc mockMvc;

  @Test
  void indexTest() throws Exception {
    this.mockMvc.perform(get("/")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Подача заявки")));
  }

  @Test
  void buyerControllerTest() throws Exception {
    this.mockMvc.perform(post("/buyer")
            .param("name", "Иван")
            .param("surname", "Иванов")
            .param("patronymic", "Иванович")
            .param("passportNumber", "0000000000")
            .param("dayOfBirth", "1999-03-10")
            .param("phoneNumber", "+79991234567"))
        .andExpect(status().is3xxRedirection());
  }
}
