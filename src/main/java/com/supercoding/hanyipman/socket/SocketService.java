package com.supercoding.hanyipman.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.supercoding.hanyipman.dto.vo.ChatMessage;
import com.supercoding.hanyipman.dto.vo.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SocketService {

    public void sendMessage(String room, String eventName, SocketIOClient senderClient, String message) {
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent(eventName,
                        new ChatMessage(MessageType.SERVER, message));
            }
        }
    }
}
