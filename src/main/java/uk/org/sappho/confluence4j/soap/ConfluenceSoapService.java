package uk.org.sappho.confluence4j.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.atlassian.confluence.rpc.soap.client.ConfluenceSoapServiceServiceLocator;

public class ConfluenceSoapService {

    protected final com.atlassian.confluence.rpc.soap.client.ConfluenceSoapService service;
    protected final String token;

    public ConfluenceSoapService(String url, String username, String password) throws MalformedURLException,
            ServiceException, RemoteException {

        service = new ConfluenceSoapServiceServiceLocator().getConfluenceserviceV1(new URL(url
                + "/rpc/soap-axis/confluenceservice-v1"));
        token = service.login(username, password);
    }

    public com.atlassian.confluence.rpc.soap.client.ConfluenceSoapService getService() {

        return service;
    }

    public String getToken() {

        return token;
    }
}
