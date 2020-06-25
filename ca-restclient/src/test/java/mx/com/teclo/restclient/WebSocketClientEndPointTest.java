package mx.com.teclo.restclient;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.sockjs.frame.Jackson2SockJsMessageCodec;

public class WebSocketClientEndPointTest {
	
	private static Logger logger = Logger.getLogger(WebSocketClientEndPointTest.class);

    private final static WebSocketHttpHeaders headers = new WebSocketHttpHeaders();

    public ListenableFuture<StompSession> connect() {

        Transport webSocketTransport = new WebSocketTransport(new StandardWebSocketClient());
        List<Transport> transports = Collections.singletonList(webSocketTransport);

        SockJsClient sockJsClient = new SockJsClient(transports);
        sockJsClient.setMessageCodec(new Jackson2SockJsMessageCodec());

        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);

        String url = "ws://localhost:9080/ws";
        return stompClient.connect(url, headers, new MyHandler(), "localhost", 9080);
    }

    public void sendHello(StompSession stompSession) {
        String jsonHello = "{ \"name\" : \"Nick\" }";
        stompSession.send("/app/hello", jsonHello.getBytes());
    }

    private class MyHandler extends StompSessionHandlerAdapter {
        public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
            logger.info("Now connected");
        }
    }
    
    public static void main(String[] args) throws Exception {
    	WebSocketClientEndPointTest helloClient = new WebSocketClientEndPointTest();

        ListenableFuture<StompSession> f = helloClient.connect();
        StompSession stompSession = f.get();

       
        logger.info("Sending hello message" + stompSession);
        helloClient.sendHello(stompSession);
        Thread.sleep(60000);
    }

}
