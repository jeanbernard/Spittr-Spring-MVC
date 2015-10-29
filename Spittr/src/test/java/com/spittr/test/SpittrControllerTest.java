package com.spittr.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.spittr.domain.Spittle;
import com.spittr.repository.SpittleRepository;
import org.mockito.*;

public class SpittrControllerTest {
	
	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		
	}
	
	private List<Spittle> createSpittleList(int count) {
		
		List<Spittle> spittles = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			spittles.add(new Spittle("klk this is spittle # " + i , new Date()));
		}
		
		return spittles;
	}

}
