package account.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeleteUserResponseDTO {
    private final String status = "Deleted successfully!";
    private final String user;
}
