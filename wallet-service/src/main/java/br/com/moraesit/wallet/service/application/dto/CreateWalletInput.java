package br.com.moraesit.wallet.service.application.dto;

import br.com.moraesit.wallet.service.domain.entity.WalletType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateWalletInput(
        @NotNull
        WalletType type,

        @NotEmpty(message = "fullName is required")
        String fullName,

        @NotEmpty(message = "document is required")
        String document,

        @Email(message = "must be a valid email")
        @NotEmpty(message = "email is required")
        String email,

        @NotEmpty(message = "password is required")
        String password
) {
}
