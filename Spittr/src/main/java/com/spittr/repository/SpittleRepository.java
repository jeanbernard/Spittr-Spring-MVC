package com.spittr.repository;

import java.util.List;

import com.spittr.domain.Spittle;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
}
