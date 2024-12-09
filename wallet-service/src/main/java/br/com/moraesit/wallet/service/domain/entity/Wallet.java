package br.com.moraesit.wallet.service.domain.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class Wallet {

    private final UUID id;
    private final WalletType type;
    private final String fullName;
    private final String document;
    private final String email;
    private final String password;

    private Wallet(UUID id, WalletType type, String fullName, String document, String email, String password) {
        this.id = id;
        this.type = type;
        this.fullName = fullName;
        this.document = document;
        this.email = email;
        this.password = password;
    }

    public static Wallet create(WalletType type, String fullName, String document, String email, String password) {
        validate(type, fullName, document, email, password);
        return new Wallet(UUID.randomUUID(), type, fullName, document, email, password);
    }

    public static Wallet restore(UUID id, WalletType type, String fullName, String document, String email, String password) {
        if (id == null)
            throw new IllegalArgumentException("id is required");
        validate(type, fullName, document, email, password);
        return new Wallet(id, type, fullName, document, email, password);
    }

    private static void validate(WalletType type, String fullName, String document, String email, String password) {
        if (type == null)
            throw new IllegalArgumentException("type is required");
        if (StringUtils.isEmpty(fullName))
            throw new IllegalArgumentException("fullName is required");
        if (StringUtils.isEmpty(document))
            throw new IllegalArgumentException("document is required");
        if (StringUtils.isEmpty(email))
            throw new IllegalArgumentException("email is required");
        if (StringUtils.isEmpty(password))
            throw new IllegalArgumentException("password is required");
    }

    public UUID getId() {
        return id;
    }

    public WalletType getType() {
        return type;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
