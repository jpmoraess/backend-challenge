package br.com.moraesit.wallet.service.api.v1;

import br.com.moraesit.wallet.service.api.mapper.WalletMapper;
import br.com.moraesit.wallet.service.api.open.WalletOpenApiV1;
import br.com.moraesit.wallet.service.api.open.model.CreateWalletRequest;
import br.com.moraesit.wallet.service.api.open.model.CreateWalletResponse;
import br.com.moraesit.wallet.service.api.open.model.GetWalletResponse;
import br.com.moraesit.wallet.service.application.dto.CreateWalletOutput;
import br.com.moraesit.wallet.service.application.usecase.CreateWallet;
import br.com.moraesit.wallet.service.application.usecase.GetWallet;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/wallets")
public class WalletApiV1 implements WalletOpenApiV1 {

    private final GetWallet getWallet;
    private final CreateWallet createWallet;

    public WalletApiV1(GetWallet getWallet, CreateWallet createWallet) {
        this.getWallet = getWallet;
        this.createWallet = createWallet;

    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<GetWalletResponse> getWallet(@PathVariable UUID id) {
        return ResponseEntity.ok(WalletMapper.toResponse(getWallet.execute(id)));
    }

    @PostMapping
    @Override
    public ResponseEntity<CreateWalletResponse> createWallet(@Valid @RequestBody CreateWalletRequest request) {
        CreateWalletOutput output = createWallet.execute(WalletMapper.toInput(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(WalletMapper.toResponse(output));
    }
}
