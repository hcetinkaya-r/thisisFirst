
package jvya4odev;
/**
 *
 * @author hakancetinkaya-23099-
 */
class Item {
    int key;
    String info;    
    Item next; 
    
  Item(int key,String info,Item next) {
      this.key=key;
      this.info=info;
      this.next=next;
      }
  }
class List {
    private Item list;
    public List() {
        list=null;
    }
    public void insert(int key, String info) {
        Item t=new Item(key,info,list);
        list=t;
    }
    @SuppressWarnings("NonPublicExported")
    public Item atEnd() {
        Item t;
        if(list==null) return null;
        t=list;
        while(t.next!=null) t=t.next;
        return t;
    }
    public void append(int key, String info) {
        Item t=new Item(key,info,null);
        if(list==null)
        list=t;
        else
        atEnd().next=t;
    }
    public void remove(int key) {
        Item t=list;
        if(t==null) return;
        if(t.key==key)
            list=t.next;
        else {
            Item prev=t;
            t=t.next;
        while(t!=null && t.key!=key) {
            prev=prev.next;
            t=t.next;
            }
        if(t==null) return;
        prev.next=t.next;
        }
    }
    public int length() {
        Item t=list;
        int i=0;
        while(t!=null) {
            i++;
            t=t.next;
        }
        return i;
    }
    public void display() {
        Item t=list;
        while(t!=null) {
            System.out.print(t.key+": "+t.info+" ");
            t=t.next;
        }
    }
    @SuppressWarnings("NonPublicExported")
    public Item search(int key) {
        Item t=list;
        if(t==null) return null;
        while(t!=null && t.key!=key) 
            t=t.next;
        return t;
    }
}
    public class HashSC { 
        private final List[] table;
        public HashSC(int size) { 
            table=new List[size];
            for(int i=0;i<table.length;i++)
                table[i]=new List(); 
        }
        private int hashFunction(int v) {
            return v % table.length;
        }
        public void insert(int key, String info) {
            int x=hashFunction(key);
            table[x].insert(key,info); 
        }
        @SuppressWarnings("NonPublicExported")
        public Item search(int key) {
            int x=hashFunction(key); //hash fonksiyonu sonucu x'te
            return table[x].search(key); //oradaki listede ara ve sonucu dondur          
        }
        public void display() {
            int i;
            System.out.println("-----------");
            System.out.println("Hash Table: ");
            System.out.println("-----------");
            for(i=0;i<table.length;i++)
                if(table[i] !=null) {
                    System.out.print("|" + i + "|");
                    table[i].display();
                    System.out.println();
                }
            System.out.println("------------");
        }  
    public static void main(String[] args) {
        HashSC hash=new HashSC(7);
        List l=new List();
        Item h;
        hash.insert(1224, "Ali Sari");
        hash.insert(2336, "Mehmet Beyaz");
        hash.insert(1222, "Ayşe Mavi");
        hash.insert(2334, "Ayşe Pembe");
        hash.insert(1226, "Ahmet Kara");
        hash.insert(2332, "Mehmet Sari");
        hash.insert(1228, "Ali Yeşil");
        hash.insert(1230, "Ali Turuncu");
        hash.insert(1232, "Ahmet Beyaz");
        hash.insert(1234, "Ahmet Haki");
        hash.insert(2330, "Ayşe Gri");
        hash.insert(1236, "Fatma Mavi");
        hash.insert(1238, "Mehmet Kara");
        hash.display();
        System.out.println("");
        h=hash.search(1236);
        System.out.print("Registration info [1236]: ");
        if(h!=null)
            System.out.println(h.info);
        else
            System.out.println("**no record**");
        h=hash.search(123);
        System.out.print("Registration info  [123]: ");
        if(h!=null)
            System.out.println(h.info);
        else
            System.out.println("**no record**");
        h=hash.search(2332);
        System.out.print("Registration info [2332]: ");
        if(h!=null)
            System.out.println(h.info);
        else
            System.out.println("**no record**");
        h=hash.search(2333);
        System.out.print("Registration info [2333]: ");
        if(h!=null)
            System.out.println(h.info);
        else
            System.out.println("**no record**");   
    }
 }    
    

 
    

