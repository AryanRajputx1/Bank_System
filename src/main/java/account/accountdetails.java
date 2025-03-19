package account;

public class accountdetails {
    String name ;
    int acno;
    public void accountinfo(String name ,int acno){
        this.name=name;
        this.acno=acno;
        System.out.println("[-------------------------------------------]");
        System.out.println("Welcome "+ name+" Acoount number "+ acno+" ");
        System.out.println("[--------------------------------------------]");
    }
}
