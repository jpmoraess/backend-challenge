package br.com.moraesit.wallet.service.domain.event;

import br.com.moraesit.wallet.service.domain.entity.Wallet;

import java.time.ZonedDateTime;

public class WalletCreatedEvent extends WalletEvent {

    public WalletCreatedEvent(Wallet wallet, ZonedDateTime createdAt) {
        super(wallet, createdAt);
    }
}
