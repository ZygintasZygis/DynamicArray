/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package projektas;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author zygis
 * @param <E>
 */
public class DynamicArray<E> implements nodeInterface<E>{

    private Object[] array;
    private int capacity;
    private int size;
    
    /**
     *
     * @param element
     */
    public DynamicArray(E element){
        size = 0;
        capacity = 10;
        array = new Object[capacity];
    }
    
    @Override
    public void add(E e) {
        if(size == capacity){
            int newcap = capacity*2;
            growSize(newcap);
        }
        array[size++] = e;
        shrinkSize();
    }
    
    @Override
    public void growSize(int newcap){
        if(newcap > capacity){
            int i = 0;
            Object[] temporary = new Object[newcap];
            for(Object obj : array){
                temporary[i++] = obj;
            }
            array = temporary;
            capacity = newcap;
        }
    }
    
    @Override
    public int size() {
        return size; 
    }
    
    public int capacity(){
        return capacity;
    }
    
    @Override
    public void shrinkSize(){
        Object[] temp = null;
        if(size > 0){
            temp = new Object[size];
            System.arraycopy(array, 0, temp, 0, size);
        }
        capacity = size;
        array = temp;
    }


    @Override
    public E get(int k) {
       return (E)array[k]; 
    }

    @Override
    public void remove(int a) {
        if( -1 < a && a < size){
            for(int i = a; i < size-1; i++){
                if(a == array.length-1){
                    array[i] = null;
                    break;
                }
                array[i] = array[i+1];
            }
            size--;
            shrinkSize();
        }
    }

    @Override
    public boolean contains(Object o) { //KAIP SI METODA DARYTI SU OBJECT CLASSE IR KLASE TIKRINTI NE BOOK O GENERIC
        //nes juk galima nebutinai tikrinti Book klases objektus.
        if(o instanceof Book){
            Book temp = (Book)o;
            for(int i = 0; i < size; i++){
                Book booksFromArray = (Book)array[i];
                if(booksFromArray.getName().equals(temp.getName())){
                    return true;
                }
            }
        }else{
            System.out.println("Blogas duomenu formatas!!!");
        }
        return false; 
    }
    
    @Override
   public void insert(E obj,int ind){
       if(-1 < ind && ind < size){
           if(size == capacity){
               growSize(capacity*2);
           }
           if(size-1 == ind){
               add(obj);
               return;
           }
           for(int i = size; i > ind; i--){
               array[i] = array[i-1];
           }
           array[ind] = obj;
           size++;
           shrinkSize();
       }else{
           System.out.println("!!!!!!!!!Neteisingai ivestas indeksas!!!!!!!!!");
       }
   }
   
   @Override
   public int getIndex(E obj){ //Kaip lyginti objektus kurie yra OBJECT klases o ne nurodytos...
       Book aa = new Book();
       Book cc = (Book)obj;
       for(int i = 0; i < size; i++){
           Object e = array[i];
           if(e.getClass() == aa.getClass()){
               Book bb = (Book)e;
               if(bb.compareTo(cc) == 0){
               return i;
           } 
           }
       }
       return -1;
   }
   
   public Object[] getArray(){
       return array;
   }
   
   @Override
   public void sort(Comparator<E> c){
       Arrays.sort(array,(Comparator)c);
   }
   
   @Override
   public void clear(){
       size = 0;
       capacity = 0;
       array = null;
   }
   
}
