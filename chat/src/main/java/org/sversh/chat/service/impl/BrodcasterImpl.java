package org.sversh.chat.service.impl;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.sversh.chat.service.api.Brodcaster;
import org.sversh.chat.service.api.Sessions;

/**
 * @author Sergey Vershinin
 *
 */
@Service
public class BrodcasterImpl implements Brodcaster {
	
	@Autowired
	private Sessions sessions;

	public void sent(String sessionId, String msg) {
		
		Collection<WebSocketSession> sendList = sessions.getSendList(sessionId);
		for (WebSocketSession webSocketSession : sendList) {
			WebSocketMessage<?> message = new TextMessage(webSocketSession.getId() + ": " + msg);
			sendMsg(webSocketSession, message);
		}
	}

	private void sendMsg(WebSocketSession webSocketSession, WebSocketMessage<?> message) {
		try {
			webSocketSession.sendMessage(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
