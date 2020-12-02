package com.example.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.example.atmloc.dto.AppUser;

public class CustomJdbcUserDetailManager extends JdbcUserDetailsManager {

	@Override
	public UserDetails loadUserByUsername(String username) {
		List<AppUser> users = super.getJdbcTemplate().query(
				"select username,password,enabled, firstname, lastname from users where username = ?",
				new String[] { username }, new RowMapper<AppUser>() {
					@Override
					public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
						String username = rs.getString(1);
						String password = rs.getString(2);
						boolean enabled = rs.getBoolean(3);
						String fn = rs.getString(4);
						String ln = rs.getString(5);
						AppUser currentUser = new AppUser(username, password, enabled, true, true, true,
								AuthorityUtils.NO_AUTHORITIES);
						currentUser.setFirstName(fn);
						currentUser.setLastName(ln);
						return currentUser;
					}

				});

		AppUser user = users.get(0); // contains no GrantedAuthority[]
		Set<GrantedAuthority> dbAuthsSet = new HashSet<>();

		dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));
		dbAuthsSet.addAll(loadGroupAuthorities(user.getUsername()));

		List<GrantedAuthority> dbAuths = new ArrayList<>(dbAuthsSet);
		addCustomAuthorities(user.getUsername(), dbAuths);
		AppUser customAppUser = new AppUser(user.getUsername(), user.getPassword(), user.isEnabled(), user.isEnabled(),
				user.isEnabled(), user.isEnabled(), dbAuths);
		customAppUser.setFirstName(user.getFirstName());
		customAppUser.setLastName(user.getLastName());
		customAppUser.setIsAdmin(dbAuthsSet.stream().filter(t -> t.getAuthority().equals("ROLE_ADMIN")).count() > 0);
		return customAppUser;
	}

}
