package com.nostra.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.nostra.converter.TarikSetorTunaiVOConverter;
import com.nostra.domain.HistoriTransaksi;
import com.nostra.domain.Klien;
import com.nostra.domain.TarikSetorTunai;

import com.nostra.repository.HistoriTransaksiRepository;
import com.nostra.repository.KlienRepository;
import com.nostra.repository.TarikSetorTunaiRepository;

import com.nostra.util.NostraDateUtil;
import com.nostra.vo.TarikSetorTunaiVO;

import java.math.BigDecimal;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.transaction.Transactional;

@Service
public class TarikSetorTunaiService {

	@Autowired
	TarikSetorTunaiRepository tarikSetorTunaiRepository;
	
	@Autowired
	KlienRepository klienRepository;
	
	@Autowired
	HistoriTransaksiRepository historiTransaksiRepository;

	@Autowired
	TarikSetorTunaiVOConverter tarikSetorTunaiVOConverter;
	
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
	public Boolean tarikSetorTunai(TarikSetorTunaiVO vo){
		
		TarikSetorTunai tarikSetorTunai = new TarikSetorTunai();
		HistoriTransaksi historiTransaksi = new HistoriTransaksi();
		String saldo ="";
		String saldoAfter="";
		Klien klien = klienRepository.findByNoRekening(vo.getNoRekening());
		
		if(klien != null){
			// Deposit
			if(vo.getKdJenisTransaksi().equals("1")){
				
				tarikSetorTunai = tarikSetorTunaiVOConverter.transferVOToModel(vo, null);
				tarikSetorTunai.setCreatedDate(NostraDateUtil.getToday());
				tarikSetorTunaiRepository.save(tarikSetorTunai);
				
				historiTransaksi.setUserFrom(vo.getIdKlien());
				historiTransaksi.setNoRekening(vo.getNoRekening());
				historiTransaksi.setKdJenisTransaksi(vo.getKdJenisTransaksi());
				historiTransaksi.setAmount(vo.getAmount());
				historiTransaksi.setCreatedDate(NostraDateUtil.getToday());
				historiTransaksiRepository.save(historiTransaksi);
				
				saldo = klien.getSaldo() + "-" + vo.getAmount();
				BigDecimal biaya = hitung(saldo);
				saldoAfter = String.format("%.0f", biaya);
				klien.setSaldo(saldoAfter);
				klienRepository.save(klien);
				
				
				
			// Withdrawal	
			} else if (vo.getKdJenisTransaksi().equals("2")) {
				tarikSetorTunai = tarikSetorTunaiVOConverter.transferVOToModel(vo, null);
				tarikSetorTunai.setCreatedDate(NostraDateUtil.getToday());
				tarikSetorTunaiRepository.save(tarikSetorTunai);
				
				historiTransaksi.setUserFrom(vo.getIdKlien());
				historiTransaksi.setNoRekening(vo.getNoRekening());
				historiTransaksi.setKdJenisTransaksi(vo.getKdJenisTransaksi());
				historiTransaksi.setAmount(vo.getAmount());
				historiTransaksi.setCreatedDate(NostraDateUtil.getToday());
				historiTransaksiRepository.save(historiTransaksi);
				
				saldo = klien.getSaldo() + "+" + vo.getAmount();
				BigDecimal biaya = hitung(saldo);
				saldoAfter = String.format("%.0f", biaya);
				klien.setSaldo(saldoAfter);
				klienRepository.save(klien);
			}
			
		}
		
		return Boolean.TRUE;
		
		
		
	}
	

}
