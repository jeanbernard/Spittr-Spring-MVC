package com.spittr.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spittr.domain.Spittle;

public class SpittleRepositoryImpl implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return null;
	}

	@Override
	public Spittle createSpittle() {
		
		Spittle spittle = new Spittle(1l,"The struggle is real", new Date());
		
		return spittle;
	}

	@Override
	public List<Spittle> createSpittleList(int count) {
		
		List<Spittle> spittles = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			spittles.add(new Spittle(1l, "klk this is spittle # " + i , new Date()));
		}
		
		return spittles;	
		
	}

	@Override
	public Spittle findSpittle(long spittleId) {
		
		Spittle spittle = new Spittle(spittleId, "First ever Spittle!", new Date());
		
		return spittle;
	}
	

}
