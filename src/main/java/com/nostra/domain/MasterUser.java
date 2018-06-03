package com.nostra.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


import lombok.Data;

@Entity
@Table(name = "master_user" )
@DynamicUpdate
@Data
public class MasterUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user",unique=true, nullable = false)
	private String idUser;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "no_hp")
	private String noHp;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "username")
	private String username;
}
