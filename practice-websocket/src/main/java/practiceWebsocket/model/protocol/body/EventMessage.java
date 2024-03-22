package practiceWebsocket.model.protocol.body;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import practiceWebsocket.model.protocol.body.event.EventTarget;
import practiceWebsocket.model.protocol.body.event.MouseAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventMessage {

    private EventTarget eventTarget;
    private MouseAction mouseAction;
    private Object detail;

}
