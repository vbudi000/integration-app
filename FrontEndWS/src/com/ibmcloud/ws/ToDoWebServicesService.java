//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:52 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:54 PM(foreman)-)
//


package com.ibmcloud.ws;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ToDoWebServicesService", targetNamespace = "http://ws.ibmcloud.com/", wsdlLocation = "WEB-INF/wsdl/ToDoWebServicesService.wsdl")
public class ToDoWebServicesService
    extends Service
{

    private final static URL TODOWEBSERVICESSERVICE_WSDL_LOCATION;
    private final static WebServiceException TODOWEBSERVICESSERVICE_EXCEPTION;
    private final static QName TODOWEBSERVICESSERVICE_QNAME = new QName("http://ws.ibmcloud.com/", "ToDoWebServicesService");

    static {
            TODOWEBSERVICESSERVICE_WSDL_LOCATION = com.ibmcloud.ws.ToDoWebServicesService.class.getResource("/WEB-INF/wsdl/ToDoWebServicesService.wsdl");
        WebServiceException e = null;
        if (TODOWEBSERVICESSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'WEB-INF/wsdl/ToDoWebServicesService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        TODOWEBSERVICESSERVICE_EXCEPTION = e;
    }

    public ToDoWebServicesService() {
        super(__getWsdlLocation(), TODOWEBSERVICESSERVICE_QNAME);
    }

    public ToDoWebServicesService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TODOWEBSERVICESSERVICE_QNAME, features);
    }

    public ToDoWebServicesService(URL wsdlLocation) {
        super(wsdlLocation, TODOWEBSERVICESSERVICE_QNAME);
    }

    public ToDoWebServicesService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TODOWEBSERVICESSERVICE_QNAME, features);
    }

    public ToDoWebServicesService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ToDoWebServicesService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ToDoWebServices
     */
    @WebEndpoint(name = "ToDoWebServicesPort")
    public ToDoWebServices getToDoWebServicesPort() {
        return super.getPort(new QName("http://ws.ibmcloud.com/", "ToDoWebServicesPort"), ToDoWebServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ToDoWebServices
     */
    @WebEndpoint(name = "ToDoWebServicesPort")
    public ToDoWebServices getToDoWebServicesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.ibmcloud.com/", "ToDoWebServicesPort"), ToDoWebServices.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TODOWEBSERVICESSERVICE_EXCEPTION!= null) {
            throw TODOWEBSERVICESSERVICE_EXCEPTION;
        }
        return TODOWEBSERVICESSERVICE_WSDL_LOCATION;
    }

}
