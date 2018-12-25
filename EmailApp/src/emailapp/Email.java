package emailapp;

import java.util.Scanner;
public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int defaultPasslen = 8;
    private int mailboxCapacity = 500;
    private String alternateEmail;   
    
    // constructor to receive first and last name
    public Email(String firstname, String lastname){
        this.firstname = firstname; // this keyword refers to the class level variable
        this.lastname = lastname;
        //System.out.println("EMAIL CREATED: " + this.firstname + " " + this.lastname);
        
        // Call a method that asks for the department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);
        
        // Call a method that generates a random password
        this.password = randomPass(defaultPasslen);
        //System.out.println("Passowrd is: " + this.password);
        
        // combine elements to generate email
        email = this.firstname.toLowerCase() +"." + this.lastname.toLowerCase() + "@" + department.toLowerCase() + ".company.com";
        //System.out.println("Email is: " + email);
    }
    // ask for which department the user is in 
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the department: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        
        switch (depChoice){
            default : return "";
            case 1 : return "Sales";
            case 2 : return "Dev";
            case 3: return "Acct";
        }
    }
    
    // generate the random password
    private String randomPass(int len){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%"; // set of characters from which a password will be generated 
        char [] pass = new char [len]; 
        for (int i = 0; i<len; i++){
            int rand = (int) (Math.random() * len); // generates a random int between 0 and len
            pass[i] = passwordSet.charAt(rand);
        }
        return new String(pass);
    }
    
    // set mailbox capacity 
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    // set alternate email
    public void setAltEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    // change the password
    public void changePassword(String password){
        this.password = password; 
    }
    
    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAltEmail(){return alternateEmail;}
    public String getPassword(){return this.password;}
    
    public String showInfo(){
        return "NAME: " + firstname + " " + lastname + " " +
                "\nCOMPANY EMAIL: " + email + " " +
                "\nMAILBOX CAPACITY: " + mailboxCapacity ;
    }
}
