import java.util.*;

import java.io.*;


class Book {
    private String name;
    private String author;
    private int year;
    private float price;
    Book(){}
    Book(String name,String author,float price,int year)
    {   
        this.name=name.toLowerCase();
        this.author=author.toLowerCase();
        this.year=year;
        this.price=price;
    }

    String getName()
    {
        return name;
    }
    String getAuthor()
    {return author;}

   int getYear()
    {return year;}

    float getPrice()
    {return price;}

    void setName(String name)
    {this.name=name.toLowerCase();}

    void setAuthor(String author)
    {this.author=author.toLowerCase();}

    void setYear(int year)
   {this.year=year;}

    void setPrice(float price)
    {this.price=price;}

    void writeBook()
    {   System.out.println();
        System.out.print(name+" ");
        System.out.print(author+" ");
        System.out.print(price+" ");
        System.out.print(year+" ");
    }

      void File()
    {
        try
        { 
            FileWriter fw=new FileWriter("book_store.txt",true);
            String namee="\n"+name+" ";
            fw.write(namee);
            String authoor=author+" ";
            fw.write(authoor);
            String pricee=String.valueOf(price)+" ";
            fw.write(pricee);
            String yearr=String.valueOf(year);
            fw.write(yearr);
            fw.close();
        }
        catch(Exception e){System.out.println("Writing failed");}
    }
}

class Purchases 
{
    private Book book;
    private String date_pur;

    Purchases(Book book,String date)
    {
        this.book=book;
        date_pur=date;
    }

    void setBook(Book book)
    {this.book=book;}

    void setDate(String date)
    {date_pur=date;}

    Book getBook()
    {return book;}

    String getDate()
    {return date_pur;}

    void writePurchases()
    {
        book.writeBook();
        System.out.print(date_pur+" ");
    }

    final public void File()
    {
        try(FileWriter fw=new FileWriter("purchases.txt",true))
        {  fw.write("\n");
             fw.write(book.getName()+" ");
            fw.write(book.getAuthor()+" ");
            fw.write(book.getPrice()+" ");
            fw.write(book.getYear()+" ");
            fw.write(date_pur);
            
        }
        catch(Exception e){System.out.println("Writing  failed");}
    }
}

public class Store 
{ 
     List<Book> books;
     List<Purchases> purchases;
     ArrayList<String> StringListOfBooks;

    Store(){
        books=new ArrayList<Book>();
        purchases=new ArrayList<Purchases>();
        
    }
    public void addBook(Book newBook)
    {  newBook.File();
        books.add(newBook); 
                            
    }
    public void addFromFile(Book newBook)
    {books.add(newBook);}

    public void addNewBook(String author, String title, float price,int year)
    {   author.toLowerCase();
        title.toLowerCase();
        Book newBook; 
        newBook = new Book(author, title, price,year);
        addBook(newBook);
    }

    public boolean inStockBook (String name)
    {
        for(Book element:books)
        {
            if(element.getName().equals(name)){
        return true;
            }
        }
        return false;  
    }

    public void addPurchase(String name,String data)
    {
        boolean found = false;
        int loper = 0;

        while ( (found == false) && (loper < books.size()) )
        {
            if (books.get(loper).getName().equals(name)) 
            {   Purchases pur=new Purchases(books.get(loper),data);
                purchases.add(pur);
                pur.File();
                removeFromFile("book_store.txt",books.get(loper).getName());
                books.remove(loper);
                found=true;
            }
            loper++;
        }
        if(!found) System.out.println("Book is not in stock");
        }
       
    public void addPurchaseFile(Book book,String data)
        { 
            Purchases purchase=new Purchases(book,data);
            purchases.add(purchase);
        }
    
    public void deleteBook(String name)
    { 
        boolean found = false;
        int loper = 0;

        while ( (found == false) && (loper < books.size()) )
        {
            if (books.get(loper).getName().equals(name)) 
                {   books.remove(loper);
                    found = true;
                   
                }
            loper++;    
        }
        removeFromFile("book_store.txt", name);
        if(!found) System.out.println("Book is not in stock");
    }

    public void removeFromFile(String file,String name)
    {
        try{
            File inFile=new File(file);
            if(!inFile.isFile()){System.out.println("Parameter is not an existing file!");
                return;}
        File tempFile=new File(inFile.getAbsolutePath()+".tmp");
        Scanner scan=new Scanner(new FileReader(file));
        PrintWriter pw=new PrintWriter(new FileWriter(tempFile));
            
        while(scan.hasNext()){
            String names=scan.nextLine();
            String split[]=names.split("\\s+");
            if(!split[0].equals(name)){
                pw.println(names);
                pw.flush();
            }
        }
        pw.close();
        scan.close();

        if(!inFile.delete())
        {System.out.println("Could not delete file!");
            return;}

        if(!tempFile.renameTo(inFile))
        {System.out.println("Could not rename file!");}}

        catch(Exception e)
        {e.printStackTrace();}
    }

    public boolean inStockPurchase(String name)
    { boolean found=false;
        int looper;
      for(looper=0;looper<purchases.size();looper++)
       {
           if(purchases.get(looper).getBook().getName().equals(name))
           {
               found=true;
           }
       }
       return found;
    }

    public void deletePurchase(String name)
    {  
        for(int i=0;i<purchases.size();i++)
        { Purchases element=purchases.get(i);
            if(element.getBook().getName().equals(name))
            {
                purchases.remove(element);
            }
        }
        removeFromFile("purchases.txt", name);
    } 

