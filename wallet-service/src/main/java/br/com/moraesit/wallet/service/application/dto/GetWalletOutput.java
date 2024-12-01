package br.com.moraesit.wallet.service.application.dto;

import br.com.moraesit.wallet.service.domain.entity.WalletType;

import java.util.UUID;

public record GetWalletOutput(
        UUID id,
        WalletType type
) {
}
