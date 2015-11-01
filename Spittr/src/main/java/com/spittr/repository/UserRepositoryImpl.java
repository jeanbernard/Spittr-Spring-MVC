package com.spittr.repository;

import com.spittr.domain.User;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public User saveUser(User user) {
		return user;
	}

	@Override
	public User findUser(long userId) {
		
		User foundUser = new User("jjbernard", "1234", "Jean", "Bernard");
		
		return foundUser;
	}

}
