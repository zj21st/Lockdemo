public class RunnableDemo {
    public static void main(String[] args) {
    	SellTicket str = new SellTicket();
        
        Thread tr1 = new Thread(str, "����1");
        Thread tr2 = new Thread(str, "����2");
        Thread tr3 = new Thread(str, "����3");
        
        //
        tr1.start();
        tr2.start();
        tr3.start();
    }
}