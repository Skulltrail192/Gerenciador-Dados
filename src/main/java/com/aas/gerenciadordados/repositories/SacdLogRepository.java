package com.aas.gerenciadordados.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aas.gerenciadordados.domains.SacdLog;

@Repository
public interface SacdLogRepository extends JpaRepository<SacdLog, Integer> {

	@Query(value = "SELECT log_id, uuid, log_type, tag, creation_date, data FROM SACD_LOG WHERE TAG = 'detran05_renovacao_cnh'"
			+ "AND CREATION_DATE >= TO_TIMESTAMP('08/03/22 00:00:00,000000000','DD/MM/RR HH24:MI:SSXFF')"
			+ "AND CREATION_DATE <= TO_TIMESTAMP('09/03/22 00:00:00,000000000','DD/MM/RR HH24:MI:SSXFF')"
			+ "ORDER BY CREATION_DATE ASC", nativeQuery = true)
//			+ "AND CREATION_DATE >= TO_TIMESTAMP('08/03/22 00:00:00,000000000','DD/MM/RR HH24:MI:SSXFF')\r\n"
//			+ "AND CREATION_DATE <= TO_TIMESTAMP('10/03/22 00:00:00,000000000','DD/MM/RR HH24:MI:SSXFF')\r\n"
//			+ "ORDER BY CREATION_DATE ASC")
	public List<SacdLog> buscarRegistros();

	@Modifying
	//@Modifying(clearAutomatically = true)
	//@Query(value = "UPDATE SACD_LOG sl SET sl.data = :data, WHERE id = :id" , nativeQuery = true)
	@Query(value = "UPDATE SACD_LOG sl SET sl.data = ?1, WHERE id = ?2" , nativeQuery = true)
	//public void updateDataSacdLog(@Param("id") Long id, @Param("data") String campoData );
	public void updateDataSacdLog( String campoData, Long id);
}
