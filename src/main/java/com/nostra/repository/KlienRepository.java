package com.nostra.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nostra.domain.Klien;




@Repository
public interface KlienRepository extends JpaRepository<Klien, Long> {

	Klien findByIdKlien (String idKlien);
	
	Klien findByNoRekening (String noRekening);
	
	
}
