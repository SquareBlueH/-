package A;

import java.util.*;
class Student{   //定义学生类
    String name;
    Student(String name){
        this.name=name;
    }   //构造方法

    //重写equals方法，保证只要名字相等，则认为是同一个人.
    public boolean equals(Object obj) {
        if(obj instanceof Student)
            return name.equals(((Student) obj).name);
        else return false;
    }
}
public class t2 {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        ArrayList<Student> list=new ArrayList<Student>();
        //定义 ArrayList泛型，每个元素是1个学生。
        System.out.println("输入4个学生姓名：");
        // 初始化4个学生，并将他们添加进ArrayList
        for (int i=0;i<4;i++){
            list.add(new Student(reader.nextLine()));
        }

        System.out.println("列表中还有"+ list.size()+"个学生：");

        for (int i=0;i<list.size();i++){            //遍历输出所有元素中学生的姓名
            System.out.println("第"+i+"个学生: "+list.get(i).name);
        }

		/*键盘输入一个学生姓名,判断该学生是否在列表中
        如存在，则输出其在列表中的下标，然后将它从列表中移除。*/

        System.out.println("输入要查找的人的姓名：");
        Student s =new Student(reader.nextLine());
        if(list.contains(s)){
            System.out.println("找到"+s.name+"，下标为"+ list.lastIndexOf(s));//输出下标
            list.remove(s);
            //从列表中移除该学生

            System.out.println("删除"+s.name+"后,还有"+list.size()+"个学生：");

            for (int i=0;i<list.size();i++){ //遍历输出所有元素中学生的姓名
                System.out.println("第"+i+"个学生: "+list.get(i).name);
                // System.out.println("第"+i+"个学生: "+[代码]);
            }
        }
        else System.out.println("列表中找不到"+s);  //如不存在则输出找不到。
    }
}