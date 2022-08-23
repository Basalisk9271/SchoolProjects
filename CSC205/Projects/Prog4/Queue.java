
@SuppressWarnings("unchecked")
public class Queue implements QueueInterface {
  private Node lastNode;
  private Node firstNode;
  
  public Queue() {
    lastNode = null;   
  }  // end default constructor
  
  // queue operations:
  public boolean isEmpty() {
        return (lastNode == null);
  }  // end isEmpty

  public void dequeueAll() {
    lastNode = null;
  }  // end dequeueAll

  public void enqueue(Object newItem) {
    // insert the new node
    if (isEmpty()) {
      // insertion into empty queue
      lastNode = new Node(newItem, null);  
      lastNode.setNext(lastNode);  
    }
    else {
      // insertion into nonempty queue
      Node newNode = new Node(newItem, lastNode.getNext());
      lastNode.setNext(newNode);
      lastNode = newNode;
    }  // end if
  }  // end enqueue

  public Object dequeue() throws QueueException {

     // INSERT YOUR CODE HERE to handle 3 cases : when queue is empty, has one item, and more than one item
    if (!isEmpty()){
      //Queue is not empty
      if (lastNode.getItem() == lastNode.getNext().getItem()) //Queue only has one item in it. 
      {
        Node temp = lastNode;
        lastNode = null;
        return temp.getItem();
      }//End if
      else{ //Queue has more than one item in it
        Node temp = lastNode.getNext();
        lastNode.setNext(lastNode.getNext().getNext());
        return temp.getItem();
      }
    }//End first case where the queue is empty

    else {
      throw new QueueException("QueueException on dequeue: "+
                              "Queue empty");
    }   // end if

  } 
  
  public Object peek() {
    return lastNode.getNext().getItem();
  }
  public Object front() throws QueueException {
    if (!isEmpty()) {
      Node firstNode = lastNode.getNext();
      return firstNode.getItem();
    }
    else {
      throw new QueueException("QueueException on front:"
                             + "queue empty");
    }
  }

  public Object clone() throws CloneNotSupportedException
  {
	boolean copied = false;
        Queue copy = new Queue();
        Node curr = lastNode, prev = null;
        while ( (! copied) && (lastNode != null) )
        {
                Node temp = new Node(curr.getItem());
                if (prev == null)
                        copy.lastNode = temp;
                else
                        prev.setNext(temp);
                prev = temp;
                curr = curr.getNext();
		copied = (lastNode == curr);
        }
	prev.setNext(copy.lastNode);
        return copy;
  }
} // end Queue
