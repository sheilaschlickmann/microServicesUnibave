package com.sheila.balance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BalanceDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class TransactionDto {

	private String account;

	private String description;

	private DescriptionType type;

	private Double value;

	}

	public enum DescriptionType {
		INCOME, EXPENSE
	}

}
