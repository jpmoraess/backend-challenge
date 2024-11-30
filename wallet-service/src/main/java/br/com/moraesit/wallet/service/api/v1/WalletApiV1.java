package br.com.moraesit.wallet.service.api.v1;

import br.com.moraesit.wallet.service.api.mapper.WalletMapper;
import br.com.moraesit.wallet.service.api.open.WalletOpenApiV1;
import br.com.moraesit.wallet.service.api.open.model.CreateWalletRequest;
import br.com.moraesit.wallet.service.api.open.model.CreateWalletResponse;
import br.com.moraesit.wallet.service.application.dto.CreateWalletOutput;
import br.com.moraesit.wallet.service.application.usecase.CreateWallet;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/wallet")
public class WalletApiV1 implements WalletOpenApiV1 {

    private final CreateWallet createWallet;

    public WalletApiV1(CreateWallet createWallet) {
        this.createWallet = createWallet;
    }

    @PostMapping
    @Override
    public ResponseEntity<CreateWalletResponse> createWallet(@Valid @RequestBody CreateWalletRequest request) {
        CreateWalletOutput output = createWallet.execute(WalletMapper.toInput(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(WalletMapper.toResponse(output));
    }
}
