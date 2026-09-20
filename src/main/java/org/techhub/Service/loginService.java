package org.techhub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.Model.LoginModel;
import org.techhub.Repository.loginRepo;

@Service
public class loginService {
	@Autowired
	loginRepo repo;
  public LoginModel isVerifyUser(LoginModel model) {
	  return repo.isVerifyUser(model);
  }

}
