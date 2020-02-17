package br.com.segnum.api.services.helpers;

import br.com.segnum.api.domain.User;
import br.com.segnum.api.repositories.UserRepository;
import br.com.segnum.api.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(email);
		} else {
			return new UserSS(user.getId(), user.getEmail(), user.getPassword(), user.getProfiles());
		}
	}

}
