import java.util.NoSuchElementException;

/**
 * 
 */
public class LinkedList
{
   /**
    * Removes the first element in the linked list.
      @return the removed element
   */
   private Node first;
   public LinkedList()
   {
       first = null;
   }
  



   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {
       Node newNode = new Node();
       newNode.data = element;
       newNode.next = first;
       first = newNode;
   }

   public Object removeFirst()
   {
       try {
           Object temp = first.data;
           first = first.next;
           return temp;
        }
        catch(NullPointerException e)
        {
            throw new NoSuchElementException();
        }
   }


   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public Object getFirst()
   {
       try {
           return first.data;
        }
        catch(NullPointerException e)
        {
            throw new NoSuchElementException();
        }
   }
   
   public ListIterator listIterator()
   {
       return new LinkedListIterator();
   }
   
   public int size()
   {
       return size(first);
   }

   public int size(Node start)
   {
       if(start.next == null)
       {
           return 1;
       }
       return 1 + size(start.next);
   }
   
   
   public Node getNode(int index)
   {
       int count = 0;
       if(index >= size())
       {
           throw new NoSuchElementException();
       }
       Node temp = first;
       while(count < index)
       {
           count++;
           temp = temp.next;
       }
       return temp;
   }
   
   public Object get(int index)
   {
       Node current = getNode(index);
       return current.data;
   }
   
   public void set(int index, Object o)
   {
       Node current = getNode(index);
       current.data = o;
   }
   
   public boolean contains(Object o)
   {
       Node temp = first;
       while(temp != null)
       {
           if(temp.data.equals(o))
           {
               return true;
           }
           temp = temp.next;
       }
       return false;
   }
   
   /*
    * Abhinav Chowdavarapu
    * 9/30/2019
    */
   
   public void reverse()
      {     
          if(first.next == null || first == null)     
          {          
              return;     
           }
          Node tempfirst = first;
          Node current = first;     
          while(current.next != null)     
          {          
              Node temp1 = current;          
              Node temp2 = current.next;          
              temp2.next = temp1;     }     
          first.next = null;          
          first = current;
      }
   //Class Node
   class Node
   {
       public Object data;//this object
       public Node next;
   }

   class LinkedListIterator implements ListIterator
   {
      //private data
      private Node position;
      private Node previous;
      private boolean isAfterNext;
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
          position = null;
          previous = null;
          isAfterNext = false;
      }
      
      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
          if(!hasNext())
          {
              throw new NoSuchElementException();
          }
          previous = position;
          isAfterNext = true;
          if(position == null)
          {
              position = first;
          }
          else
          {
              position = position.next;
          }
          return position.data;
      }

      


      /**
         Tests if there is an element after the iterator position.
         @return true if there is an element after the iterator position
      */
      public boolean hasNext()
      {
          if(position == null)
          {
              return first != null;
          }
          else
          {
              return position.next != null;
          }
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */

      public void add(Object o)
      {
          if(position == null)
          {
              addFirst(o);
              position = first;
              previous = null;
          }
          else
          {
              Node newBoi = new Node();
              newBoi.data = o;
              newBoi.next = position.next;
              position.next = newBoi;
              position = newBoi;
          }
          isAfterNext = false;
      }



      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
          if(!isAfterNext){throw new IllegalStateException();}
          
          if(position == first)
          {
              removeFirst();
          }
          else
          {
              previous.next = position.next;
          }
          position = previous;
          isAfterNext = false;
      }






      /**
         Sets the last traversed element to a different value.
         @param element the element to set
      */

      public void set(Object o)
      {
          if(!isAfterNext)
          {
              throw new IllegalStateException();
          }
          position.data = o;
      }

      
   }//LinkedListIterator
}//LinkedList
