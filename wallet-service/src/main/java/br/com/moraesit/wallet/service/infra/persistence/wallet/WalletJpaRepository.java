package br.com.moraesit.wallet.service.infra.persistence.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletJpaRepository extends JpaRepository<WalletEntity, UUID> {
}
