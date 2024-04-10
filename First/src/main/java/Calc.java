public class Calc {
    public static void main(String[] args) {
        final double e = 1e-5;
        double a=0.9999999975;
        double b=2;
        double c=0.9999999975;
       float aa= 0.9999999975F;
        float bb=2F;
        float cc=0.9999999975F;
        byte aaa =1;
        byte bbb = 2;
        byte ccc = 1;
//        double[] res = SquareRoot.solve(a,b ,c , e);
//        double[] res = SquareRoot.solve(aa,bb ,cc , e);
        double[] res = SquareRoot.solve(aaa,bbb ,ccc , e);
        System.out.println(res.length);

        for (double ddd:res){
            System.out.println(ddd);
        }
    }


}
