
package hakan_cetinkaya_21099;
import static hakan_cetinkaya_21099.Stack.bnr1;
import static hakan_cetinkaya_21099.Stack.bnr2;
import static hakan_cetinkaya_21099.Stack.duc;
import static hakan_cetinkaya_21099.Stack.ters;


/**
 *
 * @author hakancetinkaya_21099
 */
class Stack {

        private int[] elements;
	private int top;
        public int MAX_SIZE = 100;
      
 
	public Stack()
	{
            top = -1;
	    elements = new int[MAX_SIZE];
	}
        public int size() {
            return top+1;
        }
        public boolean full() {
            return (top==MAX_SIZE-1);
        }
        public boolean empty() {
            return (top == -1);
        }
	public void push(int x) {
            if (full()) throw new RuntimeException("Hata: Yigit dolu");
            ++top;
           
            
            elements[top] = x;
	}

	public int pop() {
            if (empty()) throw new RuntimeException("Hata: Yigit bos");
            int temp = elements[top];
       
            elements[top] = 0;
            top--;
            return temp;
            
            }
        public static void ters(Stack s) {
            Stack s1 = new Stack();
            int temp;
            while(!s.empty()) {
                temp = s.pop();
                if(s1.empty() && temp<s1.top) {
                        s.push(s1.pop());  
                }
                s1.push(temp);
            
            }
            System.out.print("Stack s ters: [ " );
            s=s1;
            while(!s.empty()) {
                System.out.print(s.pop() + " ");
               
            }
            System.out.println("]");    
        }

        public static int bnr1(int n) {
            if(n==0) return 0;
            if(n==1) return 1;
            else return n + bnr1(n-1);
            }
        public static int bnr2(int n) {
            int toplam=0;
            for(int i=1; i<=n; i++) {
                toplam+=i;
                }
            return toplam;
            }
        public static void duc(int n) {
            System.out.println("");//O(1)
            System.out.println("OZ YINELEMESIZ DIK UCGEN: "); //O(1)
      
            for(int i=0;i<=n;i++) { //O(N)
                for(int j=0;j<=i;j++) { //O(N)
                    System.out.print("x");//O(1)
                    }
                System.out.println(""); //O(1)
                }
            
            //******Bu islevin hesaplama karmasikligi: O(N^2)******** 
            
            System.out.println(" ");
            System.out.println("Hesaplama karmaşıklıgı: O(N^2)");
            System.out.println("");
        }

 
        
            
      public static void main(String[] args) {
        System.out.println("ozyinelemesiz sonuc: " + bnr2(10));
        System.out.println("ozyinelemeli sonuc: " + bnr1(10));
        duc(6);
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        s.push(8);
      
     
        ters(s);
      
  
    
       
    
        
      
     
   }
} 
      
      
    

        
    

      

    

