package org.sversh.hw.service.api;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
public interface IpFinder {

    String find(HttpServletRequest request);

}
