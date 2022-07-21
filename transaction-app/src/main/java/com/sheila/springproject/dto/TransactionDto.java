package com.sheila.springproject.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sheila.springproject.enums.DescriptionType;

import lombok.Data;

@Data
public class TransactionDto {

	private Integer Id;

	private String account;

	private String description;

	@Enumerated(EnumType.STRING)
	private DescriptionType type;

	private Double value;

}