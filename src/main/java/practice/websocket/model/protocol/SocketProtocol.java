package practice.websocket.model.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocketProtocol {
    private SocketHeader socketHeader;
    private SocketBody socketBody;

}

/** @formatter:off
 * SocketProtocol {
 *     SocketHeader{
 *       SocketAction,
 *       Send,
 *       Receive
 *     },
 *     SocketBody{
 *       Author,
 *       RoomId,
 *       Message {
 *         EventTarget,
 *         MouseAction,
 *         Message
 *       }
 *     }
 * }
 */
