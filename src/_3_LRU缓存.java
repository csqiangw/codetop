//Java中的LinkedHashMap 也就是Hash双链表

import java.util.HashMap;

/**
 * 要求：
 * 1.get 根据key获取值，并且key获取值后要更新其最近使用时间，需要在O（1）的时间完成
 * 2.put 将给定的k v放入，key不存在则直接放，但也要更新为最近使用，若给定k存在，则更新v值，也要更新为最近使用，需要在O（1）时间完成，若容量满，则需要逐出最久未用
 * 解决：
 * 1.O（1）查找借助Hash
 * 2.O（1）逐出借助双向链表 无需找前驱
 * 3.新加入的放入尾部
 * 4.被使用的调整到尾部
 */
public class _3_LRU缓存 {

    public int capacity;
    public HashMap<Integer,Node> map;
    public Node head,tail;

    public _3_LRU缓存(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        //先初始化头尾辅助节点，方便统一链表操作
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;//没有则返回-1
        }else{
            improve(key);
            return map.get(key).v;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).v = value;//重新赋值
            //提升首位度
            improve(key);
            return;
        }
        if(map.size() == this.capacity){//容量满，逐出
            //头部逐出
            map.remove(deleteHead());
        }
        //插入到尾部
        Node node = new Node(key,value);
        map.put(key,node);
        insertTail(node);
    }

    public void improve(int key){
        //有的话要提升首位度  头低 尾部高
        Node node = map.get(key);
        //先取下节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //调整到尾部
        insertTail(node);
    }

    public int deleteHead(){
        Node node = head.next;
        head.next = node.next;
        node.next.pre = head;
        return node.k;
    }

    public void insertTail(Node node){
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    class Node{
        public Node pre,next;
        public int k,v;
        public Node(int k,int v){
            this.k = k;
            this.v = v;
        }
    }

}
