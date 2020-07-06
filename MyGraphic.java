import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JList;

public class MyGraphic  implements ActionListener{
    JFrame frame1=new JFrame();
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    TextField tf;
    Button bt;
  Store store;
    MyGraphic(Store a){
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        store=a;
        l1=new Label("Enter a number from the list below");
        l1.setBounds(50,50,250,20);
        l2=new Label("1.Add a book to the store");
        l2.setBounds(50,70,250,20);
        l3=new Label("2.Delete a book from the store");
        l3.setBounds(50,90,250,20);
        l4=new Label("3.Verify if a book is in the stock");
        l4.setBounds(50,110,250,20);
        l5=new Label("4.Add a purchase");
        l5.setBounds(50,130,250,20);
        l6=new Label("5.Delete a purchase");
        l6.setBounds(50,150,250,20);
        l7=new Label("6.Show the list of books");
        l7.setBounds(50,170,250,20);
        l8=new Label("7.Show the list of purchases");
        l8.setBounds(50,190,250,20);
        l9=new Label("8.Exit");
        l9.setBounds(50,210,250,20);
        bt=new Button("Send");
        bt.setBounds(50,270,60,30);
        bt.addActionListener(this);
        tf=new TextField();
        tf.setBounds(50,240,60,30);
        frame1.add(bt);frame1.add(l1);frame1.add(l2);frame1.add(l3);frame1.add(l4);frame1.add(l5);frame1.add(l6);frame1.add(l7);frame1.add(l8);frame1.add(l9);frame1.add(tf);
        frame1.setSize(400,400);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    { Label succes=new Label("Succesfully added");
    Label fail=new Label("Adding is failed");
    Label resultt=new Label("Enter a title of book");
    TextField tf1=new TextField();
    Label aut=new Label("Enter author");
    TextField tf2=new TextField();
    Label yearr=new Label("Add book date year");
    TextField yea=new TextField();
    Label pricee=new Label("Enter the price of book");
    TextField pri=new TextField();
    Button b1=new Button("Send");
    Button b2=new Button("Reset");
    Label titleof=new Label("Enter title of book from existing book list");
    TextField titl=new TextField();
    Button reset=new Button("Reset");
    Button send=new Button("Send");
    Label delet=new Label("Book is deleted");
    Label instock=new Label("The book is in stock");
    Label fail2=new Label("Deleting is failed");
    Label notin=new Label("Thr book is not in stock");
        try{ 
            String choice=tf.getText();
            int a=Integer.parseInt(choice);
                switch(a)
                    {
                    case 1:resultt.setBounds(50,300,250,30);
                            frame1.add(resultt);
                            tf1.setBounds(50,330,250,30);
                            frame1.add(tf1);
                            aut.setBounds(50,360,250,30);
                            frame1.add(aut);
                            tf2.setBounds(50,390,250,30);
                            frame1.add(tf2);
                            yearr.setBounds(50,420,250,30);
                            frame1.add(yearr);
                            yea.setBounds(50,450,250,30);
                            frame1.add(yea);
                            pricee.setBounds(50,480,250,30);
                            frame1.add(pricee);
                            pri.setBounds(50,510,250,30);
                            frame1.add(pri);
                            b1.setBounds(50,540,60,30);
                            b1.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                try{
                                    String title=tf1.getText();
                                    String  author=tf2.getText();
                                    int year=Integer.parseInt(yea.getText());
                                    float price=Float.parseFloat(pri.getText());
                                    store.addNewBook(title,author,price,year);
                                    succes.setBounds(50,570,250,30);
                                    frame1.add(succes);
                                    }
                                catch(Exception ee){
                                    fail.setBounds(50,570,250,30);
                                    frame1.add(fail); }
                                }
                            });
                            frame1.add(b1);
                            b2.setBounds(200,540,60,30);
                            b2.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent el) {
                                try{
                                    frame1.remove(b1);
                                    frame1.remove(resultt);
                                    frame1.remove(aut);
                                    frame1.remove(yearr);
                                    frame1.remove(tf1);
                                    frame1.remove(tf2);
                                    frame1.remove(yea);
                                    frame1.remove(pricee);
                                    frame1.remove(pri);
                                    frame1.remove(b2);
                                    frame1.remove(succes);
                                    frame1.remove(fail);
                                    tf.setText("");
                                    }
                                catch(Exception ell){};
                            }
                        });
                            frame1.add(b2);
                            break;
                    case 2:titleof.setBounds(50,300,250,30);
                            frame1.add(titleof);
                            titl.setBounds(50,330,250,30);
                            frame1.add(titl);
                            send.setBounds(50,390,60,30);
                            send.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e1){
                                try{
                                    String name=titl.getText();
                                    store.deleteBook(name);
                                    delet.setBounds(50,360,250,30);
                                    frame1.add(delet);
                                 }
                                catch(Exception e2){
                                    fail2.setBounds(50,360,250,30);
                                    frame1.add(fail);};
                                    }
                                });
                            frame1.add(send);
                            reset.setBounds(200,390,60,30);
                            reset.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ei){
                                frame1.remove(titleof);
                                frame1.remove(titl);
                                frame1.remove(send);frame1.remove(delet);
                                frame1.remove(reset);
                                tf.setText("");
                                }
                            });
                            frame1.add(reset);
                            break;

                    case 3:Label bookname=new Label("Enter the name of book");
                            bookname.setBounds(50,300,250,30);
                            frame1.add(bookname);
                            TextField namee=new TextField();
                            namee.setBounds(50,330,250,30);
                            frame1.add(namee);
                            Button seend=new Button("Send");
                            seend.setBounds(50,390,60,30);
                            frame1.add(seend);
                            seend.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent ei){
                                    String nameofbook=namee.getText().toLowerCase();
                                    if(store.inStockBook(nameofbook)){
                                        instock.setBounds(50,420,250,30);
                                        frame1.add(instock);
                                        }
                                    else {
                                        notin.setBounds(50,420,250,30);
                                        frame1.add(notin);}
                                        }
                                    });
                            Button reseet=new Button("Reset");
                            reseet.setBounds(200,390,60,30);
                            frame1.add(reseet);
                            reseet.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e2){
                                    frame1.remove(bookname);
                                    frame1.remove(namee);
                                    frame1.remove(seend);
                                    frame1.remove(reseet);
                                    frame1.remove(instock);
                                    frame1.remove(notin);
                                    tf.setText("");
                                        }
                                    });
                            break;

                    case 4:Label booknames=new Label("Enter title of book");
                            booknames.setBounds(50,300,250,30);
                            frame1.add(booknames);
                            TextField inbooknames=new TextField();
                            inbooknames.setBounds(50,330,250,30);
                            frame1.add(inbooknames);
                            Label date=new Label("Enter date in format dd-mm-yyyy");
                            date.setBounds(50,390,250,30);
                            frame1.add(date);
                            TextField indate=new TextField();
                            indate.setBounds(50,420,250,30);
                            frame1.add(indate);
                            Label succesfully=new Label("Purchase is added");
                            Button sendd=new Button("Send");
                            sendd.setBounds(50,450,60,30);
                            frame1.add(sendd);
                            sendd.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent el){
                                    String bookname=inbooknames.getText().toLowerCase();
                                    String date=indate.getText().toLowerCase();
                                    if(date.matches("^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$"))
                                    {
                                        if(store.inStockBook(bookname)){
                                            store.addPurchase(bookname, date);
                                            succesfully.setBounds(50,480,250,30);
                                            frame1.add(succesfully);
                                            }
                                        else {
                                            Label notsucces=new Label("Book is not in stock");
                                            notsucces.setBounds(50,480,250,30);
                                            frame1.add(notsucces);
                                            }
                                    }
                                    else{
                                        Label notdate=new Label("Date format is not valid");
                                        notdate.setBounds(50,480,250,30);
                                        frame1.add(notdate);
                                        }
                                }
                            });
                            Button reeset=new Button("Reset");
                            reeset.setBounds(200,450,60,30);
                            frame1.add(reeset);
                            reeset.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent eel)
                                    {frame1.remove(booknames);
                                     frame1.remove(inbooknames);
                                     frame1.remove(date);
                                     frame1.remove(indate);
                                     frame1.remove(sendd);
                                     frame1.remove(reeset);
                                     frame1.remove(succesfully);
                                     tf.setText("");
                                    }
                            });
                            break;
                    case 5:Label purchaseNotInStock=new Label("Title is not in purchase stock");
                            Label purchaseIsAdded=new Label("Purchase is succesfully added");
                            Label nameOfPurchase=new Label("Enter title of book");
                            nameOfPurchase.setBounds(50,300,250,30);
                            frame1.add(nameOfPurchase);
                            TextField inNameOfPurchase=new TextField();
                            inNameOfPurchase.setBounds(50,330,250,30);
                            frame1.add(inNameOfPurchase);
                            Button sendTitleOfPUrchase=new Button("Send");
                            sendTitleOfPUrchase.setBounds(50,390,60,30);
                            frame1.add(sendTitleOfPUrchase);
                            sendTitleOfPUrchase.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent deletepurchase)
                                    {String purchaseName=inNameOfPurchase.getText();
                                     if(store.inStockPurchase(purchaseName))
                                        {store.deletePurchase(purchaseName);
                                        purchaseIsAdded.setBounds(0,420,250,30);
                                        frame1.add(purchaseIsAdded);}
                                     else {
                                        purchaseNotInStock.setBounds(50,420,250,30);
                                        frame1.add(purchaseNotInStock);
                                        }
                                    }
                            });
                            Button resetChoice=new Button("Reset");
                            resetChoice.setBounds(200,390,60,30);
                            frame1.add(resetChoice);
                            resetChoice.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent removeDeletePurchase)
                                {
                                    frame1.remove(nameOfPurchase);
                                    frame1.remove(inNameOfPurchase);
                                    frame1.remove(sendTitleOfPUrchase);
                                    frame1.remove(resetChoice);
                                    frame1.remove(purchaseNotInStock);
                                    frame1.remove(purchaseIsAdded);
                                    tf.setText("");
                                }
                            });
                            break;
                    case 6: JFrame frame = new JFrame();
                            frame.setLayout(new FlowLayout());
                            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            Label showBooks=new Label("The books in the store");
                            showBooks.setBounds(50,300,250,30);
                            frame.add(showBooks);
                            String arrayOfBooks[]=new String[store.books.size()];
                            int i=0;
                            for(Book elements:store.books){
                                arrayOfBooks[i]=elements.getName()+" "+elements.getAuthor()+" "+elements.getPrice()+" "+elements.getYear();
                                i++;
                                }
                            JList<String> showBooksFromList=new JList<>(arrayOfBooks);
                            frame.add(new JScrollPane(showBooksFromList));
                            frame.pack();
                            frame.setVisible(true);
                            break;
                    case 7:JFrame frameForPurchasesDisplay=new JFrame();
                            frameForPurchasesDisplay.setLayout(new FlowLayout());
                            frameForPurchasesDisplay.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            Label showPurchases=new Label("The purchases in the store:");
                            showPurchases.setBounds(50,300,250,30);
                            frameForPurchasesDisplay.add(showPurchases);
                            String arrayOfPurchases[] =new String[store.purchases.size()];
                            int j=0;
                            for(Purchases purchase:store.purchases)
                                {
                                arrayOfPurchases[j]=purchase.getBook().getName()+" "+purchase.getBook().getAuthor()+" "+purchase.getBook().getPrice()+" "+purchase.getBook().getYear()+" "+purchase.getDate();
                                j++;
                                }
                            JList<String> showPurchasesFromList=new JList<>(arrayOfPurchases);
                            frameForPurchasesDisplay.add(new JScrollPane(showPurchasesFromList));
                            frameForPurchasesDisplay.pack();
                            frameForPurchasesDisplay.setVisible(true);
                            break;
                    }
        }
         catch(Exception ee){
            ee.printStackTrace();
                    }
    }
}