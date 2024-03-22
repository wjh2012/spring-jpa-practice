package practiceWebsocket.model.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketHeader {

    private SocketAction socketAction;
    private String send;
    private String receive;
}
