package org.sversh.ssui.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;


@Controller
public class WebController {

    private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex, HttpServletResponse resp)
        throws IOException {
        if (ex instanceof IOException) {
            LOG.warn(ex.getMessage());
        } else {
            LOG.error(ex.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/resource/id/{id}",
            produces = {"application/xml"})
    @ResponseBody
    public String getResource(HttpServletRequest req, HttpServletResponse resp,
            @PathVariable String id)
        throws SAXException, IOException, JAXBException, DatatypeConfigurationException {

        String result = String.format("<tag>Resource with id: %s</tag>", id);
        return result;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/resource/name/{name}",
            produces = {"application/xml"})
    @ResponseBody
    public String findResourceByName(HttpServletRequest req, HttpServletResponse resp,
            @PathVariable String name)
        throws SAXException, IOException, JAXBException, DatatypeConfigurationException {

        String result = String.format("<tag>Resource with name: %s</tag>", name);
        return result;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/resources",
            produces = {"application/xml"})
    @ResponseBody
    public String findAll(HttpServletRequest req, HttpServletResponse resp)
        throws SAXException, IOException, JAXBException, DatatypeConfigurationException {
        String result = String.format("<tag>All resources: </tag>");
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/resource/id/{id}",
            produces = {"application/xml"})
    public void postResource(HttpServletRequest request, HttpServletResponse resp,
                                @PathVariable String id)
        throws SAXException, IOException, JAXBException, DatatypeConfigurationException {
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/resource/id/{id}",
            produces = {"application/xml"})
    public void putResource(HttpServletRequest request, HttpServletResponse resp,
                                @PathVariable String id)
        throws SAXException, IOException, JAXBException, DatatypeConfigurationException {
    }

}
