package br.com.moraesit.wallet.service.config;

import br.com.moraesit.wallet.service.domain.WalletDomainService;
import br.com.moraesit.wallet.service.domain.WalletDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean("walletDomainService")
    public WalletDomainService walletDomainService() {
        return new WalletDomainServiceImpl();
    }
}
