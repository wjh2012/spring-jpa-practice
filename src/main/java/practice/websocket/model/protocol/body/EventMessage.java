package practice.websocket.model.protocol.body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.websocket.model.protocol.body.event.EventTarget;
import practice.websocket.model.protocol.body.event.MouseEvent;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventMessage {

    private EventTarget eventTarget;
    private MouseEvent mouseEvent;
    private Object detail;

}
