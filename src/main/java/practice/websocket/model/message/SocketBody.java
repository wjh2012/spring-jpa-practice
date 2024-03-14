package practice.websocket.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketBody {
    private String author;
    private String roomId;
    private String message;
}
