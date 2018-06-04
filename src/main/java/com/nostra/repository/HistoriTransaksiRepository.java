package com.nostra.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.nostra.domain.HistoriTransaksi;



@Repository
public interface HistoriTransaksiRepository extends JpaRepository<HistoriTransaksi, Long> {

	
	Page<HistoriTransaksi> findByUserFrom(String userFrom, Pageable pageable);
	Page<HistoriTransaksi> findByNoRekening(String noRekening, Pageable pageable);
	Page<HistoriTransaksi> findByUserFromAndNoRekening(String userFrom, String noRekening, Pageable pageable);
	
	
	@Query(value = "SELECT ht.kd_transaksi, ht.user_from, k.nama_lengkap, ht.no_rekening, jt.jenis_transaksi, ht.amount, ht.kd_bank, mb.nama_bank, ht.no_rekening_tujuan, ht.user_to, "
			+ "kl.nama_lengkap as nama, ht.keterangan, ht.created_date " 
			+ "FROM histori_transaksi ht "
			+ "LEFT JOIN klien k on ht.user_from = k.id_user "
			+ "LEFT JOIN jenis_transaksi jt on ht.kd_jenis_transaksi = jt.kd_jenis_transaksi "
			+ "LEFT JOIN master_bank mb on ht.kd_bank = mb.kd_bank " + "LEFT JOIN klien kl on ht.user_to = kl.id_user "
			+ "WHERE k.nama_lengkap = :nama OR ht.no_rekening = :noRekening ", nativeQuery = true)
	String[] findByUserFromAndNoRekeningNative(@Param("nama") String nama, @Param("noRekening") String noRekening);

	@Query(value = "SELECT ht.kd_transaksi, ht.user_from, k.nama_lengkap, ht.no_rekening, jt.jenis_transaksi, ht.amount, ht.kd_bank, mb.nama_bank, ht.no_rekening_tujuan, ht.user_to, "
			+ "kl.nama_lengkap as nama, ht.keterangan, ht.created_date " 
			+ "FROM histori_transaksi ht "
			+ "LEFT JOIN klien k on ht.user_from = k.id_user "
			+ "LEFT JOIN jenis_transaksi jt on ht.kd_jenis_transaksi = jt.kd_jenis_transaksi "
			+ "LEFT JOIN master_bank mb on ht.kd_bank = mb.kd_bank "
			+ "LEFT JOIN klien kl on ht.user_to = kl.id_user ", nativeQuery = true)
	String[] findAllNative();
	
	
}
