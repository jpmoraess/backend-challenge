package br.com.moraesit.wallet.service.api.mapper;

import br.com.moraesit.wallet.service.api.open.model.CreateWalletRequest;
import br.com.moraesit.wallet.service.api.open.model.CreateWalletResponse;
import br.com.moraesit.wallet.service.application.dto.CreateWalletInput;
import br.com.moraesit.wallet.service.application.dto.CreateWalletOutput;

public class WalletMapper {
    private WalletMapper() {

    }

    public static CreateWalletInput toInput(CreateWalletRequest request) {
        return new CreateWalletInput(
                request.type(),
                request.fullName(),
                request.document(),
                request.email(),
                request.password()
        );
    }

    public static CreateWalletResponse toResponse(CreateWalletOutput output) {
        return new CreateWalletResponse(output.id());
    }
}
