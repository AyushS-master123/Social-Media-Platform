import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class User{
    private String username;
    private String password;
    private List<Post>posts;

    public User(String username, String password){
        this.username=username;
        this.password=password;
        this.posts=new ArrayList<>();
    }
}
public class SocialMedia{
    private Scanner sc;
    //This is a database that will store the details of the users.
    private Map <String,User>users;
    //This is a object of the class user so that we can access the user to register, login, and creating a new post.
    private User currentUser;
    //Social media is a constructor used to initialze everything.
    public SocialMedia(){
        //We initalized the empty users database.
        this.users=new HashMap<>();
        this.sc=new Scanner(System.in);
    }


    public void RegisterUser(String username,String password){
        //It is checking is the users database does not contain a particular username then we will register the user.
        if(!users.containsKey(username)){
            users.put(username,new User(username,password));
            System.out.println("Registration is successful.");
        }
        else{
            System.out.println("Username already exists. Please choose a diffrent username.");
        }
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
                case 2:
                    System.out.println("Enter a username");
                    String username=sc.nextLine();
                    System.out.println("Enter a password");
                    String password=sc.nextLine();
                    login(username,password);
                    break;
                case 3:
                    if(currentuser!=null){
                        System.out.println("Enter your text post");
                        String textcontent=sc.nextLine();
                        System.out.println("Enter hashtags(comma seperated)");
                        String hashtags=sc.nextLine();
                        List<String>hashtagsList=new ArrayList<>();
                        String[] hashtagsArray=hashtags.split(",");
                        for(String hashtag: hashtagsArray){
                            hashtagsList.add(hashtag.trim());
                        }
                        createTextPost(textcontent,hashtagsList);
                        

                    }
                    else{
                        System.out.println("Please log in to create a post");
                    }
                    break;
                case 4:
                    if(currentuser!=null){
                        System.out.println("Enter your image post title");
                        String imagePostTitle=sc.nextLine();
                        System.out.println("Enter your image url");
                        String imageUrl=sc.nextLine();
                        System.out.println("Enter your image post description");
                        String imageDescription=sc.nextLine();
                        createimagepost(imagePostTitle,imageUrl,imageDescription);

                    }
                    else{
                        System.out.println("Please log out to create a post");

                    }
                    break;
                case 5:
                    viewPosts();
                    break;
                case 6:
                    exit=true;
                    System.out.println("Exiting social media platform");
                    break;
                default:
                    System.out.println("Invalid choice. Please try aagain!");
                    break;

            }
        }
    }
}

