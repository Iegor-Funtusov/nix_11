package ua.com.alevel.anonim;

public class AnonimTest {

    public void test() {
        int sum = 0;
        AnonimSumImpl anonimSumImpl = new AnonimSumImpl();
        sum = anonimSumImpl.sum(10, 8);
        AnonimSum anonimSum = new AnonimSumImpl();
        sum = anonimSum.sum(10, 8);
        anonimSum = new AnonimSum() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        sum = anonimSum.sum(10, 8);

        AnonimSum anonimSum1 = (a, b) -> a + b;
        System.out.println("anonimSum1 = " + anonimSum1.sum(10 ,8));

        Print print1 = new Print() {
            @Override
            public void print() {
                System.out.println("AnonimTest.print");
            }
        };

        Print print2 = () ->  System.out.println("AnonimTest.print2");
        print2.print();
    }
}
