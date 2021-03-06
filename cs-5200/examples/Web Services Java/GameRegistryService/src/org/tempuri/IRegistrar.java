
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.datacontract.schemas._2004._07.common.ArrayOfGameInfo;
import org.datacontract.schemas._2004._07.common.EndPoint;
import org.datacontract.schemas._2004._07.common.GameInfo;
import org.datacontract.schemas._2004._07.common.GameInfoGameStatus;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IRegistrar", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class,
    org.datacontract.schemas._2004._07.common.ObjectFactory.class,
    org.tempuri.ObjectFactory.class
})
public interface IRegistrar {


    /**
     * 
     * @param publicEP
     * @param label
     * @return
     *     returns org.datacontract.schemas._2004._07.common.GameInfo
     */
    @WebMethod(operationName = "RegisterGame", action = "http://tempuri.org/IRegistrar/RegisterGame")
    @WebResult(name = "RegisterGameResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "RegisterGame", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RegisterGame")
    @ResponseWrapper(localName = "RegisterGameResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RegisterGameResponse")
    public GameInfo registerGame(
        @WebParam(name = "label", targetNamespace = "http://tempuri.org/")
        String label,
        @WebParam(name = "publicEP", targetNamespace = "http://tempuri.org/")
        EndPoint publicEP);

    /**
     * 
     * @param status
     * @return
     *     returns org.datacontract.schemas._2004._07.common.ArrayOfGameInfo
     */
    @WebMethod(operationName = "GetGames", action = "http://tempuri.org/IRegistrar/GetGames")
    @WebResult(name = "GetGamesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetGames", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetGames")
    @ResponseWrapper(localName = "GetGamesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetGamesResponse")
    public ArrayOfGameInfo getGames(
        @WebParam(name = "status", targetNamespace = "http://tempuri.org/")
        GameInfoGameStatus status);

    /**
     * 
     * @param gameId
     */
    @WebMethod(operationName = "AmAlive", action = "http://tempuri.org/IRegistrar/AmAlive")
    @RequestWrapper(localName = "AmAlive", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AmAlive")
    @ResponseWrapper(localName = "AmAliveResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AmAliveResponse")
    public void amAlive(
        @WebParam(name = "gameId", targetNamespace = "http://tempuri.org/")
        Integer gameId);

    /**
     * 
     * @param status
     * @param gameId
     */
    @WebMethod(operationName = "ChangeStatus", action = "http://tempuri.org/IRegistrar/ChangeStatus")
    @RequestWrapper(localName = "ChangeStatus", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ChangeStatus")
    @ResponseWrapper(localName = "ChangeStatusResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ChangeStatusResponse")
    public void changeStatus(
        @WebParam(name = "gameId", targetNamespace = "http://tempuri.org/")
        Integer gameId,
        @WebParam(name = "status", targetNamespace = "http://tempuri.org/")
        GameInfoGameStatus status);

}
