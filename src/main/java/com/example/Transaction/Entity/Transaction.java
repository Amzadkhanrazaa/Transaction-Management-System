package com.example.Transaction.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Type is required")
	@Pattern(regexp = "Income|expense", message = "type must be income or expense")
	private String type;

	@NotBlank(message = "title can not be blank")
	private String title;

	@DecimalMin(value = "0.01", message = "Amount must be greater than zero")
	private BigDecimal amount;

	@NotNull
	@PastOrPresent(message = "date cannot be in the future")
	@JsonFormat(pattern = "yyyy-MM-dd") // controls JSON -> LocalDate parsing
	private LocalDate date;

	@Column(nullable = false)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	
	public Transaction(Long id,
			@NotBlank(message = "Type is required") @Pattern(regexp = "Income|expense", message = "type must be income or expense") String type,
			@NotBlank(message = "title can not be blank") String title,
			@DecimalMin(value = "0.01", message = "Amount must be greater than zero") BigDecimal amount,
			@NotNull @PastOrPresent(message = "date cannot be in the future") LocalDate date, String description) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.amount = amount;
		this.date = date;
		this.description = description;
	}

	public Transaction() {
	}

}
