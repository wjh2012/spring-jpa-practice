package practice.websocket.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketHeader {
    private Action action;
    private String send;
    private String receive;
}
