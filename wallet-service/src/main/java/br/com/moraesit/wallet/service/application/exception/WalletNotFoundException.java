package br.com.moraesit.wallet.service.application.exception;

import java.util.UUID;

public class WalletNotFoundException extends BusinessException {

    public WalletNotFoundException(String message) {
        super(message);
    }

    public WalletNotFoundException(UUID walletId) {
        this(String.format("Wallet with id: %s not found", walletId));
    }
}
