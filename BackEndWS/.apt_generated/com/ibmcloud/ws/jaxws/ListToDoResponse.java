//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:52 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:54 PM(foreman)-)
//


package com.ibmcloud.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listToDoResponse", namespace = "http://ws.ibmcloud.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listToDoResponse", namespace = "http://ws.ibmcloud.com/")
public class ListToDoResponse {

    @XmlElement(name = "return", namespace = "")
    private com.ibmcloud.data.Operation _return;

    /**
     * 
     * @return
     *     returns Operation
     */
    public com.ibmcloud.data.Operation getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ibmcloud.data.Operation _return) {
        this._return = _return;
    }

}
