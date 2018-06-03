package com.nostra.vo;

import java.util.Date;

import lombok.Data;

@Data
public class HistoriTransaksiVO {

	private String kdTransaksi;
	private String userFrom;
	private String noRekening;
	private String kdJenisTransaksi;
	private String amount;
	private String kdBank;
	private String noRekeningTujuan;
	private String userTo;
	private String Keterangan;
	private Date createdDate;
	
}
