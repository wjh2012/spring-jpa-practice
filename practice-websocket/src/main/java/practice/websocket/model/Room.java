package practice.websocket.model;

import java.util.concurrent.ConcurrentHashMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private String roomId;
    private String roomName;
    private ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
}
