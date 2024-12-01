package br.com.moraesit.wallet.service.application.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
