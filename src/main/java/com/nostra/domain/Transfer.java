package com.nostra.domain;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "transfer" )
@DynamicUpdate
@Data
public class Transfer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
	private String id;
	
	@Column(name = "user_from")
	private String userFrom;
	
	@Column(name = "no_rekening")
	private String noRekening;
	
	@Column(name = "kd_jenis_transaksi")
	private String kdJenisTransaksi;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "kd_bank")
	private String kdBank;
	
	@Column(name = "no_rekening_tujuan")
	private String noRekeningTujuan;
	
	@Column(name = "user_to")
	private String userTo;
	
	@Column(name = "keterangan")
	private String keterangan;
	
	@Column(name = "created_date")
	private Date createdDate;
}
