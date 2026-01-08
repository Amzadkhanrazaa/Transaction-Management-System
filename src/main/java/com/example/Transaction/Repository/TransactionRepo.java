package com.example.Transaction.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Transaction.Entity.Transaction;

@Repository
public interface TransactionRepo  extends JpaRepository<Transaction, Long>{

	@Query("select t from Transaction t "
			+ "order by t.date asc , t.id asc")
	List<Transaction> findAllorderByDateAscIdAsc();
}
