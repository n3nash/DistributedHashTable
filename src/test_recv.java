import com.google.protobuf.*;
import org.jeromq.ZContext;
import org.jeromq.ZMQ;
import com.example.tutorial.AddressBookProtos.Person;


public class test_recv {

    public static void main (String[] args){
        ZMQ.Context context = ZMQ.context(1);
        Person message = Person.newBuilder().setName("NISHITH").setId(111).setEmail("john.doe@tld.com").build();


        //  Socket to talk to server
        System.out.println("Connecting to hello world server");

        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        socket.connect ("tcp://localhost:5555");
        
        final byte[] byteArray = message.toByteArray();
        System.out.println(byteArray);
        System.out.println(byteArray.length);
        
        for(int requestNbr = 0; requestNbr != 10; requestNbr++) {
            String request = "delete" ;
            System.out.println("Sending Hello " + requestNbr );
            socket.send(request.getBytes(), 0);

            byte[] reply = socket.recv(0);
            System.out.println("Receiveld " + new String (reply) + " " + requestNbr);
            if(new String (reply) == "Done")
            	break;
        }

        System.out.println("Closing Socket");
        socket.close();
        context.term();
    }

/*	public static void main(String args[])
	{	
	final ZContext ctx = new ZContext();
    ZMQ.Socket socket = ctx.createSocket(ZMQ.REP);
    socket.setLinger(10000);
    socket.bind("inproc://test");
    System.err.format("                    [Thread %s] socket bound%n", Thread.currentThread().getId());
    String request = socket.recvStr();
    assert request == "hello";
    System.err.format("                    [Thread %s] received request '%s'%n", Thread.currentThread()
            .getId(), request);
    socket.send("world");
    //socket.close();

    System.err.format("                    [Thread %s] socket closed%n", Thread.currentThread().getId());
    ctx.destroySocket(socket);
    System.err.format("                    [Thread %s] socket destroyed%n", Thread.currentThread().getId());
	}
   */
	
}
