package org.example;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class DoublyLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }
    private class Node {
        T elem;
        Node next;
        Node prev;

        public Node(T elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
        @Override
        public String toString() {
            return elem.toString();
        }
    }

    public void insertHead(T elem) {
        Node new_elem = new Node(elem, head, null);
        if(head != null ) {
            head.prev = new_elem;
        }
        head = new_elem;
        if(tail == null) {
            tail = new_elem;
        }
        size++;
    }

    public void insertTail(T elem) {
        Node new_elem = new Node(elem, null, tail);
        if(tail != null) {
            tail.next = new_elem;
        }
        tail = new_elem;
        if(head == null) {
            head = new_elem;
        }
        size++;
    }

    public void display(){
        Node new_elem = head;
        while(new_elem != null){
            System.out.print(new_elem.elem.toString() + " ");
            new_elem = new_elem.next;
        }
        System.out.println();
    }

    public void removeHead() {
        if (size == 0) {
            System.out.println("Больше нет элементов");
        } else {
            Node new_elem = head;
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeTail() {
        if (size == 0) {
            System.out.println("Больше нет элементов");
        } else {
            Node new_elem = tail;
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void replace(T elem, int pos) {
        if (pos > size) {
            System.out.println("Недостаточно элементов");
        } else {
            Node new_elem = head;
            for (int i = 0; i < pos; i++) {
                new_elem = new_elem.next;
            }
            new_elem.elem = elem;
        }
    }

    public void sort (Comparator<T> comparator) {
        if (size >= 2) {
            Node first = head;
            while (first.next != null) {
                Node curr = first.next;
                Node min = first.next;
                while (min != null) {
                    if (comparator.compare(min.elem, curr.elem) == -1) {
                        curr = min;
                    }
                    min = min.next;
                }
                if (comparator.compare(first.elem, curr.elem) == 1) {
                    T t = first.elem;
                    first.elem = curr.elem;
                    curr.elem = t;
                }
                first = first.next;
            }
        }
    }

    public Stream<T> stream() {
        Stream.Builder<T> stream = Stream.builder();
        Node new_elem = head;
        while(new_elem != null){
            stream.add(new_elem.elem);
            new_elem = new_elem.next;
        }
        return stream.build();
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }


    public static void main(String a[]){
        DoublyLinkedList<Car> cars = new DoublyLinkedList<Car>();
        Car car1 = new Car(1990, "Ferrari");
        Car car2 = new Car(2012, "Lamborghini");
        Car car3 = new Car(2010, "Bugatti");
        Comparator<Car> comp = new CarComparator();
        cars.insertHead(car1);
        cars.insertHead(car2);
        cars.insertTail(car3);
        cars.display();
        cars.replace(car2, 10);
        cars.display();
        cars.sort(comp);
        cars.display();
    }
}