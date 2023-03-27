public class Queue17 {
    private Node head;
    private Node tail;
    private int SZ = 0;

    private class Iterator{
        private Node node;
        public Iterator(){this.node = null; }
        //public Iterator(Node node){ this.node = node; }
        public Iterator(int i){
            Node par = Queue17.this.head;
            for(int j=0; j<i; j++){
                if(par == null){
                    this.node = null;
                    break;
                } else if (par.next == null) {
                    this.node = par;
                }else if(j+1 == i){
                    this.node = par;
                }else
                    par = par.next;
            }
        }

        public Node hasNext(){
            return this.node.next;
        }
        public void next(){
            this.node = this.node.next;
        }
        
        public void remove(){
            if (node == null){
                throw new IllegalStateException();
            }else {
                Queue17 outer = Queue17.this;
                if (node == outer.head){
                    outer.remove();
                }else{
                    Node prev = outer.head;
                    while (prev.next != node)
                        prev = prev.next;
                    prev.next = node.next;
                    if (node == outer.tail)
                        outer.tail = prev;
                    outer.SZ -= 1;
                }
                node = null;
            }
        }
    }
    private static class Node{
        private String item;
        private Node next;

        public Node(String item){
            this.item = item;
            this.next = null;
        }

        public Node getNext(){ return this.next;}
        public String getItem(){ return this.item;}

        void setItem(String str){this.item = str;}
        void setNext(Node next){this.next = next;}

    }

    public Queue17(){
        this.head = null;
        this.tail = null;
    }
    public Queue17(String item){
        Node nd = new Node(item);
        this.head = nd;
        this.tail = nd;
        this.SZ = 1;
    }

    public void add(String item){
        Node nd = new Node(item);
        this.tail.next = nd;
        this.tail = nd;
        this.SZ += 1;
    }

    public void remove(){
        this.head = this.head.next;
        this.SZ -= 1;
    }
}
