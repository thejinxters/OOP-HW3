/**
* SubmissionQueue.java
* 
* A FIFO Queue for handling submissions.
*/


import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class SubmissionQueue
{
	private PriorityBlockingQueue<Submission> internalQueue;
	public boolean add(Submission s){
		return internalQueue.add(s);
	}
	public boolean process(){
		Submission target;
		try{target = internalQueue.take();}
		catch(InterruptedException e){
			//oh no
			System.err.println(e);
			return false;
		};
		//do some stuff
		if(target == null) return false;
		return true;
	}
	public SubmissionQueue(){
		internalQueue = new PriorityBlockingQueue<Submission>();
	}
}