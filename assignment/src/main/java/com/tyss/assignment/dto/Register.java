package com.tyss.assignment.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Register implements Serializable {
	@Id
	@Column
	private String username;

	@Column
	private String password;
	@Column
	private String confirmpassword;

}
