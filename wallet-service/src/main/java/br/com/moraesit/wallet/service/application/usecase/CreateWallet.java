package br.com.moraesit.wallet.service.application.usecase;

import br.com.moraesit.wallet.service.application.dto.CreateWalletInput;
import br.com.moraesit.wallet.service.application.dto.CreateWalletOutput;
import br.com.moraesit.wallet.service.application.ports.output.WalletRepository;
import br.com.moraesit.wallet.service.domain.WalletDomainService;
import br.com.moraesit.wallet.service.domain.event.WalletCreatedEvent;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class CreateWallet {

    private final WalletRepository walletRepository;
    private final WalletDomainService walletDomainService;

    public CreateWallet(WalletRepository walletRepository, WalletDomainService walletDomainService) {
        this.walletRepository = walletRepository;
        this.walletDomainService = walletDomainService;
    }

    public CreateWalletOutput execute(@Valid CreateWalletInput input) {
        WalletCreatedEvent walletCreatedEvent = walletDomainService
                .create(input.type(), input.fullName(), input.document(), input.email(), input.password());
        walletRepository.save(walletCreatedEvent.getWallet());
        return new CreateWalletOutput(walletCreatedEvent.getWallet().getId());
    }
}
