package work4.js.B;

public class M {
        private String name;
        private char sex;//char 字符型
        private int age;
        //定义: : -个保护类型字符串属性skill，同时赋值为"唐门暗器"
//此处请补全代码
        protected String skill="唐门暗器";
        //带name、sex、age 3个参数的构造方法
        public M(String name, char sex, int age) {
                this.name = name;
                this.sex = sex;
                this.age = age;
        }
        //输出name、sex、age 3个参数的output方法
        public void output() {
                System.out.println("姓名："+name+"性别"+sex+"年龄"+age);
        }
    }

