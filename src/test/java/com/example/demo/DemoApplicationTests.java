package com.example.demo;

import com.example.demo.domain.Constants;
import com.example.demo.domain.PerfectDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import java.nio.charset.Charset;

import static com.example.demo.TestUtil.writeValueAsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

    protected static final MediaType CONTENT_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Inject
    protected MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSmartBuilder2() throws Exception {

        PerfectDTO perfectDTO = PerfectDTO.build(p ->
                p.smartSetName("Name"));

        mockMvc.perform(post(Constants.API_BASE
                + "/smartbuilder")
//				.cookie(COOKIE)//cookie settings
//				.header("authorization", "Bearer " + MANAGER_TOKEN)
                .content(writeValueAsString(perfectDTO))
                .contentType(CONTENT_TYPE))//return content type
                .andDo(print())//print more info
                .andExpect(status().isOk());
    }
}

