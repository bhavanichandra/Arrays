
package queues;

import java.util.Arrays;

/**
 *
 * @author Bhavani_Chandra
 */
public class Queues  {

    private String[] queue;
    private int queueSize;
    private int front, end, noOfItems=0;

    public Queues(int size) {
        
        queueSize = size;
        queue = new String[size];       
    }
    
    public void insert(String input){
        if(noOfItems +1 <=queueSize){
            queue[end++] = input;
            noOfItems++;
            System.out.println("INSERT " + input + " to the queue");
        }
        else{
            System.out.println("Queue is full ");
        }
    }
    
    public void remove(){
        if(noOfItems >= 0){
            System.out.println("REMOVE " + queue[front] + " removed");
            for(int i=front;i<=end;i++ ){
                queue[i] = queue[i+1];
            }
            //queue[front] = "-1";
            noOfItems--;
            end--;
        }
        else{
            System.out.println("Queue is empty");
        }
    }
    public void peek(){
        
        if(noOfItems < 0){
            return;
        }
        System.out.println("PEEK: " + queue[front] + " is at front of queue");        
    }
    
    public void displayQueue() {
        System.out.print("[");
        for(int i=0; i<end;i++){
            System.out.print(queue[i] + " ");
        }
        System.out.print("]");
    }
    
    public void priorityInsert(String input){
        
        int i;
        if(noOfItems == 0){
            insert(input);
        }else{
            for(i = noOfItems-1;i>=0;i--){
                if(queue[i].compareToIgnoreCase(input) > 0){
                    queue[i+1] = queue[i];
                }else break;
            }
            queue[i+1] = input;
            end++;
            noOfItems++;  
        }
    }
    public static void main(String[] args) {
        Queues queue = new Queues(10);
        queue.insert("bhavani");
        queue.insert("ravi");
        queue.insert("raju");
        queue.remove();
        queue.insert("chandra");
        queue.insert("ram");
        queue.remove();
        queue.remove();
        queue.peek();
        queue.displayQueue();
        
    }
    
}
