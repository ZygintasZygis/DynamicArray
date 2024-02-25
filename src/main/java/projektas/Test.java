/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektas;

import java.util.Scanner;

/**
 *
 * @author zygis
 */
public class Test {
    
    
    public static void main(String... args) {
        
        Book book1 = new Book("Book1", "CategoryA", (double)(Math.random()*(40-10)+10), "Author1",
                (int)(Math.random()*(700-300)+300), (int)(Math.random()*(2023-2000)+2000));
        Book book2 = new Book("Book2", "CategoryA", (double)(Math.random()*(40-10)+10), "Author2",
                (int)(Math.random()*(700-300)+300), (int)(Math.random()*(2023-2000)+2000));
        Book book3 = new Book("Book3", "CategoryA", (double)(Math.random()*(40-10)+10), "Author3",
                (int)(Math.random()*(700-300)+300), (int)(Math.random()*(2023-2000)+2000));
        Book book4 = new Book("Book4", "CategoryD", (double)(Math.random()*(40-10)+10), "Author4",
                (int)(Math.random()*(700-300)+300), (int)(Math.random()*(2023-2000)+2000));
        Book book5 = new Book("Book5", "CategoryD", (double)(Math.random()*(40-10)+10), "Author5", 
                (int)(Math.random()*(700-300)+300), (int)(Math.random()*(2023-2000)+2000));
        Book book6 = new Book("Book6", "CategoryB", (double)(Math.random()*(40-10)+10), "Author6", 
                (int)(Math.random()*(700-300)+300), (int)(Math.random()*(2023-2000)+2000));
        Book book7 = new Book("Book7", "CategoryZ", (double)(Math.random()*(40-10)+10), "Author7", 
                (int)(Math.random()*(700-300)+300), (int)(Math.random()*(2023-2000)+2000));
        Book book8 = new Book("Book8", "CategoryB", (double)(Math.random()*(40-10)+10), "Author8", 
                (int)(Math.random()*(700-300)+300), (int)(Math.random()*(2023-2000)+2000));
        
        DynamicArray list = new DynamicArray(new Book());
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        list.add(book5);
        list.add(book6);
        list.add(book7);
        list.add(book8);
        
        System.out.println("Knygu sarasas: ");
        int k = 1;
        for(int i=0;i<list.size();i++){
            System.out.println(k++ +"."+" "+ list.getArray()[i].toString());
        }
        System.out.println("Knygu saraso elementu skaicius - " + list.size());
        System.out.println("Knygu saraso talpa - " + list.capacity());
        
        
        System.out.println();
        System.out.println("Iveskite elementa kuri norite istrinti: ");
        Scanner sc = new Scanner(System.in);
        String deletable = sc.nextLine();
        Book deleteBook = new Book(deletable);
        int tempInd = list.getIndex(deleteBook); //PANAUDOTAS getIndex metodas.
        list.remove(tempInd);
	System.out.println("Sarasas po istrynimo.");
        int kk = 1;
        for(int i=0;i<list.size();i++){
            System.out.println(kk++ +"."+" "+ list.getArray()[i].toString());
        }
        System.out.println("Knygu saraso elementu skaicius - " + list.size());
        System.out.println("Knygu saraso talpa - " + list.capacity());
        System.out.println();
        
        System.out.println("Iveskite elementa kuri norite patikrinti: ");
        String search = sc.nextLine();
        Book tempBook = new Book(search);
        boolean yesno = list.contains(tempBook);
        if(yesno){
            System.out.println(tempBook.toString() + "--" + " " + "!!!!! knyga rasta !!!!!");
        }else{
            System.out.println("!!!!!! Knyga nerasta !!!!!!!!");
        }
        
        System.out.println();
        System.out.println("Iveskite knyga, kuria papildysite sarasa bei indeksa");
        String band = sc.nextLine();
        int ind5 = sc.nextInt();
        Book newBook = new Book(band);
        list.insert(newBook, ind5);
        int kkk = 1;
        for(int i=0;i<list.size();i++){
            System.out.println(kkk++ +"."+" "+ list.getArray()[i].toString());
        }
        System.out.println("Knygu saraso elementu skaicius - " + list.size());
        System.out.println("Knygu saraso talpa - " + list.capacity());
        System.out.println();
        
        System.out.println("Surikiuotas sarasas pagal kategorija ir spausdinimo metus.");
        list.sort(Book.pagalKategorijaKaina);
        int kkkk = 1;
        for(int i=0;i<list.size();i++){
            System.out.println(kkkk++ +"."+" "+ list.getArray()[i].toString());
        }
        
        System.out.println();
        System.out.println("Sarasas po istrynimo.");
        list.clear();
        System.out.println("Knygu saraso elementu kiekis - " + " " + list.size());
        System.out.println("Knygu saraso talpa - " + " " + list.capacity());
	}
}
