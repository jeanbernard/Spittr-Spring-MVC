package com.spittr.test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.spittr.controller.SpittrController;
import com.spittr.domain.Spittle;
import com.spittr.domain.User;
import com.spittr.repository.SpittleRepositoryImpl;
import com.spittr.repository.UserRepositoryImpl;

public class SpittrControllerTest {
	
	@Ignore
	@Test
	public void shouldShowRecentSpittles() throws Exception {
	
		List<Spittle> expectedSpittles = new ArrayList<>();
		
		Spittle spittle1 = new Spittle(1l, "klk this is spittle # " + 14 , new Date());
		Spittle spittle2 = new Spittle(1l, "klk this is spittle # " + 25 , new Date());
		Spittle spittle3 = new Spittle(1l, "klk this is spittle # " + 35 , new Date());
		
		expectedSpittles.add(spittle1);
		expectedSpittles.add(spittle2);
		expectedSpittles.add(spittle3);
		
		SpittleRepositoryImpl mockRepository = mock(SpittleRepositoryImpl.class);
			when(mockRepository.createSpittleList(3)).thenReturn(expectedSpittles);
			
		UserRepositoryImpl userMockRepository = mock(UserRepositoryImpl.class);
			
		SpittrController controller = new SpittrController(mockRepository, userMockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spittles"))
		.andExpect(view().name("redirect:spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
		
	}
	
	@Ignore
	@Test
	public void createSpittle() throws Exception {
		
		Spittle expectedSpittle = new Spittle(1l, "The struggle is real", new Date());
		SpittleRepositoryImpl mockRepository = mock(SpittleRepositoryImpl.class);
			when(mockRepository.createSpittle()).thenReturn(expectedSpittle);
			
		UserRepositoryImpl userMockRepository = mock(UserRepositoryImpl.class);
	
		SpittrController controller = new SpittrController(mockRepository, userMockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spittles"))
		.andExpect(view().name("redirect:spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList", containsString(expectedSpittle.getMessage())));

	}
	
	@Test
	public void shouldShowSingleSpittle() throws Exception {
		
		long spittleId = 1l;
		Spittle expectedSpittle = new Spittle(1l, "First ever Spittle!", new Date());
		SpittleRepositoryImpl mockRepository = mock(SpittleRepositoryImpl.class);
			when(mockRepository.findSpittle(1l)).thenReturn(expectedSpittle);
			
		UserRepositoryImpl userMockRepository = mock(UserRepositoryImpl.class);
			
		SpittrController controller = new SpittrController(mockRepository, userMockRepository);
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittle.jsp")).build();
		mockMvc.perform(get("/spittle/" + spittleId))
		.andExpect(view().name("spittle"))
		.andExpect(model().attributeExists("spittleId"))
		.andExpect(model().attribute("spittleId", expectedSpittle));
	
	}
	
	@Test
	public void shouldShowRegistration() throws Exception {
		
		SpittrController spittrController = new SpittrController();
		MockMvc mock = standaloneSetup(spittrController).build();
		
		mock.perform(get("/register"))
		.andExpect(view().name("registerForm"));
		
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		
		SpittleRepositoryImpl mockSpittleRepo = mock(SpittleRepositoryImpl.class);
		UserRepositoryImpl mockUserRepo = mock(UserRepositoryImpl.class);
		
		User unsavedUser = new User("jjbernard", "1234", "Jean", "Bernard");
		User savedUser = new User(7L,"jjbernard", "1234", "Jean", "Bernard");
		when(mockUserRepo.saveUser(unsavedUser)).thenReturn(savedUser);		
		
		SpittrController spittrController = new SpittrController(mockSpittleRepo, mockUserRepo);
		MockMvc mock = standaloneSetup(spittrController).build();
		mock.perform(post("/register")
				.param("firstName", "Jean")
				.param("lastName", "Bernard")
				.param("username", "jjbernard")
				.param("password", "1234"))
		.andExpect(redirectedUrl("/register/jjbernard"));
		
	}

}
