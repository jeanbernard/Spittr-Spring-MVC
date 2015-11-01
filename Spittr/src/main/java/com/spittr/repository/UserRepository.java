package com.spittr.repository;

import com.spittr.domain.User;

public interface UserRepository {
	
	public User saveUser(User user);
	public User findUser(long userId);

}
