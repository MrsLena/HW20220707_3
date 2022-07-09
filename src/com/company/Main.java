package com.company;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        /*Предположим, что дан список Book, но в отличие от предыдущей задачи Author – класс {String fName, String lName}
        и книга более сложный объект, у которого есть список авторов, название и ISBN (International Standard Book Number)
        т.е. {String title, List<Author> authors, String ISBN}. Необходимо сформировать map<Author, List<Book>>,
        где ключ - автор, а значение список его книг.
        Естественно, если у книги несколько авторов, то книга должна отразиться в списке книг всех авторов данной книги.*/

        Author a1 = new Author("Avtor","11");
        Author a2 = new Author("Avtor","22");
        Author a3 = new Author("Avtor","33");
        Author a4 = new Author("Avtor","44");
        Author a5 = new Author("Avtor","55");

        ArrayList<Author> AllAuthors = new ArrayList<>();
        AllAuthors.add(a1);
        AllAuthors.add(a2);
        AllAuthors.add(a3);
        AllAuthors.add(a4);
        AllAuthors.add(a5);

        ArrayList<Author> GroupAuthor2 = new ArrayList<>();
        GroupAuthor2.add(a1);
        GroupAuthor2.add(a2);

        ArrayList<Author> GroupAuthor3 = new ArrayList<>();
        GroupAuthor3.add(a1);
        GroupAuthor3.add(a3);

        ArrayList<Author> GroupAuthor4 = new ArrayList<>();
        GroupAuthor4.add(a1);
        GroupAuthor4.add(a4);

        ArrayList<Author> GroupAuthor5 = new ArrayList<>();
        GroupAuthor5.add(a1);
        GroupAuthor5.add(a5);

        ArrayList<Author> GroupAuthor6 = new ArrayList<>();
        GroupAuthor6.add(a5);


        ArrayList<Book> SpBook = new ArrayList<>();
        SpBook.add(new Book("Произведение1",AllAuthors,"10001"));
        SpBook.add(new Book("Произведение2",GroupAuthor2,"10002"));
        SpBook.add(new Book("Произведение3",GroupAuthor3,"10003"));
        SpBook.add(new Book("Произведение4",GroupAuthor4,"10004"));
        SpBook.add(new Book("Произведение5",GroupAuthor5,"10005"));
        SpBook.add(new Book("Произведение6",GroupAuthor6,"10006"));
        SpBook.add(new Book("Произведение7",GroupAuthor6,"10007"));



        Map<Author, ArrayList<Book>> map = new HashMap<>();

        //for each
        for (Author a: AllAuthors) {


            ArrayList<Book> BooksOfAuthor = new ArrayList<>();

            for (Book b: SpBook) {

                int indA = b.authors.indexOf(a);
                if (indA!=-1) { //find autor in group - add book in array this author
                    BooksOfAuthor.add(b);
                }


            }


            map.put(a, BooksOfAuthor);
        }

        //System.out.println(map);
        //for good view
        Set<Map.Entry<Author, ArrayList<Book>>> element = map.entrySet();
        for(Map.Entry<Author, ArrayList<Book>> pair: element)  {
            PrintInfo(pair.getKey(),pair.getValue());
        }

    }

    public static void PrintInfo(Author a, ArrayList<Book> sp){
        System.out.println("------" + a.toString());

        for (Book tt : sp) {
            System.out.println(tt.toString());
        }
    }

}

