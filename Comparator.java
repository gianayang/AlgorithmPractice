//Implementing natural ordering from Interface Comparable
//override Compare To method
class MyInteger implements Comparable<MyInteger>{
    private int value;
    public MyInteger(int value){
        this.value=value;
    }
    @Override
    public int compareTo(MyInteger another){
        if(this.equals(another)){
            return 0;
        }
        return this.value>another.value?-1:1;
    }
}

//Provide Top-level class implements from Interface Comparable
//and override Compare(E e1,E e2)method
//PriorityQueue<MyInteger>pq =  new PriorityQueue<>();
class MyInteger{
    private int value;
    public MyInteger(int value){
        this.value=value;
    }
}

class MyComparator implements Comparator<MyInteger>{
    @Override
    public int compare(MyInteger o1,MyInteger o2){
        return Integer.valueOf(o2.value).compareTo(o1.value);
    }
}

//static nested class override Compare method
//PriorityQueue<MyInteger>pq = new PriorityQueue<MyInteger>(new MyInteger.MyComparator));
class MyInteger{
    public int value;
    public MyInteger(int value){
        this.value=value;
    }
    static class MyComparator implements Comparator<MyInteger>{
        @Override
        public int compare(MyInteger o1,MyInteger o2){
            if(o1.value==o2.value){
                return 0;
            }
            return o1.value>o2.value ? -1:1;
        }
    }
}


//java 8
//PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder));
PriorityQueue<MyInteger> pq = new PriorityQueue<>((s1,s2)->
s1.value < s2.value? 1:s1.value>s2.value?-1:0);

PriorityQueue<MyInteger> pq = new PriorityQueue<>((s1,s2)->
Integer.valueOf(s2.value).compareTo(s1.value));