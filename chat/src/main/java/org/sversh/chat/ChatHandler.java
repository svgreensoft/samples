package org.sversh.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.sversh.chat.service.api.Brodcaster;
import org.sversh.chat.service.api.Sessions;
import org.sversh.chat.service.impl.ProgressStorage;

public class ChatHandler extends TextWebSocketHandler {

	@Autowired
	private Brodcaster broadcaster;
	
	@Autowired
	private Sessions sessions;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
    	System.out.println("processing message ...");
		String sessionId = session.getId();
		String msg = message.getPayload();
		if (msg.equals("")) {
			ProgressStorage.put(sessionId);
		} else {
			broadcaster.sent(sessionId, msg );
		}
    }
    
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
	}

}