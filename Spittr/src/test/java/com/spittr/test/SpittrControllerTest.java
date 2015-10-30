package com.spittr.test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.spittr.controller.SpittrController;
import com.spittr.domain.Spittle;
import com.spittr.repository.SpittleRepositoryImpl;

public class SpittrControllerTest {
	
	@Test
	public void shouldShowRecentSpittles() throws Exception {
	
		List<Spittle> expectedSpittles = new ArrayList<>();
		
		Spittle spittle1 = new Spittle("klk this is spittle # " + 14 , new Date());
		Spittle spittle2 = new Spittle("klk this is spittle # " + 25 , new Date());
		Spittle spittle3 = new Spittle("klk this is spittle # " + 35 , new Date());
		
		expectedSpittles.add(spittle1);
		expectedSpittles.add(spittle2);
		expectedSpittles.add(spittle3);
		
		SpittleRepositoryImpl mockRepository = mock(SpittleRepositoryImpl.class);
			when(mockRepository.createSpittleList(3)).thenReturn(expectedSpittles);
			
		SpittrController controller = new SpittrController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spittles"))
		.andExpect(view().name("redirect:spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
		
	}
	
	@Test
	public void createSpittle() throws Exception {
		
		Spittle expectedSpittle = new Spittle("The struggle is real", new Date());
		SpittleRepositoryImpl mockRepository = mock(SpittleRepositoryImpl.class);
			when(mockRepository.createSpittle()).thenReturn(expectedSpittle);
	
		SpittrController controller = new SpittrController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spittles"))
		.andExpect(view().name("redirect:spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList", containsString(expectedSpittle.getMessage())));

	}
	
	

}
