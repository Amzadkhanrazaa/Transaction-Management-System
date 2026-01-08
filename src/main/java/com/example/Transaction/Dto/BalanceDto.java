package com.example.Transaction.Dto;

import java.math.BigDecimal;

public class BalanceDto {

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BalanceDto(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	public BalanceDto() {
		super();
	}
	
}
