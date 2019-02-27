package io.cjet.demoapp.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class) 
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void sayHiTest() throws Exception {
    	mvc.perform(get("/hello")
    		      .contentType(MediaType.TEXT_PLAIN))
    		      .andExpect(status().isOk())
    		      .andExpect(content().string(containsString("Hi David Wu! The Spring RestController mapping works!")));;
    }
    
}
