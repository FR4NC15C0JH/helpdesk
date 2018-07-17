package com.aulaangular5.helpdesk.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.aulaangular5.helpdesk.api.Enumerator.ProfileEnum;
import com.aulaangular5.helpdesk.api.entity.User;

public class JwtUserFactory {
	
	private JwtUserFactory() {
		
	}
	/**
	 * Converter um jwtUser com dados do User
	 * @param user
	 * @return
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getProfile()));
	}
	/**
	 * Converter perfil User para ser usado no spring security
	 * @param profile
	 * @return
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profile) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profile.toString()));
		return null;
	}
}
