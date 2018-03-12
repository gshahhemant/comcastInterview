package com.helloworld;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helloworld.model.CustomerInfo;
import com.helloworld.model.Transaction;



@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes =HelloworldApplication.class
		)
@AutoConfigureMockMvc
public class HelloworldApplicationITTests {

	@Autowired
	MockMvc  mockMvc;

	@Test
	public void  getAllCustomersTest() throws Exception {

		mockMvc.perform(get("/customers/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)));

	}

	@Test
	public void getCustomerTest() throws Exception {


		mockMvc.perform(get("/customer/20")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());

		mockMvc.perform(get("/customer/1")
				.contentType(MediaType.APPLICATION_JSON))

		.andExpect(status().isOk())
		.andExpect(jsonPath("$.customberId", is(1)));

	}

	@Test
	public void createCustomerTest() throws Exception {

		CustomerInfo customerInfo = new CustomerInfo("testFirstName","testLastName","testAddress",1231231231);



		mockMvc.perform(post("/customer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customerInfo)))
		.andExpect(status().isOk());

		mockMvc.perform(delete("/customer/3")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());


		CustomerInfo customerInfoBankFileds = new CustomerInfo("","","testAddress",1231231231);

		mockMvc.perform(post("/customer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customerInfoBankFileds)))
		.andExpect(status().isBadRequest());

	}

	@Test
	public void updateCustomerTest() throws Exception {

		CustomerInfo customerInfo = new CustomerInfo("testFirstName","testLastName","testAddress",1231231231);

		mockMvc.perform(put("/customer/1/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customerInfo)))
		.andExpect(status().isOk());

		CustomerInfo customerInfoMissinngFileds = new  CustomerInfo("","","testAddress",1231231231);
		// Testing with bad Data
		mockMvc.perform(put("/customer/1/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customerInfoMissinngFileds)))
		.andExpect(status().isBadRequest());

	}

	@Test
	public void addTransactionTest() throws Exception {

		Transaction transaction = new Transaction("Fuel",100);

		mockMvc.perform(post("/customer/1/transaction")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(transaction)))
		.andExpect(status().isOk());

		Transaction transactionMissingFields= new Transaction("",25);
		// Testing with bad Data
		mockMvc.perform(post("/customer/1/transaction")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(transactionMissingFields)))
		.andExpect(status().isBadRequest());

	}

	@Test
	public void updateTransactionTest() throws Exception {

		Transaction transaction = new Transaction("Cigarate",25);

		mockMvc.perform(put("/customer/transaction/2/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(transaction)))
		.andExpect(status().isOk());

		Transaction transactionMissingFields= new Transaction("",25);
		// Testing with bad Data
		mockMvc.perform(put("/customer/transaction/2/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(transactionMissingFields)))
		.andExpect(status().isBadRequest());
	}

	@Test
	public void deleteCustomerTest() throws Exception {

		CustomerInfo customerInfo = new CustomerInfo("testFirstName","testLastName","testAddress",1231231231);

		mockMvc.perform(post("/customer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customerInfo)))
		.andExpect(status().isOk());

		mockMvc.perform(delete("/customer/4")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());

		// Testing with bad Data
		mockMvc.perform(delete("/customer/30/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}


	@Test
	public void deleteTransactionTest() throws Exception {

		mockMvc.perform(delete("/customer/transaction/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());

		// Testing with bad Data
		mockMvc.perform(delete("/customer/transaction/200/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}

}


