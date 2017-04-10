package test;

import java.util.*;
import java.lang.*;
import test.Database.PriorityStructure;

public class Test {
    public static void main(String[] args) {
        Database db = new Database();
        //Create 3 users
        UserAccount user1 = new UserAccount(new String[]{
            "user1",
            "fs3fs3rtbs",
            "892519288",
            "522 PowerPunch Rd",
            "fuaco@hotmail.com"
        });        
        UserAccount user2 = new UserAccount(new String[]{
            "user2",
            "ge23fw",
            "192851822",
            "Gibby Bath Drive",
            "fuaco@hotmail.com"
        });
        UserAccount user3 = new UserAccount(new String[]{
            "user3",
            "awdawf",
            "41591829",
            "12 Eggs Street",
            "fuaco@hotmail.com"
        } );
        
        String[] problemList = {
            "Utility Failures", "Potholes","City Property Vandalism",
            "Eroded Streets", "Tree Collapse", "Flooded Streets",
            "Mould and Spore Growth", "Garbage or any other Road Blocking Objects"
        };
        String[] addressList = {
            "1st Street", "2nd Street", "3rd Street", "4th Street", "5th Street"
        };
        String[] ownerList = {
            "user1","user2","user3"
        };
        
        Random rand = new Random();
        for (int i = 0; i < 50; i++){
            String problem = problemList[rand.nextInt(problemList.length)];
            String address = addressList[rand.nextInt(addressList.length)];
            String owner = ownerList[rand.nextInt(ownerList.length)];
            Report report = new Report(new String[]{problem, address, owner});
            db.addReport(report);
        }
        
        ArrayList<Report> history1 = db.getUsersReport("user1");
        System.out.println("            User 1 history:");
        for (Report item: history1){
            System.out.println(item.getAddress() +" :   "+
                                item.getConcern());
        }
        ArrayList<Report> history2 = db.getUsersReport("user2");
        System.out.println("            User 2 history:");
        for (Report item: history2){
            System.out.println(item.getAddress() +" :   "+
                                item.getConcern());
        }
        ArrayList<Report> history3 = db.getUsersReport("user3");
        System.out.println("            User 3 history:");
        for (Report item: history3){
            System.out.println(item.getAddress() +" :   "+
                                item.getConcern());
        }
        System.out.println("DELETING USER 1 PROFILE AND REPORTS");
        db.deleteUser("user1");
        UserAccount getUser = db.getUser("user1");
        history1 = db.getUsersReport("user1");
        System.out.print("User1 has no profile? ");
        System.out.println(getUser == null);
        System.out.print("User1 has no history? ");
        System.out.println(history1 == null);
        
    }

    
}














