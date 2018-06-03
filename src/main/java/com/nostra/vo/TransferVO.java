package com.nostra.vo;

import lombok.Data;

@Data
public class TransferVO {

	private String id;
	private String userFrom;
	private String noRekening;
	private String kdJenisTransaksi;
	private String amount;
	private String kdBank;
	private String noRekeningTujuan;
	private String userTo;
	private String Keterangan;
	private String createdDate;
	
}
