package br.inatel.dm112.logistica.mail;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2016-03-31T15:57:03.712-03:00
 * Generated source version: 3.1.5
 * 
 */
@WebServiceClient(name = "mailService", 
                  wsdlLocation = "http://localhost:8080/UtilityDM112/soap/mailservices?wsdl",
                  targetNamespace = "dm112") 
public class MailService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("dm112", "mailService");
    public final static QName MailImplPort = new QName("dm112", "MailImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/UtilityDM112/soap/mailservices?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MailService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/UtilityDM112/soap/mailservices?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MailService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MailService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MailService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public MailService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public MailService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public MailService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns MailImpl
     */
    @WebEndpoint(name = "MailImplPort")
    public MailImpl getMailImplPort() {
        return super.getPort(MailImplPort, MailImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MailImpl
     */
    @WebEndpoint(name = "MailImplPort")
    public MailImpl getMailImplPort(WebServiceFeature... features) {
        return super.getPort(MailImplPort, MailImpl.class, features);
    }

}