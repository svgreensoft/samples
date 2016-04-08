package org.sversh.hw.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.sversh.hw.service.api.IpFinder;

/**
 * 
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Service
public class IpFinderImpl implements IpFinder {

    @Override
    public String find(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

}
