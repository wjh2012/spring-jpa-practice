package practiceWebsocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebSocketUser {

    private String id;
    private String name;
    private String sessionId;
}
