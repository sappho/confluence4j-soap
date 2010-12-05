package uk.org.sappho.confluence4j.soap;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.junit.Test;

public class ConfluenceSoapServiceTest {

    @Test(expected = RemoteException.class)
    public void testBadLogin() throws MalformedURLException, RemoteException, ServiceException {

        new ConfluenceSoapService("http://confluence.atlassian.com", "sappho-test-random-v4HCD7h9JM", "2Gj8M29XrW");
    }

    @Test(expected = AxisFault.class)
    public void testUnknownHost() throws MalformedURLException, RemoteException, ServiceException {

        new ConfluenceSoapService("http://confluence9876.atlassian.com", "sappho-test-random-v4HCD7h9JM", "2Gj8M29XrW");
    }

    @Test(expected = MalformedURLException.class)
    public void testBadURL() throws MalformedURLException, RemoteException, ServiceException {

        new ConfluenceSoapService("xxx://confluence.atlassian.com", "sappho-test-random-v4HCD7h9JM", "2Gj8M29XrW");
    }
}
