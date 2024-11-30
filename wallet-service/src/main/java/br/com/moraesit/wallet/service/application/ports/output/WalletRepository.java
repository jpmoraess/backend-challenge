package br.com.moraesit.wallet.service.application.ports.output;

import br.com.moraesit.wallet.service.domain.entity.Wallet;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository {

    void save(Wallet wallet);

    Optional<Wallet> findById(UUID id);
}
