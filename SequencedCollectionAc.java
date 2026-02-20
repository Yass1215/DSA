/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dns;

import java.util.LinkedList;
import java.util.SequencedCollection;

public class SequencedCollectionAc {

    public SequencedCollectionAc(){
        SequencedCollection sc = new LinkedList();
        sc.addFirst(5);
        sc.addFirst(2);
        sc.addLast(3);
        sc.addLast(4);
        System.out.println(sc.getFirst());
        System.out.println(sc.removeLast());
        System.out.println((sc));
        System.out.println(sc.reversed());
        
    }
    public static void main(String[] args) {
        new SequencedCollectionAc();
    }
    
}

