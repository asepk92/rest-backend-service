package com.nostra.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.nostra.converter.TransferVOConverter;
import com.nostra.domain.HistoriTransaksi;
import com.nostra.domain.Klien;

import com.nostra.domain.Transfer;

import com.nostra.repository.HistoriTransaksiRepository;
import com.nostra.repository.KlienRepository;

import com.nostra.repository.TransferRepository;
import com.nostra.util.NostraDateUtil;
import com.nostra.vo.TransferVO;

import java.math.BigDecimal;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.transaction.Transactional;

@Service
public class TransferService {

	@Autowired
	TransferRepository transferRepository;
	
	@Autowired
	KlienRepository klienRepository;
	
	@Autowired
	HistoriTransaksiRepository historiTransaksiRepository;

	@Autowired
	TransferVOConverter transferVOConverter;
	
	public BigDecimal hitung(String input) {
        BigDecimal hasil = null;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            hasil = new BigDecimal(engine.eval(input).toString());

        } catch (ScriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hasil;
    }
	
	@Transactional
	public Boolean transfer(TransferVO vo){
		
		Transfer transfer = new Transfer();
		HistoriTransaksi historiTransaksi = new HistoriTransaksi();
		String saldo ="";
		String saldoAfter="";
		String feeCharge="6500";
		Klien klien = klienRepository.findByNoRekening(vo.getNoRekening());
		
		if(klien != null){
			// Transfer Antar Rekening
			if(vo.getKdJenisTransaksi().equals("3")){
				
				transfer = transferVOConverter.transferVOToModel(vo, null);
				transfer.setCreatedDate(NostraDateUtil.getToday());
				transferRepository.save(transfer);
				
				historiTransaksi.setUserFrom(vo.getUserFrom());
				historiTransaksi.setNoRekening(vo.getNoRekening());
				historiTransaksi.setKdJenisTransaksi(vo.getKdJenisTransaksi());
				historiTransaksi.setAmount(vo.getAmount());
				historiTransaksi.setKdBank(vo.getKdBank());
				historiTransaksi.setNoRekeningTujuan(vo.getNoRekeningTujuan());
				historiTransaksi.setUserTo(vo.getUserTo());
				historiTransaksi.setKeterangan(vo.getKeterangan());
				historiTransaksi.setCreatedDate(NostraDateUtil.getToday());
				historiTransaksiRepository.save(historiTransaksi);
				
				saldo = klien.getSaldo() + "-" + vo.getAmount();
				BigDecimal biaya = hitung(saldo);
				saldoAfter = String.format("%.0f", biaya);
				klien.setSaldo(saldoAfter);
				klienRepository.save(klien);
				
				
				
			// Transfer Antar Bank	
			} else if (vo.getKdJenisTransaksi().equals("4")) {
				transfer = transferVOConverter.transferVOToModel(vo, null);
				transfer.setCreatedDate(NostraDateUtil.getToday());
				transferRepository.save(transfer);
				
				historiTransaksi.setUserFrom(vo.getUserFrom());
				historiTransaksi.setNoRekening(vo.getNoRekening());
				historiTransaksi.setKdJenisTransaksi(vo.getKdJenisTransaksi());
				historiTransaksi.setAmount(vo.getAmount());
				historiTransaksi.setKdBank(vo.getKdBank());
				historiTransaksi.setNoRekeningTujuan(vo.getNoRekeningTujuan());
				historiTransaksi.setUserTo(vo.getUserTo());
				historiTransaksi.setKeterangan(vo.getKeterangan());
				historiTransaksi.setCreatedDate(NostraDateUtil.getToday());
				historiTransaksiRepository.save(historiTransaksi);
				
				saldo = klien.getSaldo() + "-" + vo.getAmount() + "-" + feeCharge;
				BigDecimal biaya = hitung(saldo);
				saldoAfter = String.format("%.0f", biaya);
				klien.setSaldo(saldoAfter);
				klienRepository.save(klien);
			}
			
		}
		
		return Boolean.TRUE;
		
		
		
	}
	

}
