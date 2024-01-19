package com.generation.app.dto;

import com.generation.app.entity.Privilege;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
	
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private Privilege privilege;
	
	private String token;

}
