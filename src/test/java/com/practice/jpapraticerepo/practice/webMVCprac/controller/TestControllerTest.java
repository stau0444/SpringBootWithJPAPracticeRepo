package com.practice.jpapraticerepo.practice.webMVCprac.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.jpapraticerepo.practice.webMVCprac.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@WebMvcTest
@EnableWebMvc
@Import(value = TestController.class)
class TestControllerTest {

    @Autowired
    MockMvc mockMvc;

     @Test
     void controllerTest() throws Exception {
         mockMvc.perform(
                 MockMvcRequestBuilders
                         .get("/api/test"))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.content().string("testOK"))
                 .andDo(MockMvcResultHandlers.print());
     }

     @Test
    void RequestParamTest() throws Exception {
         ObjectMapper objectMapper = new ObjectMapper();
         UserDto user = new UserDto(1L,"ugo","stau04@gmail.com","ugo123");
         mockMvc.perform(MockMvcRequestBuilders.get("/api/exception")
                 .queryParam("id","1")
                 .queryParam("name","ugo")
                 .queryParam("email","stau04@gmail.com")
         )
                 .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(user)))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andDo(MockMvcResultHandlers.print());
     }

     @Test
    void MustHaveAnnotationTest() throws Exception{
         mockMvc.perform(MockMvcRequestBuilders.post("/api/exception").content("{\n" +
                 "\"id\": 1,\n" +
                 "\"name\": \"ugo\",\n" +
                 "\"email\": \"stau04@gmail.com\",\n" +
                 "\"nickname\": \"u2o144ugo\"\n" +
                 "}"))
                 .andExpect(MockMvcResultMatchers.status().is4xxClientError());

         /*
             * http status - 415 error

             The HTTP 415 Unsupported Media Type client error response code indicates that the server refuses
             to accept the request because the payload format is in an unsupported format. The format problem
             might be due to the request's indicated Content-Type or Content-Encoding ,
             or as a result of inspecting the data directly.
          */
     }

}