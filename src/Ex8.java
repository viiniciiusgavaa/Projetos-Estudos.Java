void main() {
    Scanner scan = new Scanner(System.in);
    int a1 = scan.nextInt();
    int a2 = scan.nextInt();
    int a3 = scan.nextInt();

    if (a3 > a2 && a3 > a1){
        if (a2 > a1){
            System.out.println(a3);
            System.out.println(a2);
            System.out.println(a1);
        } else {
            System.out.println(a3);
            System.out.println(a1);
            System.out.println(a2);
        }
    }else if (a2 > a3 && a2 > a1){
        if(a3 > a1){
            System.out.println(a2);
            System.out.println(a3);
            System.out.println(a1);
        }else{
            System.out.println(a2);
            System.out.println(a1);
            System.out.println(a3);
        }
    } else{
        if (a3 > a2){
            System.out.println(a1);
            System.out.println(a3);
            System.out.println(a2);
        }else{
            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
        }
    }
}