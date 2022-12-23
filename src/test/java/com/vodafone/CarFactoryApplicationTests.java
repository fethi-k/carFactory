package com.vodafone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarFactoryApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void returnNullInputMessage() throws Exception {
		this.mockMvc.perform(get("/producecar"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Empty or null input.")));
	}

	@Test
	public void returnEmptyInputMessage() throws Exception {
		this.mockMvc.perform(get("/producecar").param("type",""))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Empty or null input.")));
	}

	@Test
	public void returnInvalidInputMessage() throws Exception {
		this.mockMvc.perform(get("/producecar").param("type","value"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Invalid input.")));
	}

	@Test
	public void returnCabrioMessage() throws Exception {
		this.mockMvc.perform(get("/producecar").param("type","CABRIO"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Cabrio Car has produced.")));
	}

	@Test
	public void returnHatchbackMessage() throws Exception {
		this.mockMvc.perform(get("/producecar").param("type","HATCHBACK"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hatchback Car has produced.")));
	}

	@Test
	public void returnSedanMessage() throws Exception {
		this.mockMvc.perform(get("/producecar").param("type","SEDAN"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Sedan Car has produced.")));
	}

}
