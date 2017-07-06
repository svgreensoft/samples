package org.sversh.superhero.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.sversh.superhero.config.RootContextConfig;
import org.sversh.superhero.config.WebAppConfig;

/**
 * 
 * @author Sergey Vershinin</a>
 *
 * MockMvc configuration is not using your WebAppInitializer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(name = "parent", classes = { RootContextConfig.class }),
        @ContextConfiguration(name = "child", classes = WebAppConfig.class) })
public class LoanRequestTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String CREATE_REQUEST = "/create";
    
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testHeroCreated() throws Exception {
        String reqBody = "{\"name\":\"John\", \"pseudonym\":\"Doe\", "
                + "\"publisher\":\"mypublisher\", \"startDate\":\"2016-12-12\"} ";
        MvcResult resp = this.mockMvc
                .perform(post(CREATE_REQUEST)
                        .content(reqBody)
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status()
                        .isOk())
                .andDo(print())
                .andReturn();
        String content = resp.getResponse().getContentAsString();
        System.out.println(content);
    }
    

}
