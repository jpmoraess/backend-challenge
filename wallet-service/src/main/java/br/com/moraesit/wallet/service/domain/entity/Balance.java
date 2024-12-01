package br.com.moraesit.wallet.service.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Balance {

    private final UUID id;
    private final UUID walletId;
    private final BigDecimal balance;

    private Balance(UUID id, UUID walletId, BigDecimal balance) {
        this.id = id;
        this.walletId = walletId;
        this.balance = balance;
    }

    public static Balance create(UUID walletId) {
        if (walletId == null)
            throw new IllegalArgumentException("wallet is required");
        return new Balance(UUID.randomUUID(), walletId, BigDecimal.ZERO);
    }

    public static Balance restore(UUID id, UUID walletId, BigDecimal balance) {
        if (id == null)
            throw new IllegalArgumentException("id is required");
        if (walletId == null)
            throw new IllegalArgumentException("wallet is required");
        if (balance == null)
            throw new IllegalArgumentException("balance is required");
        return new Balance(id, walletId, balance);
    }

    public BigDecimal debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0)
            throw new IllegalArgumentException("insufficient funds");
        return this.balance.subtract(amount);
    }

    public BigDecimal credit(BigDecimal amount) {
        if (BigDecimal.ZERO.compareTo(amount) <= 0)
            throw new IllegalArgumentException("invalid credit amount");
        return this.balance.add(amount);
    }

    public UUID getId() {
        return id;
    }

    public UUID getWalletId() {
        return walletId;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
