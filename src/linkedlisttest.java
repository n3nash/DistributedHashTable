import java.util.LinkedList;
import java.util.ListIterator;


public class linkedlisttest {

	
	public static void main(String args[]){
	LinkedList<Integer> linktest = new LinkedList<Integer>();
	linktest.add(13);
	linktest.add(15);
	linktest.add(16);
	
	ListIterator<Integer> itr = linktest.listIterator();
	
	if(itr.hasNext()) {
		System.out.println(itr.next().intValue());
		System.out.println(itr.next().intValue());
		System.out.println(itr.next().intValue());
		itr.previous();
		itr.add(14);
	}
	
	ListIterator<Integer> itr2 = linktest.listIterator();
	while(itr2.hasNext())
		System.out.println(itr2.next().intValue());
	}
}

