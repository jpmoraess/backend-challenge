package br.com.moraesit.wallet.service.application.usecase;

import br.com.moraesit.wallet.service.application.dto.GetWalletOutput;
import br.com.moraesit.wallet.service.application.exception.WalletNotFoundException;
import br.com.moraesit.wallet.service.application.ports.output.WalletRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetWallet {

    private final WalletRepository walletRepository;

    public GetWallet(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public GetWalletOutput execute(UUID id) {
        return walletRepository.findById(id)
                .map(wallet -> new GetWalletOutput(wallet.getId(), wallet.getType()))
                .orElseThrow(() -> new WalletNotFoundException(id));
    }
}
