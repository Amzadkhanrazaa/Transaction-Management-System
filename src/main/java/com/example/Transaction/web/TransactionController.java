package com.example.Transaction.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Transaction.Dto.BalanceDto;
import com.example.Transaction.Dto.ViewDto;
import com.example.Transaction.Dto.inputDto;
import com.example.Transaction.exception.InputSearchException;
import com.example.Transaction.exception.NotFoundException;

import jakarta.validation.Valid;


@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/create")
	@Transactional(readOnly = false)
	public  ResponseEntity<ViewDto> create(@Valid @RequestBody inputDto input) throws Exception {
		//TODO: process POST request
		ViewDto view = transactionService.create(input);
		return new  ResponseEntity<ViewDto>(view, HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<ViewDto>>getAll(){
		List<ViewDto> getAll =  transactionService.findAllTransaction();
		return new ResponseEntity<List<ViewDto>>(getAll, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ViewDto> getByid(@Valid @PathVariable Long id ) throws NotFoundException{
		ViewDto findbyid = transactionService.getById(id);
		return new ResponseEntity<ViewDto>(findbyid, HttpStatus.OK);
	}
	@GetMapping("/balance")
	public ResponseEntity<BalanceDto> getBalance() throws InputSearchException{
//		return new ResponseEntity<BalanceDto>(new BalanceDto (new BigDecimal(500.00)), HttpStatus.OK);
		
		return new ResponseEntity<BalanceDto>(transactionService.getBalance(), HttpStatus.OK);
	}
	@GetMapping("filter/{minAmount}/{maxAmount}")
	@Transactional(readOnly = true)
	public ResponseEntity<List<ViewDto>> filterTransaction(
			@PathVariable BigDecimal minAmount,
			@PathVariable BigDecimal maxAmount) throws InputSearchException{
		if(minAmount.compareTo(maxAmount)>0) {
			throw new InputSearchException("bad request");
		}
		return new ResponseEntity<List<ViewDto>>(transactionService.filterTransaction(minAmount, maxAmount),HttpStatus.OK);
	}
//	@DeleteMapping("{id}")
//	public ResponseEntity<Void> deletebyId()
}
