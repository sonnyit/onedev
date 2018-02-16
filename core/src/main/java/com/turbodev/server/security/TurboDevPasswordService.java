package com.turbodev.server.security;

import javax.inject.Singleton;

import org.apache.shiro.authc.credential.PasswordService;

import com.turbodev.utils.StringUtils;
import com.pmease.security.shiro.bcrypt.BCryptPasswordService;

@Singleton
public class TurboDevPasswordService implements PasswordService {

	private final PasswordService bcryptPasswordService = new BCryptPasswordService();
	
	@Override
	public String encryptPassword(Object plaintextPassword) throws IllegalArgumentException {
		return bcryptPasswordService.encryptPassword(plaintextPassword);
	}

	@Override
	public boolean passwordsMatch(Object submittedPlaintext, String encrypted) {
		if (StringUtils.isNotBlank(encrypted))
			return bcryptPasswordService.passwordsMatch(submittedPlaintext, encrypted);
		else
			return true;
	}

}