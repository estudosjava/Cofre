package br.com.cofrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cofrinho.dao.UserTypeDAO;
import br.com.cofrinho.model.UserType;

@Service
@Transactional
public class UserTypeService {
	@Autowired
	private UserTypeDAO userTypeDAO;
	
	public UserType getUserType(String userTypeCode ) {
		return userTypeDAO.getUserType(userTypeCode);
	}
	
	public List<UserType> getUserTypes() {
		return userTypeDAO.getUserTypes();
	}
}
