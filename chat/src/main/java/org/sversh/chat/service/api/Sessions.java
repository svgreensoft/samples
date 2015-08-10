package org.sversh.chat.service.api;

import java.util.Collection;

import org.springframework.web.socket.WebSocketSession;


/**
 * @author Sergey Vershinin
 *
 */
public interface Sessions {

	WebSocketSession getSession(String sessionId);

	Collection<WebSocketSession> getSendList(String sessionId);

	void add(WebSocketSession session);

	void remove(WebSocketSession session);

}
