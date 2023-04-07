import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(calc(sc.nextLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String calc(String input) throws Exception {
        int res = 0;
        boolean isRom = false;

        String[] in  = input.split(" ");
        if(in.length != 3) throw new Exception("формат математической операции не удовлетворяет заданию");
        int a = 0;
        int b = 0;
        if((in[0].matches("[I,X,V,L,C]+") && in[2].matches("[0-9]+"))||(in[0].matches("[0-9]+") && in[2].matches("[I,X,V,L,C]+"))) throw new Exception("используются одновременно разные системы счисления");
        if(in[0].matches("[0-9]+") && in[2].matches("[0-9]+")){
            a=Integer.parseInt(in[0]);
            b=Integer.parseInt(in[2]);

            }
        if(in[0].matches("[I,X,V,L,C]+") && in[2].matches("[I,X,V,L,C]+")){
            isRom = true;
            a=Roman.valueOf(in[0]).ordinal();
            b=Roman.valueOf(in[2]).ordinal();

        }
        switch (in[1]){
            case ("+"):
                res = a+b;
                break;
            case ("-"):
                if(isRom && a<b) throw new Exception("в римской системе нет отрицательных чисел");
                res = a-b;
                break;
            case ("*"):
                res = a*b;
                break;
            case ("/"):
                if(b==0)throw new Exception("деление на 0 запрещено");
                res = a/b;
                break;
            default: throw new Exception("строка не является математической операцией");
        }

        if(isRom){
            return in[0]+" "+in[1]+" "+in[2]+" = "+Roman.getString(res);
        }

        return in[0]+" "+in[1]+" "+in[2]+" = "+res;

    }

}