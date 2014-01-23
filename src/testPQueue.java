import java.util.PriorityQueue;


public class testPQueue {

	public class test implements Comparable<test> {
		String a;
		String b;
		@Override
		public int compareTo(test o) {
			// TODO Auto-generated method stub
			if(this.a.compareTo(o.a) > 0)
				return 0;
			else return -1;
			//return 0;
		}
	}
	PriorityQueue<test> pq = new PriorityQueue<test>();
	
	public static void main(String args[]) {
		testPQueue obj = new testPQueue();
		
		test obj3 = obj.new test();
		obj3.a = "132";
		obj3.b = "142";
		obj.pq.add(obj3);
		
		test obj2 = obj.new test();
		obj2.a = "13";
		obj2.b = "14";
		obj.pq.add(obj2);
		

		test obj4 = obj.new test();
		obj4.a = "1";
		obj4.b = "3";
		obj.pq.add(obj4);
		
		
		
		
		while(!obj.pq.isEmpty()) {
			System.out.println(obj.pq.poll().a);
		}
	}
}
