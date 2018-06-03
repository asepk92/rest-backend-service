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
@Table(name = "jenis_transaksi" )
@DynamicUpdate
@Data
public class JenisTransaksi implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kd_jenis_transaksi",unique=true, nullable = false)
	private String kdJenisTransaksi;
	
	@Column(name = "jenisTransaksi")
	private String jenisTransaksi;
	
}
