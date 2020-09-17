package letcode;

import java.util.List;

public class SingleLinkedList_01 {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(4, "熊浩", "昊天");
        SingleLinkedList list = new SingleLinkedList();
        list.add(node1);
        list.add(node4);
        list.add(node3);
        list.add(node2);
        list.addOrder(node1);
        list.addOrder(node4);
        list.addOrder(node3);
        list.addOrder(node2);
        list.show();
        list.update(node5);//注意修改的时候不能改编号
        System.out.println("===================");
        list.show();
        System.out.println("===================");
        list.delete(node3);
        list.show();
        System.out.println(list.getCount());
        System.out.println(list.getHeroNode(1));
        list.show();
        System.out.println(list.getKthFromEnd(node1, 2));
    }
}
    //创建单链表类
      class SingleLinkedList{
        private HeroNode head = new HeroNode(0,"","");
        //单链表的增加（无序）

        /**
         * 在list末尾添加元素
         * @param heroNode
         */
        public void add(HeroNode heroNode) {
            HeroNode tmp=head;//因为头节点不能动，所以要用到我们辅助节点；
            while(true){
                if(tmp.next==null){
                    break;
                }
                tmp=tmp.next;
            }
            tmp.next=heroNode;
        }

        /**
         * list里面按照顺序添加（重要）第二种添加英雄的方式，根据排名将英雄插入到指定的位置
         * @param heroNode
         */
        public  void addOrder(HeroNode heroNode){
            HeroNode tmp =head;//因为头节点不能动，所以要用到我们辅助节点；
            boolean flag=false;//标志和添加的节点和链表中节点的编号没有重复
            while(true){
                if(tmp.next==null){
                    break;
                }
                if(tmp.next.no>heroNode.no){//找到比自己小的才能插入
                    break;
                }else if(tmp.next.no==heroNode.no){
                    flag=true;
                    break;
                }
                tmp=tmp.next;
            }
            if(flag){
                System.out.println("节点已经存在");//是根据节点编号去判断存在
            }else{
              heroNode.next=tmp.next;
              tmp.next=heroNode;
            }
        }

        /**
         * 删除指定节点
         * @param heroNode
         */
         public void delete(HeroNode heroNode){
             HeroNode tmp =head;//因为头节点不能动，所以要用到我们辅助节点；
             boolean flag=false; //标志有没有那个节点
             while(true){
                 if(tmp.next==null){
                     break;
                 }
                 if(tmp.next.no == heroNode.no){
                     flag=true;
                     break;
                 }
                 tmp=tmp.next;
             }
             if(flag){
                 tmp.next=tmp.next.next;
             }else {
                 System.out.println("没有这个节点去删除");
             }
         }
        /**
         * 修改某个节点的信息，但是不能改编号
         * @param heroNode
         */
        public void update(HeroNode heroNode){
            HeroNode tmp =head;//因为头节点不能动，所以要用到我们辅助节点；
            boolean flag=false; //标志有没有那个节点
            while(true){//退出循环的时候就代表找到相应的节点了tmp.next
                if (tmp.next==null) {
                    break;
                }
                if(tmp.next.no==heroNode.no){//找到这个节点
                    flag=true;
                    break;
                }
                tmp=tmp.next;
            }
            if (flag) {
                tmp.next.name=heroNode.name;
                tmp.next.nickName=heroNode.nickName;
            }else{
                System.out.println("没有找到这个节点");
            }
        }
        /**
         * 显示出来我们的list
         */
        public void show(){
            if(head.next==null){
                System.out.println("链表为空");
            }
            HeroNode tmp = head;
            while(true){
            if(tmp.next==null){
                break;
            }
            tmp=tmp.next;
            System.out.println(tmp);
        }
    }

        /**
         * 求出头节点所在的单链表的节点个数
         * @return int
         */

         public int getCount() {
            HeroNode tmp =head;
            int count=0;
            while (true){
                if(tmp.next==null){
                    break;
                }
                count++;
                tmp=tmp.next;
            }

            return count;
         }

        /**
         *求链表中的倒数第k个节点
         * @return
         */
         public HeroNode getHeroNode(int k){//分析， 我们必须得到总的个数 size ;就是我们上面方法得到的值
             HeroNode temp = head;
             int size=getCount();
             if(temp.next==null){
                 System.out.println("空链表");
             }
             if(size-k<0){
              throw new RuntimeException("k之前没有节点");
             }
             int count=0;//记录循环的时候到哪个位置了
             while(true){
                 temp=temp.next;
                 count++;
                 if(count==(size-k)+1){
                     break;
                 }
             }
             return temp;
         }
        /**
         *输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
         * 本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
         * 从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
         * @return
         */
          //解题思路：快慢指针
        public HeroNode getKthFromEnd(HeroNode head, int k) {
            HeroNode node1 = head, node2 = head;
            while (node1 != null && k > 0) {

                node1 = node1.next;
                k--;
            }
            while (node1 != null) {

                node1 = node1.next;
                node2 = node2.next;
            }

            return node2;
        }
    }


    //创建heroNoed （英雄）类；
    class HeroNode {
        public int no;//编号
        public String name;//姓名
        public String nickName;//昵称
        public HeroNode next;//下一个节点

        //构造器
        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\''+'}' ;
        }
    }

