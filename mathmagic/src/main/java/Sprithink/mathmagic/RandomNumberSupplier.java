package Sprithink.mathmagic;

import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.function.Consumer;
import java.util.function.Supplier;


public interface RandomNumberSupplier extends Supplier {

    Integer generateRandomNumber();
}
