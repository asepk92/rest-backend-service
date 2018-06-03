package com.nostra.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.nostra.domain.HistoriTransaksi;



@Repository
public interface HistoriTransaksiRepository extends JpaRepository<HistoriTransaksi, Long> {

	
	Page<HistoriTransaksi> findByUserFrom(String userFrom, Pageable pageable);
	Page<HistoriTransaksi> findByNoRekening(String noRekening, Pageable pageable);
	Page<HistoriTransaksi> findByUserFromAndNoRekening(String userFrom, String noRekening, Pageable pageable);
	
	
}
