package org.sversh.chat.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import org.sversh.chat.service.api.Sessions;

/**
 * @author Sergey Vershinin
 *
 */
@Service
public class SessionsImpl implements Sessions {
	
	private Map<String, WebSocketSession> sessions;
	
	
	@PostConstruct
	private void init() {
		sessions = Collections.synchronizedMap(new HashMap<String, WebSocketSession>());
	}

	public WebSocketSession getSession(String sessionId) {
		WebSocketSession session = sessions.get(sessionId);
		return session;
	}

	public Collection<WebSocketSession> getSendList(String sessionId) {
		Map<String, WebSocketSession> sendList = new HashMap<String, WebSocketSession>(sessions);
		sendList.remove(sessionId);
		return sendList.values();
	}

	public void add(WebSocketSession session) {
		sessions.put(session.getId(), session);
	}

	public void remove(WebSocketSession session) {
		sessions.remove(session.getId());
	}

}
