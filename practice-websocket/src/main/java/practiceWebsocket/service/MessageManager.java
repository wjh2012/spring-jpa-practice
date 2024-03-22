package practiceWebsocket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import practiceWebsocket.model.protocol.SocketAction;
import practiceWebsocket.model.protocol.SocketBody;
import practiceWebsocket.model.protocol.SocketHeader;
import practiceWebsocket.model.protocol.SocketProtocol;

@Component
public class MessageManager {

    public void roomBroadCastSystemMessage(String payload, List<WebSocketSession> targets)
        throws JsonProcessingException {
        SocketProtocol socketProtocol = new SocketProtocol();

        // set header
        SocketHeader socketHeader = new SocketHeader();
        socketHeader.setSocketAction(SocketAction.SYSTEM);
        socketProtocol.setSocketHeader(socketHeader);

        // set body
        SocketBody socketBody = new SocketBody();
        socketBody.setPayload(payload);
        socketProtocol.setSocketBody(socketBody);

        // make WebSocketMessage
        ObjectMapper mapper = new ObjectMapper();
        String objectToString = mapper.writeValueAsString(socketProtocol);
        TextMessage newMessage = new TextMessage(objectToString);

        // send
        targets.forEach(target -> {
            try {
                target.sendMessage(newMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void roomBroadCastUserMessage(WebSocketSession session, SocketAction action,
        Object payload, List<WebSocketSession> targets) throws JsonProcessingException {
        SocketProtocol socketProtocol = new SocketProtocol();

        // set header
        SocketHeader socketHeader = new SocketHeader();
        socketHeader.setSocketAction(action);
        socketHeader.setSend("server");
        socketHeader.setReceive("client");
        socketProtocol.setSocketHeader(socketHeader);

        // set body
        SocketBody socketBody = new SocketBody();
        socketBody.setAuthor(session.getId());
        socketBody.setPayload(payload);
        socketProtocol.setSocketBody(socketBody);

        // make WebSocketMessage
        ObjectMapper mapper = new ObjectMapper();
        String objectToString = mapper.writeValueAsString(socketProtocol);
        TextMessage newMessage = new TextMessage(objectToString);

        // send
        targets.forEach(target -> {
            try {
                target.sendMessage(newMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
