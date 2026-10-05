public class Ex18 {
    public static void main(String[] args) {
        int count = 0;

        while (count < 10) {
            System.out.println(++count);

            for (int i=0; i<10; i++){

                System.out.println("For"+i);

            }
        }
    }
}