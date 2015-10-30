package com.spittr.repository;

import java.util.List;

import com.spittr.domain.Spittle;


public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
	Spittle findSpittle(long spittleId);
	Spittle createSpittle();
	List<Spittle> createSpittleList(int count);
}
