package com.generation.app.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="users")
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name", nullable=false, length=45)
	private String firstName;
	@Column(name="last_name", nullable=false, length=45)	
	private String lastName;
	@Column(name="email", nullable=false, length=35, unique=true)
	private String email;
	@Column(name="password", nullable=false, length=300)
	private String password;
	@Column(name="phone", nullable=true, length=45)
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="fk_privilege", nullable=false)
	private Privilege privilege;

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((privilege.getPrivilege().toUpperCase())));
    }

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}

