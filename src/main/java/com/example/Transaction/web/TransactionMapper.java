package com.example.Transaction.web;

import com.example.Transaction.Dto.ViewDto;
import com.example.Transaction.Entity.Transaction;

public class TransactionMapper {

	public static Transaction toEntity(ViewDto view) {
		if(null == view) return null;
		
		Transaction transaction = new Transaction();
		
		transaction.setId(view.getId());
		transaction.setAmount(view.getAmount());
		transaction.setDescription(view.getDescription());
		transaction.setTitle(view.getTitle());
		transaction.setDate(view.getDate());
		transaction.setType(view.getType());
		
		return transaction;
	}
	public static ViewDto toDto(Transaction transaction) {
		if(null == transaction) return null;
		
		ViewDto viewDto = new ViewDto();
		viewDto.setId(transaction.getId());
		viewDto.setTitle(transaction.getTitle());
		viewDto.setDescription(transaction.getDescription());
		viewDto.setAmount(transaction.getAmount());
		viewDto.setDate(transaction.getDate());
		viewDto.setType(transaction.getType());
		return viewDto;
	}
}
