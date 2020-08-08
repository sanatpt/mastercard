package com.mastercard;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AssignmentTest 
{


	@Autowired
	private MockMvc mockMvc;
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void checkConnected() throws Exception {
		this.mockMvc.perform(get("/connected?origin=Boston&destination=Newark")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("yes")));
	}
	
	@Test
	public void checkReverseConnected() throws Exception {
		this.mockMvc.perform(get("/connected?origin=Newark&destination=Boston")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("yes")));
	}
	
	@Test
	public void checkNotConnected() throws Exception {
		this.mockMvc.perform(get("/connected?origin=Boston&destination=Albany")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("no")));
	}
	
	@Test
	public void checkNullOrigin() throws Exception {
		this.mockMvc.perform(get("/connected?origin=&destination=Albany")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("no")));
	}
	
	@Test
	public void checkNullDestination() throws Exception {
		this.mockMvc.perform(get("/connected?origin=Albany&destination=")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("no")));
	}

}