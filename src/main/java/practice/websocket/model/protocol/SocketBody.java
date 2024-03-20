package practice.websocket.model.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketBody {
    private String author;
    private String roomId;
    private Object payload;
}
