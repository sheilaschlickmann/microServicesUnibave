package com.sheila.balance;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sheila.balance.dto.Balances;
import com.sheila.balance.dto.TransactionModel;
;

@Component
public
 class BalanceListener {

    private final Balances balances;

    public BalanceListener(Balances balances) {
        this.balances = balances;
    }
	
	@RabbitListener(queues = "transactions")

	public void onBalanceCreated (byte[] jsonInBytes) {

		final var gson = new Gson();

		final var transaction = gson.fromJson(new String(jsonInBytes), Transaction.class);

		var balanceOptional = balances.findByAccountId(transaction.getAccount());

		if (balanceOptional.isPresent()) {
            final var balance = balanceOptional.get();
            transaction.setValue(transaction.isIncome() ? 
            		transaction.getValue() + transaction.getValue() :
            			transaction.getValue() - transaction.getValue()
            );

            System.out.println("Storing balance: " + balance.toString());

            balances.save(balance);

        } else {

            final var factor = transaction.isIncome() ? 1 : -1;
            final var balance = new TransactionModel(transaction.getAccount(), transaction.getValue() * factor);
            System.out.println("Storing balance: " + balance.toString());
            balances.save(balance);

        }
		
	}
}
