package br.com.moraesit.wallet.service.domain;

import br.com.moraesit.wallet.service.domain.entity.Wallet;
import br.com.moraesit.wallet.service.domain.entity.WalletType;
import br.com.moraesit.wallet.service.domain.event.WalletCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;

public class WalletDomainServiceImpl implements WalletDomainService {

    private static final Logger logger = LoggerFactory.getLogger(WalletDomainServiceImpl.class);

    @Override
    public WalletCreatedEvent create(WalletType type, String fullName, String document, String email, String password) {
        Wallet wallet = Wallet.create(type, fullName, document, email, password);
        logger.info("Wallet with id: {} is created", wallet.getId());
        return new WalletCreatedEvent(wallet, ZonedDateTime.now());
    }
}
