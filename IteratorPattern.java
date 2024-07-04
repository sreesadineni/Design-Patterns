/*The Iterator pattern is a widely used design pattern in software development that provides a way to access the elements of an aggregate
object (such as a list or collection) sequentially without exposing its underlying representation*/

// Iterator interface
import java.util.*;
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Aggregate interface
interface Aggregate<T> {
    Iterator<T> createIterator();
}

/* By creating Iterator class we are able to hide the implementation of list of objects,if there are more datstructures to traverse
client does'ny know whats happenning in the code.*/

class StudentIterator implements Iterator<Student>{
    List<Student>students;
    int currindex=0;
    public StudentIterator(List<Student>students){
        this.students=students;
    }
    public boolean hasNext(){
        return students.size()>currindex;
    }
    public Student next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return students.get(currindex++);
    }
    
}
class Student {
    String name;
    String rollnumber;
    public Student(String name,String rollnumber){
        this.name=name;
        this.rollnumber=rollnumber;
    }
    public String getName() {
        return name;
    }
}
class School implements Aggregate<Student> {
    List<Student> students;
    public School(List<Student>students){
        this.students=students;
    }
    // to get Students list
    public Iterator<Student> createIterator(){
        return new StudentIterator(students);
    }
    
}
public class IteratorPattern
{
	public static void main(String[] args) {
	    List<Student> students=Arrays.asList(new Student("sree","567"), new Student("joe","67"), new Student("james","09"),new Student("Rohan","908")); 
	    School sc=new School(students);
	    Iterator<Student>itr=sc.createIterator();
	    while(itr.hasNext()){
	       System.out.println( itr.next().getName());
	    }
	}
}