    public void showBooks()
    {   System.out.println();
        System.out.println("The list of books:");
        for(Book element:books)
        element.writeBook();
    }

    public void showPurchases()
    {
        System.out.println();
        System.out.println("The list of purchases");
        for(Purchases element:purchases)
        element.writePurchases();
    }

    static boolean isEmptyFile(String file)
    { 
        try{Scanner scaner=new Scanner(new FileReader(file));
            while(scaner.hasNextLine()){ 
                String line=scaner.nextLine();
                if(line!=null && !line.trim().isEmpty()) return false;
            }
        } catch(Exception e) {e.printStackTrace();;}
        return true;
    }

    public void readBookFromFile()
    {
        Scanner scan=new Scanner(System.in);
        try{
            Scanner scaner=new Scanner(new FileReader("book_store.txt"));
                if(!isEmptyFile("book_store.txt")){
                    while(scaner.hasNextLine()){
                        String line=scaner.nextLine();
                        if(!(line.isEmpty() || line.trim().equals("") || line.trim().equals("\n"))){
                            String split[]=line.split("\\s+");
                            String name=split[0];
                            String author=split[1];
                            float price=Float.parseFloat(split[2]);
                            int year=Integer.parseInt(split[3]);
                            Book newBook=new Book(name,author,price,year);
                            addFromFile(newBook);}
                } }
            scaner.close();}
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void readPurchaseFromFile()
    {
        try{
            Scanner scaner1=new Scanner(new FileReader("purchases.txt"));
            if(!isEmptyFile("purchases.txt")){
                do{
                    String name=scaner1.next();
                    String author=scaner1.next();
                    float price=scaner1.nextFloat();
                    int year=scaner1.nextInt();
                    Book newBook=new Book(name,author,price,year);
                    String data=scaner1.nextLine();
                    addPurchaseFile(newBook,data);
                    } while(scaner1.hasNextLine());}

            scaner1.close();}
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {  
         Store store=new Store(); 
         store.readBookFromFile();
         store.readPurchaseFromFile();

        new MyGraphic(store);
        Scanner scan=new Scanner(System.in);
        int userc;
        boolean err=true;
        do{ System.out.println();
            System.out.println();
            System.out.println("Enter a number from the list below");
            System.out.println("1.Add a book to the store");
            System.out.println("2.Delete a book from the store");
            System.out.println("3.Verify if a book is in the stock");
            System.out.println("4.Add a purchase");
            System.out.println("5.Delete a purchase");
            System.out.println("6.Show the list of books");
            System.out.println("7.Show the list of purchases");
            System.out.println("8.Exit");
            userc=scan.nextInt();

            switch(userc)
            {
        case 1: String title;
                String author;
                do{
                    err=true;
                    try{
                        do{
                            System.out.println("Add a book title");
                            title=scan.next().toLowerCase();}
                        while(!title.matches("^[A-Za-z0-9/-_,/.:;()]+$"));
                        do{
                            System.out.println("Add author");
                            author=scan.next().toLowerCase();}
                        while(!author.matches("^[a-zA-Z/-_.]+"));

                System.out.println("Add book date year");
                int year=scan.nextInt();

                System.out.println("Enter the price");
                float price=scan.nextFloat();

                store.addNewBook(title,author,price,year);}

                catch(Exception e){
                        err=false;
                        System.out.println("Adding is failed,try again");}
                } while(!err);

                System.out.println("Successfully added");
                break; 

        case 2: String title1;
               do{
                   err=true;
                   try{
                        do{
                            System.out.println("Enter title of book from existing book list");
                            title1=scan.next();}
                        while(!title1.matches("^[A-Za-z0-9/-_,/.:;()]+$"));
                        store.deleteBook(title1);
                        System.out.println("Book "+title1+" is deleted");}
                    catch(Exception e){
                       err=false;
                       System.out.println("Deleting is failed,try again");}
               } while(!err);
                System.out.println();break;

        case 3: do{
                    err=true;
                    try{
                        System.out.println("Enter book name");
                        String title2=scan.next().toLowerCase();
                        if(store.inStockBook(title2)) {
                            System.out.println("The book "+title2+" is in the stock");}
                        else{
                            System.out.println("The book "+title2+" is not in stock");}}
                    catch(Exception e){
                        err=false;
                        System.out.println("Scanning is failed,try again");;}
                    } while(!err);
                System.out.println();
                break;

        case 4: String title3;
                do{
                    err=true;
                    try{
                        System.out.println("Enter title of book");
                        title3=scan.next().toLowerCase();
                        System.out.println("Enter date in format dd-mm-yyyy");
                        String date1 = scan.next();
                        String pattern="^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$";
                        if(!date1.matches(pattern))
                            throw new Exception();
                        store.addPurchase(title3,date1);
                        System.out.println("Purchase is added");}
                    catch(Exception e){
                        err=false;
                        System.out.println("Invalid date format,try again.");}
                    } while(!err);
                break;

        case 5: do{
                    err=true;
                    try{
                        System.out.println("Enter title");
                        String title4=scan.next().toLowerCase();
                        store.deletePurchase(title4);
                        System.out.println("The book "+title4+" is deleted from purchases");}
                    catch(Exception e){
                        err=false;
                        System.out.println("Deleting is failed,try again.");}
                    } while(!err);
                break;

        case 6: store.showBooks();
                break;

        case 7: store.showPurchases();
                break;
            }
        } while(userc!=8);
        scan.close();
    } 
}


