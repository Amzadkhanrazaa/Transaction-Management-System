package com.example.Transaction.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class inputDto {

	private String title;
	private BigDecimal amount;
	private LocalDate date;
	private String description;
	private String type;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public inputDto(String title, BigDecimal amount, LocalDate date, String description, String type) {

		this.title = title;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.type= type;
	}
	public inputDto() {

	}
	
}
