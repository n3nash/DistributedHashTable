//import org.jeromq.*;
import org.jeromq.*;
import com.example.tutorial.AddressBookProtos;
import com.example.tutorial.AddressBookProtos.Person;
import com.google.protobuf.*;
public class test {


	    public static void main (String[] args) throws Exception{
	        ZMQ.Context context = ZMQ.context(1);
	        //  Socket to talk to clients
	        ZMQ.Socket socket = context.socket(ZMQ.REP);
	        socket.bind ("tcp://*:5555");

	        while (!Thread.currentThread ().isInterrupted ()) {
	        	
	            byte[] reply = socket.recv(0);
	            final Person data = AddressBookProtos.Person.parseFrom(reply);
	            System.out.println(data.getName());
	            System.out.println("Received Hello");
	            String request = "World" ;
	            socket.send(request.getBytes (), 0);
	            Thread.sleep(1000); //  Do some 'work'
	        }
	        System.out.println("Closing server Socket");
	        socket.close();
	        context.term();
	    }

	/*
	public static void main(String args[])
	{
		
		
	final ZContext ctx = new ZContext();
	
    ZMQ.Socket socket = ctx.createSocket(ZMQ.REQ);
    socket.connect("inproc://test");
    System.err.format("[Thread %s] socket connected%n", Thread.currentThread().getId());
    socket.send("hello");
    System.err.format("[Thread %s] hello sent%n", Thread.currentThread().getId());
    String result = socket.recvStr();
    System.err.format("[Thread %s] received response '%s'%n", Thread.currentThread()
            .getId(), result);
    //socket.close();

    System.err.format("[Thread %s] socket closed%n", Thread.currentThread().getId());
    ctx.destroySocket(socket);
    System.err.format("[Thread %s] socket destroyed%n", Thread.currentThread().getId());
	
	}*/
}
