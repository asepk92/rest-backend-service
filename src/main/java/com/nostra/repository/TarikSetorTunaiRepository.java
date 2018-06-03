package com.nostra.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nostra.domain.TarikSetorTunai;



@Repository
public interface TarikSetorTunaiRepository extends JpaRepository<TarikSetorTunai, Long> {


	
	
}
