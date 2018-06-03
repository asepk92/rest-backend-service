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
@Table(name = "master_bank" )
@DynamicUpdate
@Data
public class MasterBank implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kd_bank",unique=true, nullable = false)
	private String kdBank;
	
	@Column(name = "nama_bank")
	private String namaBank;
	
}
