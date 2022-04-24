package com.example.demo.Models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails {
	//implements UserDetails
/*	 private String username;
	    private String password;
	    private boolean active;
	    private List<GrantedAuthority> authorities;

	    public MyUserDetails(User user) {
	        this.setUsername(user.getUsername());
	        this.setPassword(user.getPassword());
	      //  this.active = user.isActive();
	     //   this.authorities = Arrays.stream(user.getRole())
	         //           .map(SimpleGrantedAuthority::new)
	         //           .collect(Collectors.toList());
	    }




	  
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return active;
	    }

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getUsername() {
			return username;
		}
	
		public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}


		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}
*/
}
