package practice.websocket.service;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import practice.websocket.model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RoomManager {

    // 방을 관리한다.
    private Map<String, Room> rooms = new HashMap<>();
    // 세션-방 을 기록한다.
    private Map<String, String> roomMap = new HashMap<>();


    public List<WebSocketSession> getAllSessionInRoom(String roomId) {
        Room room = rooms.get(roomId);
        ConcurrentHashMap<String, WebSocketSession> sessions = room.getSessions();
        return new ArrayList<>(sessions.values());
    }

    public String removeSession(WebSocketSession session) {
        String sessionId = session.getId();
        String roomId = this.roomMap.get(sessionId);
        Room room = this.rooms.get(roomId);
        ConcurrentHashMap<String, WebSocketSession> sessions = room.getSessions();

        sessions.remove(sessionId);
        roomMap.remove(sessionId);

        return roomId;
    }

    public String putSession(WebSocketSession session, String roomId) {
        String sessionId = session.getId();
        Room room;
        if (this.rooms.containsKey(roomId)) {
            room = rooms.get(roomId);
        } else {
            room = new Room();
            room.setRoomId(roomId);
            rooms.put(roomId, room);
        }
        room.getSessions().put(sessionId, session);
        roomMap.put(sessionId, roomId);

        return roomId;
    }

}
