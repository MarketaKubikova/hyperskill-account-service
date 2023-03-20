package account.mapper;

import account.dto.payment.PaymentDTO;
import account.dto.payment.PaymentResponseDTO;
import account.dto.user.UserDTO;
import account.model.payment.Payment;
import account.model.user.Role;
import account.model.user.User;
import account.service.UserService;
import account.util.Formatter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ModelMapper {
    private final UserService userService;

    public User mapToEntity(UserDTO dto) {
        return User.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .isAccountNonLocked(true)
                .build();
    }

    public UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .roles(user.getRoles().stream()
                        .map(Role::withPrefix)
                        .sorted(String::compareTo)
                        .collect(Collectors.toList()))
                .build();
    }

    public Payment mapToEntity(PaymentDTO dto) {
        return Payment.builder()
                .email(dto.getEmail())
                .period(Formatter.stringToDate(dto.getPeriod()))
                .salary(dto.getSalary())
                .user(userService.findUserByEmail(dto.getEmail()))
                .build();
    }

    public PaymentResponseDTO mapToDTO(Payment payment) {
        return PaymentResponseDTO.builder()
                .name(payment.getUser().getName())
                .lastname(payment.getUser().getLastname())
                .period(Formatter.dateToString(payment.getPeriod()))
                .salary(Formatter.formatSalary(payment.getSalary()))
                .build();
    }
}
