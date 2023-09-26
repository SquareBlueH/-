package work4.js.A;

public class RoLe extends M      {
    protected String skill; // 新增属性skill,隐藏继承的成员变量skill
    private long id;
    public RoLe(String name,char sex, int age, long id, String skill) {
        super(name,sex,age);
        this.id=id;
        this.skill=super.skill+"历史最高："+skill;
    }

    public void output() {
        super.output();
        System.out.print("老老实实的理科生\n"+" 期末成绩第"+id +"\n其中数学成绩，" +this.skill);
        //Code -Override Methods点击
    }
}