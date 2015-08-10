package org.sversh.chat.sse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sversh.chat.service.impl.ProgressStorage;

/**
 * @author Sergey Vershinin
 *
 */

public class SseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final long ONE_SECOND = 1000L;
	private static final String END_OF_MESSAGE = " \n\n";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Connection", "keep-alive");
		response.setContentType("text/event-stream;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		while (true) {
			try {
				Thread.sleep(ONE_SECOND);
				Set<String> active = ProgressStorage.getActive();
				String activeLabel = concatenate(active);
				PrintWriter writer = response.getWriter();
				writer.print("data: " + activeLabel + END_OF_MESSAGE);
				writer.flush();
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				response.getOutputStream().close();
			}
		}

	}

	private String concatenate(Set<String> actives) {
		if (actives.isEmpty()) {
			return "Nobody is typing.";
		}
		StringBuffer sb = new StringBuffer();
		for (String active : actives) {
			sb.append(active + ",");
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

}
