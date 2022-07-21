package com.sheila.balance.dto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Balances extends JpaRepository<TransactionModel, String> {
    Optional<TransactionModel> findByAccountId(String account);
}
