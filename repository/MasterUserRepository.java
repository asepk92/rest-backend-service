package com.nostra.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nostra.domain.MasterUser;



@Repository
public interface MasterUserRepository extends JpaRepository<MasterUser, Long> {

//	Page<MasterUser> findByNama(String nama, Pageable pageable);
//	Page<MasterUser> findByEmail(String email, Pageable pageable);
	
	MasterUser findByNama(String nama);
	MasterUser findByEmail(String email);
	
}
