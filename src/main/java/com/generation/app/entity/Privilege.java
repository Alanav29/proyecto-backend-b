package com.generation.app.entity;

import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="Privileges")
public class Privilege {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name="id_privilege")
	private Long id;
	@Column(name="privilege", nullable=false, length=45)
	private String privilege;
	
	public Privilege(String privilege) {
		this.privilege = privilege;
	}
}

