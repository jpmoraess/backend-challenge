package br.com.moraesit.wallet.service.api.open.model;

import br.com.moraesit.wallet.service.domain.entity.WalletType;

import java.util.UUID;

public record GetWalletResponse(
        UUID id,
        WalletType type
) {
}
