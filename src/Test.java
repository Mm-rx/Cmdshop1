import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        boolean bo = true;
        while (bo) {
            System.out.println("请输入用户名：");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();//阻塞方法
            System.out.println("请输入密码：");
            String password = sc.next();

            //File file = new File("C:\\Users\\Administrator\\IdeaProjects\\ConsoleShop\\src\\users.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            InputStream inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();//创建对象
            User users[] = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登录成功");
                    bo = false;
                    /*
                    显示商品
                     */
                    ReadProductExcel readProductExcel = new ReadProductExcel();
                    Product products[] = readProductExcel.getAllProduct(inProduct);
                    for (Product product : products) {
                        System.out.print(product.getpID());
                        System.out.print("\t" + product.getpName());
                        System.out.print("\t" + product.getpPrice());
                        System.out.println("\t" + product.getpDescribe());
                    }
                    System.out.println("请输入商品ID把该商品加入购物车");
                    String pId = sc.next();
                    int count = 0;
                    /*
                    创建一个购物车的数组：存的是商品
                     */
                    Product carts[] = new Product[3];
                    /*
                    根据此ID去Excel中去查找是否有该ID的商品信息，如果有则返回该商品即可
                     */
                    inProduct = null;
                    inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                    Product product = readProductExcel.getProductById(pId, inProduct);
                    System.out.println("要购买的商品价格：" + product.getpPrice());
                    if(product!=null){
                        carts[count++]=product;
                    }
                    System.out.println("继续购买商品请按1");
                    System.out.println("查看购物车请按2");
                    System.out.println("继续购买请按3");
                    System.out.println("结束本次购物请按4");
                    int choose=sc.nextInt();
                    if(choose==1){
                        inProduct = null;
                        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                        readProductExcel = new ReadProductExcel();
                        products = readProductExcel.getAllProduct(inProduct);
                        for (Product p : products) {
                            System.out.print(p.getpID());
                            System.out.print("\t" + p.getpName());
                            System.out.print("\t" + p.getpPrice());
                            System.out.println("\t" + p.getpDescribe());
                        }
                        System.out.println("请输入商品ID把该商品加入购物车");
                        pId = sc.next();
                        inProduct = null;
                        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                        product = readProductExcel.getProductById(pId, inProduct);
                        System.out.println("要购买的商品价格：" + product.getpPrice());
                        if(product!=null){
                            carts[count++]=product;
                        }
                    }if(choose==2){
                        /*
                        查看购物车
                         */
                        for (Product p : carts) {
                            System.out.print(p.getpID());
                            System.out.print("\t" + p.getpName());
                            System.out.print("\t" + p.getpPrice());
                            System.out.println("\t" + p.getpDescribe());
                        }
                    }if(choose==3){
                        inProduct = null;
                        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                        readProductExcel = new ReadProductExcel();
                        products = readProductExcel.getAllProduct(inProduct);
                        for (Product p : products) {
                            System.out.print(p.getpID());
                            System.out.print("\t" + p.getpName());
                            System.out.print("\t" + p.getpPrice());
                            System.out.println("\t" + p.getpDescribe());
                        }
                        System.out.println("请输入商品ID把该商品加入购物车");
                        pId = sc.next();
                        inProduct = null;
                        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                        product = readProductExcel.getProductById(pId, inProduct);
                        System.out.println("要购买的商品价格：" + product.getpPrice());
                        if(product!=null){
                            carts[count++]=product;
                    }else if(choose==4){
                            System.out.println("刷我的卡");
                        }
                    }
                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }
}
