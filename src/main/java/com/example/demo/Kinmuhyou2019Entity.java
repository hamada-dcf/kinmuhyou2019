package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class Kinmuhyou2019Entity  implements Serializable{
	
	
	/**
	 * serialVersionUIDは自動生成する
	 */
	private static final long serialVersionUID = 7970927090882492708L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "mailaddress")
	private String mailaddress;
	
	@Column(name = "password")
	private String password;
}