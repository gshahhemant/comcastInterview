package com.helloworld;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import javax.ws.rs.core.MediaType;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes =HelloworldApplication.class
		)
@AutoConfigureMockMvc
public class HelloworldApplicationITTests {
/*
	@Autowired
	MockMvc  mockMvc;

	@Test
	public void  getAllAppsTest() throws Exception {

		mockMvc.perform(get("/apps/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)));

	}

	@Test
	public void getAppTest() throws Exception {


		mockMvc.perform(get("/apps/20/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());


		mockMvc.perform(get("/apps/-1/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());


		mockMvc.perform(get("/apps/1/")
				.contentType(MediaType.APPLICATION_JSON))

		.andExpect(status().isOk())
		.andExpect(jsonPath("$.appId", is(1)));

	}

	@Test
	public void createAppAndDelete() throws Exception {

		AppInfo appInfo = new AppInfo("testApp","publisherName","publisherCompanyName",2 ,3,4 ,"shortDescription","longDescription");



		mockMvc.perform(post("/apps/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(appInfo)))
		.andExpect(status().isOk());

		mockMvc.perform(delete("/apps/2/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());


		AppInfo appInfoMissinngFileds = new AppInfo(null,"publisherName","publisherCompanyName",2 ,3,4 ,"shortDescription","longDescription");

		mockMvc.perform(post("/apps/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(appInfoMissinngFileds)))
		.andExpect(status().isBadRequest());

	}
	@Test
	public void updateApp() throws Exception {

		AppInfo appInfo = new AppInfo("updatedtest","updatepublisherName","publisherCompanyName",2 ,3,4 ,"shortDescription","longDescription");


		mockMvc.perform(put("/apps/1/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(appInfo)))
		.andExpect(status().isOk());

		AppInfo appInfoMissinngFileds = new AppInfo(null,"publisherName","publisherCompanyName",2 ,3,4 ,"shortDescription","longDescription");
		// Testing with bad Data
		mockMvc.perform(put("/apps/1/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(appInfoMissinngFileds)))
		.andExpect(status().isBadRequest());


	}
	*/

}
