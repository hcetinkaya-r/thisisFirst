
package tree;
/**
 *
 * @author hakancetinkaya
 */
class Node {
int key; //elemanin degeri
Node leftChild, rightChild; //sol ve sag elemanlarin erisim bilgileri
    
//yapici islev, parametre degerlerini ilgili oz niteliklere atar
Node(int key, Node leftChild, Node rightChild) {
    this.key=key;
    this.leftChild=leftChild;
    this.rightChild=rightChild;
    }
}

//agac veri yapisini, "ikili arama agaci" olarak tanimlayan sinif
public class Tree {

 
    private Node root; //agacin kok elemanininerisim bilgisi
    //yapici islev, koku olmayan bos bir agac tanimlar
    public Tree() {
        root=null;
    }
    
    //insert islevi, key degerine sahip elemani agaca ekler
    public void insert(int key) {
        root=insert(key,root); //ozyinelemeli ic islevi cagir
    }
    
    //parametrede verilen key degerine sahip elemani, koku t olan agaca veya alt agaca ekler.
    //ozyinelemeli ic islev, oz nitelik erisimi olmadigi icin "static"
    private static Node insert(int key, Node t) {
        if(t==null) //kok yoksa yani bu alt agac bossa
            t=new Node(key,null,null); //yeni eleman kok olsun
        else if(key<t.key) //eklenecek deger, kok elemanindan kucukse
            t.leftChild=insert(key,t.leftChild); //yeni elemani sol alt agaca ekle
        else if(key>t.key) //eklenecek deger, kok elemanindan buyukse
            t.rightChild=insert(key,t.rightChild); //yeni elemani sag alt agaca ekle
        else; //eklenecek deger, kok elemanina esitse, birsey yapma
        return t; //bu alt agacin kok eleman erisim bilgisini dondur
    }
    
    //search islevi, key degerine sahip elemani bulup erisim bilgisini verir
    public Node search(int key) {
        return search(key,root); //ozyinelemeli ic islevi cagirir
    }
    
    //parametre verilen key degerine sahip elemani, koku t olan agacin veya alt agacin altinda arar
    //ozyinelemeli ic islev, oznitelik erisimi olmadigi icin "static"
    private static Node search(int key, Node t) {
        if(t==null) //kok yoksa (bu alt agac bossa)
            return null; //bulamadik
        else if(key<t.key) //aranilan deger, kok elemanindan kucukse
            return search(key,t.leftChild); //sol alt agacta ara
        else if(key>t.key) //aranilan deger, kok elemanindan buyukse
            return search(key,t.rightChild); //sag alt agacta ara
        else //aranilan deger, kok elemanina esitse
            return t; //bulduk: elemanin erisim bilgisini dondurur
    }

//remove islevi, key degerine sahip elemani bulup siler
public void remove(int key) {
root=remove(key,root); //ozyinelemeli ic islevi cagir
}

//parametrede verilen key degerine sahip elemani, koku t olan agacin altinda arayip siler
//ozyinelemeli ic islev, oz nitelik erisimi olmadigi icin "static"
private static Node remove(int key, Node t) {
    if(t==null) //kok yoksa (bu alt agac bossa)
        return t; //bulamadik
    if(key<t.key) //silinecek deger, kok elemanindan kucukse
        t.leftChild=remove(key, t.leftChild); //sol alt agacta ara
    else if(key>t.key) //silinecek deger, kok elemanindan buyukse
        t.rightChild=remove(key, t.rightChild); //sag alt agacta ara
    else //bulduk: silelim
        if(t.leftChild!=null && t.rightChild!=null) { //silinecek elemanin 2 cocugu(alt agaci) varsa
            t.key=findMax(t.leftChild).key; //sol alt agacin en buyugu, silinecek olanin yerini alsin
            t.leftChild=remove(t.key, t.leftChild); //simdi bu en buyugu sol alt agactan silelim
        }
        
        else if(t.leftChild!=null) //yalnizca sol cocugu varsa
            t=t.leftChild;         //sol cocuk, silinecek olanin yerine gelsin
        else //yoksa
            t=t.rightChild; //sag cocuk, slinecek olanin yerine gelsin
    return t; //bu alt agacin kok elemaninin erisim bilgisini dondur
}

//findMax islevi, agacin en buyuk elemaninin erisim bilgisini verir.
public Node findMax() {
    if(root==null) return null; //agac bossa, null dondur
    return findMax(root); //degilse ozyinelemeli ic islevi cagir
}

//koku t olan agacin veya alt agacin en buyuk elemaninin erisim bilgisini verir.
//ozyinelemeli ic islev, oz nitelik erisimi olmadigi icin "static"
private static Node findMax(Node t) {
    if(t.rightChild==null) return t; //sag cocuk yoksa, en buyuk bu
    return findMax(t.rightChild); //varsa, sag cocukla devam et
}

//findMin islevi, agacin en kucuk elemaninin erisim bilgisini verir.
public Node findMin() {
    Node t=root; //kokten basla
    if(t!=null) //agac bos degilse
        while(t.leftChild!=null) //sol cocuk bos olmadigi surece,
            t=t.leftChild; //sol taraftan devam et
    return t; //sol cocugu olmayan bu en sol, en alt elemani dondur
   }

public void inorder() { //önce sol alt, sonra eleman, sonra sağ alt
    inorder(root);
    System.out.print("\n");
}
private static void inorder(Node t) {
    if(t!=null) {
        inorder(t.leftChild); //sol alt agaci sirali gez
        System.out.print(t.key + " "); //bu elemani yaz
        inorder(t.rightChild); //sag alt agaci sirali gez
    }
}

public void preorder() { //once eleman, sonra sol alt ve sonra alt sag
    preorder(root);
    System.out.print("\n"); 
}

private static void preorder(Node t) {
    if(t!=null) {
        System.out.print(t.key + " "); //bu elemani yaz
        preorder(t.leftChild); //sol alt agaci sira onceli gezin
        preorder(t.rightChild); //sag alt agaci sira onceli gezin 
    }
}
public void postorder() { //once sol alt, sonra sag alt, en son eleman 
    postorder(root);
    System.out.print("\n");
}
private static void postorder(Node t) {
    if(t!=null) {
        postorder(t.leftChild); //sol alt agaci sira sonrali gezin
        postorder(t.rightChild); //sag alt agaci sira sonrali gezin
        System.out.print(t.key + " "); //bu elemani yaz
                    
    }
  }



public int topla() {
    if(root==null) return 0;
    return topla(root);
    }
private static int topla (Node t) {
   int top,topSol,topSag;
    if(t==null) {
      return top = 0;
    }
    else {
        topSol = topla(t.leftChild);
        topSag = topla(t.rightChild);
        top=t.key+topSol+topSag;
        return top;
    }
  }

    public static void main(String[] args) {
        Tree t=new Tree();
        t.insert(3); t.insert(5);
        t.insert(8); t.insert(2);
      
        System.out.println("Toplam: " + t.topla());
       
       
    }
}
