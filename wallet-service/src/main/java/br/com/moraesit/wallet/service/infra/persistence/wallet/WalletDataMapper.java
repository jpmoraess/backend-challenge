package br.com.moraesit.wallet.service.infra.persistence.wallet;

import br.com.moraesit.wallet.service.domain.entity.Wallet;

public class WalletDataMapper {

    private WalletDataMapper() {
    }

    public static WalletEntity toEntity(Wallet wallet) {
        return WalletEntity.builder()
                .id(wallet.getId())
                .type(wallet.getType())
                .fullName(wallet.getFullName())
                .document(wallet.getDocument())
                .email(wallet.getEmail())
                .password(wallet.getPassword())
                .build();
    }

    public static Wallet toDomain(WalletEntity entity) {
        return Wallet.restore(
                entity.getId(),
                entity.getType(),
                entity.getFullName(),
                entity.getDocument(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}
