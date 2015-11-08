package tennis.webservice;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(serviceName = "TennisOP" )
@SOAPBinding(style=SOAPBinding.Style.RPC, use=SOAPBinding.Use.LITERAL)
public interface TennisOP {
    @WebMethod(operationName="getPlayer", action="urn:getPlayer")
    @WebResult(name="return")
  	String getPlayer( @WebParam(name="PlayerId") int PlayerId) ;
}




