class NoLowerLetter extends Exception {
    //[代码1] // 类声明，声明一个Exception的子类NoLowerLetter
    public  void print() { System.out.printf("%c",'#'); }
}
 class NoDigit extends Exception {// [代码2] /1 类声明声明-个Exception 的子类NoDigit
    public void print () { System.out.printf("%c",'*'); }
}
class People {
    void printLetter(char c) throws NoLowerLetter {
        if ((c >= 'a'&&c <= 'z') || (c >= 'A' && c <= 'Z')) {
            System.out.print(c);
        } else {
            NoLowerLetter noLowerLetter = new NoLowerLetter();// [代码3]// 创建NoLowerLetter类型对象
            throw (noLowerLetter);//[代码4] //抛出noLowerLetter
        }
    }
    static void printDigit(char c) throws NoDigit {

        if (c >= '0'&&c <= '9') {
            System.out.print(c);
        } else {
            NoDigit noDigit = new NoDigit(); // 创建NoDigit类型对象
            throw (noDigit);                          //抛出noDigit
        }
    }
}
public class ExceptionExample {
    public static void main(String args[]) {
        People people = new People();
        for (int i = 0; i < 128; i++) {
            try{
                    people.printLetter((char) i);
            }
            catch (NoLowerLetter e){e.print();
            }//[代码7]//捕捉并输出ASCII码1-128中的非字母异常
        }
        System.out.println();
        for (int i = 0; i < 128; i++) {
            try{
                people.printDigit((char) i);
            }catch (NoDigit e){e.print();
            }
        }
        //[代码7]//捕捉并输出ASCII码1-128 中的非数字异常
    }
}