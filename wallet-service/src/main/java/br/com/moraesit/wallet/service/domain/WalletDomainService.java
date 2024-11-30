package br.com.moraesit.wallet.service.domain;

import br.com.moraesit.wallet.service.domain.entity.WalletType;
import br.com.moraesit.wallet.service.domain.event.WalletCreatedEvent;

public interface WalletDomainService {

    WalletCreatedEvent create(WalletType type, String fullName, String document, String email, String password);
}
