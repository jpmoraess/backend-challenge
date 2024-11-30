package br.com.moraesit.wallet.service.infra.persistence.wallet;

import br.com.moraesit.wallet.service.application.ports.output.WalletRepository;
import br.com.moraesit.wallet.service.domain.entity.Wallet;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class WalletRepositoryAdapter implements WalletRepository {

    private final WalletJpaRepository walletJpaRepository;

    public WalletRepositoryAdapter(WalletJpaRepository walletJpaRepository) {
        this.walletJpaRepository = walletJpaRepository;
    }

    @Override
    public void save(Wallet wallet) {
        WalletDataMapper.toDomain(walletJpaRepository.save(WalletDataMapper.toEntity(wallet)));
    }

    @Override
    public Optional<Wallet> findById(UUID id) {
        return walletJpaRepository.findById(id)
                .map(WalletDataMapper::toDomain);
    }
}
