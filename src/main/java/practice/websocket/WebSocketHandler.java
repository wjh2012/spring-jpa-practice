package practice.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import practice.websocket.model.protocol.SocketAction;
import practice.websocket.model.protocol.SocketHeader;
import practice.websocket.model.protocol.SocketBody;
import practice.websocket.model.protocol.SocketProtocol;
import practice.websocket.service.MessageManager;
import practice.websocket.service.RoomManager;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    // 모든 클라이언트를 저장한다.
    private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<>();

    private final RoomManager roomManager;
    private final MessageManager messageManager;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        CLIENTS.put(session.getId(), session);
        System.out.println("session: " + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String sessionId = session.getId();
        String roomId = roomManager.removeSession(session);
        CLIENTS.remove(sessionId);

        List<WebSocketSession> sessions = roomManager.getAllSessionInRoom(roomId);
        messageManager.roomBroadCastSystemMessage(sessionId + "님이 종료하였습니다.", sessions);

        System.out.println("removed: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        SocketProtocol webSocketSocketProtocol = mapper.readValue(textMessage.getPayload(), SocketProtocol.class);
        System.out.println(webSocketSocketProtocol.toString());

        SocketHeader socketHeader = webSocketSocketProtocol.getSocketHeader();
        SocketBody socketBody = webSocketSocketProtocol.getSocketBody();

        SocketAction action = socketHeader.getSocketAction();
        String roomId = socketBody.getRoomId();
        String author = socketBody.getAuthor();
        Object payload = socketBody.getPayload();

        List<WebSocketSession> sessions;
        switch (action) {
            case JOIN:
                roomManager.putSession(session, roomId);
                sessions = roomManager.getAllSessionInRoom(roomId);
                messageManager.roomBroadCastSystemMessage(session.getId() + "님이 접속하였습니다.", sessions);
                break;
            case MESSAGE:
                sessions = roomManager.getAllSessionInRoom(roomId);
                sessions.remove(session);
                messageManager.roomBroadCastUserMessage(session, SocketAction.MESSAGE, payload, sessions);
                break;
        }
    }

}
