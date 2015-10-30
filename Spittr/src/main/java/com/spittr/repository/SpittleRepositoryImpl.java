package com.spittr.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spittr.domain.Spittle;

public class SpittleRepositoryImpl implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
	List<Spittle> spittles = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			spittles.add(new Spittle("klk this is spittle # " + i , new Date()));
		}
		return spittles;	
	}

}
