package A;

import java.util.*;

class Book{
    String ISBN,name;
    Book(String ISBN,String name){
        this.ISBN=ISBN;
        this.name=name;
    }
}
public class t4{
    public static void main(String args[]){
        Scanner reader=new Scanner(System.in);

		 HashMap<String,Book> map=new HashMap<>(); //定义 HashMap泛型,对象名为hashmap，每个元素是1本书。

        System.out.println("输入4本书的书号和书名：");
        // 初始化4本书，并将他们添加进HashMap
        for (int i=0;i<4;i++){
            String isbn=reader.nextLine();
            String name=reader.nextLine();
            new Book(isbn,name);
            map.put(isbn,new Book(isbn,name));

        }
        //输出HashMap的元素个数
        System.out.println("书店中有"+map.size()+"本书: ");

        //遍历输出所有元素的ISBN和书名  //非线性迭代的方式
        Collection<Book> collection= map.values();//需检查！！！
        Iterator<Book> iter=map.values().iterator();//需检查！！！
        while(iter.hasNext()){
            Book bk=iter.next();
            System.out.println("ISBN:"+ bk.ISBN+" 书名：《"+ bk.name+"》");//无语了
        }

            /*键盘输入一个ISBN,判断该本书是否在HashMap中，
            如存在，则输出其书名，然后将它从HashMap中移除。
            如不存在则输出不存在。*/
        System.out.println("输入ISBN查找书名：");
        String key=reader.nextLine();

        if(map.containsKey(key)){
            System.out.println("《"+map.get(key).name+"》有货");//输出其书名

            Book k= map.remove(key); //从HashMap中移除该本书,并返回这本书信息给k    remove

            System.out.println("卖出《"+k.name+"》这本书后，书店还有"+map.size()+"本书");

            //遍历输出所有元素的ISBN和书名
            collection= map.values();//需检查！！！
            iter=map.values().iterator();//需检查！！！
            while(iter.hasNext()){
                Book bk=iter.next();
                System.out.println("ISBN:"+bk.ISBN+" 书名：《"+bk.name+"》");
            }
        }
        else System.out.println("书店中找不到ISBN为"+key+"的书！");
    }
}