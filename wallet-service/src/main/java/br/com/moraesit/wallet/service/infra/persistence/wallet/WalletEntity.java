package br.com.moraesit.wallet.service.infra.persistence.wallet;

import br.com.moraesit.wallet.service.domain.entity.WalletType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "wallet")
public class WalletEntity {

    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private WalletType type;
    private String fullName;
    private String document;
    private String email;
    private String password;
    private BigDecimal balance;

    public WalletEntity() {

    }

    public WalletEntity(UUID id, WalletType type, String fullName, String document, String email, String password, BigDecimal balance) {
        this.id = id;
        this.type = type;
        this.fullName = fullName;
        this.document = document;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    private WalletEntity(Builder builder) {
        id = builder.id;
        type = builder.type;
        fullName = builder.fullName;
        document = builder.document;
        email = builder.email;
        password = builder.password;
        balance = builder.balance;
    }

    public static Builder builder() {
        return new Builder();
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

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletEntity that = (WalletEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public static final class Builder {
        private UUID id;
        private WalletType type;
        private String fullName;
        private String document;
        private String email;
        private String password;
        private BigDecimal balance;

        private Builder() {
        }

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder type(WalletType val) {
            type = val;
            return this;
        }

        public Builder fullName(String val) {
            fullName = val;
            return this;
        }

        public Builder document(String val) {
            document = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder balance(BigDecimal val) {
            balance = val;
            return this;
        }

        public WalletEntity build() {
            return new WalletEntity(this);
        }
    }
}
