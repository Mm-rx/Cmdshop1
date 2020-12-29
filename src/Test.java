import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        开始读文件
         */
        /*File file = new File("C:\\Users\\lenovo\\IdeaProjects\\Cmdshop1\\src\\user.xlsl");*/
        InputStream in=Class.forName("Test").getResourceAsStream("user.xlsx");
        ReadExcel readExcel = new ReadExcel();
        User users[] = readExcel.readExcel(in);

        System.out.println("请输入用户名:");

        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        System.out.println("你输入的用户名:" + username);

        System.out.println("请输入密码:");
        String password =sc.next();

        System.out.println("你输入的密码:" + password);

        for(int i=0;i<users.length;i++){
            if (username == users[i].getUsername() && password == users[i].getPassword()) {
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
        }
        for (User user : users){
            if (username == user.getUsername() && password == user.getPassword()) {
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
        }
    }
}
