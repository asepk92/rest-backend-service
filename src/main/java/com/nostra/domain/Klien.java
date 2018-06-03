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
@Table(name = "klien" )
@DynamicUpdate
@Data
public class Klien implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_klien",unique=true, nullable = false)
	private String idKlien;
	
	@Column(name = "nama_lengkap")
	private String namaLengkap;
	
	@Column(name = "tempat_lahir")
	private String tempatLahir;
	
	@Column(name = "tgl_lahir")
	private String tglLahir;
	
	@Column(name = "no_rekening")
	private String noRekening;
	
	@Column(name = "saldo")
	private String saldo;
	
	@Column(name = "alamat")
	private String alamat;
}
