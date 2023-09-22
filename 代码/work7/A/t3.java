package A;

import java.util.LinkedList;
class Block {
    String name;
    boolean mine=false;
    public void setName(String name) {
        this.name=name;// 将参数name传值给成员变量
    }
    public String getName() {
        return name;// 返回成员变量name
    }
    boolean isMine( ) {
        return mine;// 返回成员变量Mine
    }
    public void setMine(boolean mine) {
        this.mine=mine;// 将参数mine传值给成员变量mine
    }
}
public class t3 {
    public static void main(String[] args) {
        int mine=25;
        Block[][] block =new Block[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
               block[i][j]=new Block();     //初始化block[i][j]
            }
        }
        LinkedList<Block> list= new LinkedList<>();// 创建LinkList泛型对象list
        for(int i=0;i<8;i++) {
            for(int j = 7; j >= 0; j--) {
            list.add(block[i][j]);   //将block[i][j]添加到list
            }
        }
        while(mine>=0) {
            int size=list.size();// 返回list中节点个数
            int randomIndex=(int)(Math.random( )*size);
            Block b=list.get(randomIndex);// 返回list中索引值为randomIndex的节点中的对象
            b.setName("@");
            b.setMine(true);
            list.remove(b);// list删除索引值为randomIndex的节点
            mine--;
        }
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if(block[i][j].isMine())//判断block[i][j]是否是地雷
                {
                    block[i][j].setName("@");
                    block[i][j].setMine(true);
                }
              else {
                    //计算非雷坐标的周围存在的地雷个数，并将个数设置为name
                    int mineNumber=0;
                    for(int k=Math.max(i-1,0);k<=Math.min(i+1,7);k++) {
                        for(int t=Math.max(j-1,0);t<=Math.min(j+1,7);t++) {
                            if(block[k][t].isMine()) //判断block[k][t]是否是地雷
                            mineNumber++;
                        }
                    }
                    block[i][j].setName(""+mineNumber);//巧妙
              }
            }
        }
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                System.out.printf("%2s",block[i][j].getName() );
            }
            System.out.println();
        }
    }
}