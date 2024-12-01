package br.com.moraesit.wallet.service.api.open;

import br.com.moraesit.wallet.service.api.open.model.CreateWalletRequest;
import br.com.moraesit.wallet.service.api.open.model.CreateWalletResponse;
import br.com.moraesit.wallet.service.api.open.model.GetWalletResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "WalletApiV1", description = "Wallets")
public interface WalletOpenApiV1 {

    @Operation(description = "Get Wallet", summary = "Get Wallet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
    })
    ResponseEntity<GetWalletResponse> getWallet(@Parameter(name = "id", in = ParameterIn.PATH, required = true) UUID id);

    @Operation(description = "Create Wallet", summary = "Create Wallet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    ResponseEntity<CreateWalletResponse> createWallet(@RequestBody(description = "request", required = true) CreateWalletRequest request);
}
