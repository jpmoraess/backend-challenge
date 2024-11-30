package br.com.moraesit.wallet.service.api.open;

import br.com.moraesit.wallet.service.api.open.model.CreateWalletRequest;
import br.com.moraesit.wallet.service.api.open.model.CreateWalletResponse;
import org.springframework.http.ResponseEntity;

public interface WalletOpenApiV1 {

    ResponseEntity<CreateWalletResponse> createWallet(CreateWalletRequest request);
}
