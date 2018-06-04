package com.nostra.vo;

import java.util.Date;

import lombok.Data;

@Data
public class HistoriTransaksiTempVO {

	private String kdTransaksi;
	private String userFrom;
	private String namaLengkap;
	private String noRekening;
//	private String kdJenisTransaksi;
	private String jenisTransaksi;
	private String amount;
	private String kdBank;
	private String namaBank;
	private String noRekeningTujuan;
	private String userTo;
	private String namaTo;
	private String Keterangan;
	private String createdDate;
	
}
