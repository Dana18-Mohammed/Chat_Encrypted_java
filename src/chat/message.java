package chat;

/**
 *
 * @author danam
 */
import java.io.Serializable;
/*
 * public class message
  Creates an serializable object with contains the message 
   to be exchanged between Client and Server.			
 */
public class message implements Serializable {

    private static final long serialVersionUID = 1L;
    byte[] data;

    message(byte[] data) {
        this.data = data;
    }

    message() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    byte[] getData() {
        return data;
    }

}
