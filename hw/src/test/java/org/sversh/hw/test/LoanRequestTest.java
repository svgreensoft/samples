package org.sversh.hw.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
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
import org.sversh.hw.config.RootContextConfig;
import org.sversh.hw.config.WebAppConfig;
import org.sversh.hw.service.web.LoanResponse;
import org.sversh.hw.utils.JsonUtils;

/**
 * 
 * @author Sergey Vershinin</a>
 * @since Apr 8, 2015
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(name = "parent", classes = { RootContextConfig.class }),
        @ContextConfiguration(name = "child", classes = WebAppConfig.class) })
public class LoanRequestTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String REQUEST_1 = "/firstname/John/lastname/Smith/amount/1000/term/30";
    private static final String REQUEST_2 = "/firstname/John2/lastname/Smith2/amount/1000/term/30";
    
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testLoanGranted() throws Exception {
        assertLoanIsGranted(REQUEST_1);
    }
    
    @Test
    public void testNoMoreThan3LoansADay() throws Exception {
        assertLoanIsGranted(REQUEST_2);
        assertLoanIsGranted(REQUEST_2);
        assertLoanIsGranted(REQUEST_2);
        assertLoanIsNotGranted(REQUEST_2);
    }

    private void assertLoanIsNotGranted(String request) throws Exception {
        boolean isGranted = getIfLoanGranted(request);
        Assert.assertTrue("Loan should NOT be granted", !isGranted);
    }

    private void assertLoanIsGranted(String request) throws Exception {
        boolean isGranted = getIfLoanGranted(request);
        Assert.assertTrue("Loan should be granted", isGranted);
    }

    private boolean getIfLoanGranted(String request) throws Exception {
        MvcResult resp = this.mockMvc
                .perform(get(request)
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status()
                        .isOk())
                .andDo(print())
                .andReturn();
        String content = resp.getResponse().getContentAsString();
        LoanResponse loanResponse = JsonUtils.deSerialize(content, LoanResponse.class);
        boolean isGranted = loanResponse.isGranted();
        return isGranted;
    }


}
