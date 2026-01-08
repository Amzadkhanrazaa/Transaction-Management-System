package com.example.Transaction.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Transaction.Dto.BalanceDto;
import com.example.Transaction.Dto.ViewDto;
import com.example.Transaction.Dto.inputDto;
import com.example.Transaction.Entity.Transaction;
import com.example.Transaction.Repository.TransactionRepo;
import com.example.Transaction.exception.InputSearchException;
import com.example.Transaction.exception.NotFoundException;

@Service
public class TransactionService {

    
	
	private final TransactionRepo transactionRepo;

	public TransactionService(TransactionRepo transactionRepo) {
		this.transactionRepo = transactionRepo;

	}
	
	public ViewDto create (inputDto input) throws InputSearchException {
		if( null == input ) throw new InputSearchException("not valid input");
		Transaction transaction = new Transaction();
		transaction.setAmount(input.getAmount());
		transaction.setDate(input.getDate());
		transaction.setTitle(input.getTitle());
		transaction.setDescription(input.getDescription());
		transaction.setType(input.getType());
//		transaction.setAmount(input.getAmount());
		Transaction savedTransaction = transactionRepo.save(transaction);
		ViewDto viewDto = TransactionMapper.toDto(savedTransaction);
		return viewDto;
	}
	public List<ViewDto> findAllTransaction(){
		List<Transaction> transaction = new ArrayList<>();
		List<ViewDto> viewDtoList  = new ArrayList<>();
		transaction = transactionRepo.findAll();
		for (Transaction t : transaction) {
			viewDtoList.add(TransactionMapper.toDto(t));
		}
		return viewDtoList;
	}
	
	public ViewDto getById(Long id ) throws NotFoundException{
		Transaction t = transactionRepo.findById(id).orElse(null);
		if(null == t) {
			throw new NotFoundException("Transaction id :"+ id + "not found");
		}
		return TransactionMapper.toDto(t);
	}
	
	public BalanceDto getBalance() throws InputSearchException {
		List<Transaction>transaction = new ArrayList<>();
		transaction = transactionRepo.findAll();
		BigDecimal income = new BigDecimal(0);
		BigDecimal expense = new BigDecimal(0);
		for (Transaction t :transaction) {
			if(t.getType().equals("Income")) {
				income.add(t.getAmount());
			}
			if(t.getType().equals("Expense")) {
				expense.add(t.getAmount());
			}
		}
		if(expense.compareTo(income)>0) {
			throw new InputSearchException("bad Request");
		}
		return new BalanceDto(income.subtract(expense));
	}
	
	public List<ViewDto> filterTransaction(BigDecimal minAmount, BigDecimal maxAmount) throws NotFoundException{
		List <Transaction> transaction = new ArrayList<>();
		List<ViewDto> viewDtoList = new ArrayList<>();
		transaction = transactionRepo.findAll();
		for(Transaction t : transaction) {
			if(t.getAmount().compareTo(maxAmount)<0 &&
					t.getAmount().compareTo(minAmount)>0) {
				viewDtoList.add(TransactionMapper.toDto(t));
			}
		}
		if(viewDtoList.isEmpty()) {
			throw new NotFoundException("not found");
		}
		return viewDtoList;
	}
	
}
