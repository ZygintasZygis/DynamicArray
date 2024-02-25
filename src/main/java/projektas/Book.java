/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektas;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author zygis
 */
public class Book implements classInterface<Book>{
    private String name;
    private String category;
    private double price;
    private String author;
    private int pageNumber;
    private int printYear;
    
    public Book(){}
    
    public Book(String n, String c, double pr, String a, int pn, int py){
        this.name = n;
        this.category = c;
        this.price = pr;
        this.author = a;
        this.pageNumber = pn;
        this.printYear = py;
    }
    
    public Book(String stringData){
        this.parse(stringData);
    }
    
    @Override
    public final void parse(String d){
        try{
            Scanner sc = new Scanner(d);
            this.name = sc.next();
            this.category = sc.next();
            this.price = sc.nextDouble();
            this.author = sc.next();
            this.pageNumber = sc.nextInt();
            this.printYear = sc.nextInt();
        }catch(InputMismatchException  e){
            System.out.println("Blogas duomenu formatas apie knyga -->" + d);
        }catch(NoSuchElementException e){
            System.out.println("Trūksta duomenų apie knyga -> " + d);
        }
    }
    
    @Override
    public Book create(String data){
        Book temporaryBook = new Book();
        temporaryBook.parse(data);
        return temporaryBook;
    }
    
     public String getCategory(){
        return category;
    }
    public int getPrintYear(){
        return printYear;
    }
    public int getPageNumber(){
        return pageNumber;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public String getAuthor(){
        return author;
    }

    @Override
    public int compareTo(Book o) {
        return getName().compareTo(o.getName());
    }
    
    @Override
    public String toString(){
        return String.format("%-8s %-8s %5f %-8s %4d %4d",
				name, category, price, author, pageNumber, printYear);
    }
    
    public final static Comparator<Book> pagalKategorijaKaina = (Book o1, Book o2) -> {
        int a = o1.getCategory().compareTo(o2.getCategory());
        if(a > 0) return 1;
        if(a < 0) return -1;
        if(a == 0 && o1.getPrintYear() > o2.getPrintYear()) return 1;
        if(a == 0 && o1.getPrintYear() < o2.getPrintYear()) return -1;
        if(a == 0 && o1.getPrintYear() == o2.getPrintYear()) return 0;
        return -1;
    };
}
