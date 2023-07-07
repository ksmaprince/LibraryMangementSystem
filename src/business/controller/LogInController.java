package business.controller;

import business.usecase.ILogIn;
import dataaccess.Auth;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import business.exception.LoginException;
import dataaccess.repository.child.UserRepository;

public class LogInController extends BaseController implements ILogIn {
	LogInController() {
	}

	public static Auth currentAuth = null;

	@Override
	public Auth login(String id, String password) throws LoginException {
		UserRepository userRepo = new UserRepository(new DataAccessFacade());

		User user = userRepo.login(id,password);
		User.updateCurrentUser(user);

		currentAuth = user.getAuthorization();
		return currentAuth;

	}

}
