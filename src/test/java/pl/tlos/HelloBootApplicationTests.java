package pl.tlos;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pl.tlos.user.managment.UserInfoController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloBootApplication.class)
@WebAppConfiguration
public class HelloBootApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new UserInfoController()).build();

	}

	@Test
	public void testGetInfo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/user/info?name=t"))//
				.andExpect(status().isOk())//
				.andExpect(content().string(equalTo("hello t")));

	}

	@Test
	public void contextLoads() {
		assertTrue(true);
	}

}
