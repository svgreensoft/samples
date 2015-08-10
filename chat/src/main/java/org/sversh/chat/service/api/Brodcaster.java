package org.sversh.chat.service.api;

/**
 * @author Sergey Vershinin
 *
 */
public interface Brodcaster {

	void sent(String sessionId, String msg);

}
