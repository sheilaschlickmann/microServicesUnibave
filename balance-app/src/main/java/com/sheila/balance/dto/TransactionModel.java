package com.sheila.balance.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sheila.balance.DescriptionType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
public class TransactionModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column
	private String account;

	@Column
	private String description;

	@Column
	@Enumerated(EnumType.STRING)
	private DescriptionType  type;

	@Column
	private Double value;


    public TransactionModel(String accountId, Double value) {
        this.account = accountId;
        this.value = value;
 
    }

    public TransactionModel() {
    }

}
