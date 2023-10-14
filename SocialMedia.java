import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class User{
    private String username;
    private String password;
    private List<Post>posts;

    public User(String username, String password){
        this.username=username;
        this.password=password;
        this.posts=new ArrayList<>();
    }
    public void registerUser(String username, String password){
        pass
        
    }

    public void run(){
        boolean exit=false;
        while(exit==false){
            System.out.println("Social media platform");
            System.out.println("1: Register");
            System.out.println("2: Login");
            System.out.println("3. Create text post");
            System.out.println("4: Create image post");
            System.out.println("5: View post");
            System.out.println("6: Exit");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter a username");
                    String username=sc.nextLine();
                    System.out.println("Enter a password");
                    String password=sc.nextLine();
                    registerUser(username,password);
                    break;
            }
        }
    }
}

