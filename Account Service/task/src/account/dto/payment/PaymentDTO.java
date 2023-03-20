package account.dto.payment;

import account.validation.ValidDate;
import account.validation.ValidEmail;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Positive;

@Getter
@RequiredArgsConstructor
public class PaymentDTO {
    @ValidEmail
    @JsonProperty("employee")
    private final String email;
    @ValidDate
    private final String period;
    private final @Positive Long salary;
}
