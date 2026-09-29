void main() {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();

    if ( a == b){
        int sum = a + b;
        System.out.println(sum);
    }else {
        int mult = a * b;
        System.out.println(mult);
    }

}