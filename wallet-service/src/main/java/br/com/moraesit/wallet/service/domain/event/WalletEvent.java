package br.com.moraesit.wallet.service.domain.event;

import br.com.moraesit.wallet.service.domain.entity.Wallet;

import java.time.ZonedDateTime;

public abstract class WalletEvent {
    private final Wallet wallet;
    private final ZonedDateTime createdAt;

    public WalletEvent(Wallet wallet, ZonedDateTime createdAt) {
        this.wallet = wallet;
        this.createdAt = createdAt;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
