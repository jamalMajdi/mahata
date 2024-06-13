
import java.util.Scanner;
class all { // to info

    long letrs[]=new long[3];
    int price_cale []=new int[3];
    int price_buy []=new int[3];
    long eranings[]=new long[3];
    String name[]=new String[]{"بترول","ديزل"," غاز "};
}

public class Mahata{


    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        all all_letr = new all();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t                             ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          محطة النور       \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t        للمشتقات النفطيه       \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                             \n\n\n ");
        long pass, pass1 = 0;
        short chois1;

        do {


            System.out.println("لموظف الماكينه ادخل الرقم [1]");
            System.out.println("للاداره ادخل الرقم[2]");
            System.out.println("للخروج ادخل اي رقم اخر [ ]");
            chois1 = in.nextShort();

            if (chois1 == 1) {
                short chois1_1;

                do {
                    output_pat(all_letr);

                    System.out.println("للخروج ادخل الرقم[1]");
                    System.out.println("للعوده ادخل اي رقم اخر[ ]");
                    chois1_1 = in.nextShort();

                } while (chois1_1 != 1);
            }


            if (chois1 == 2) {//خاص باداره المحطه

                System.out.println("ادخل الرمز=");
                pass = in.nextLong();

                if (pass != pass1) {
                    System.err.println("هذا الرمز خاطى");
                    System.out.println("ادخل الرمز مره اخرى=");
                    pass = in.nextLong();
                }

                if (pass != pass1) {
                    System.err.println("هذا الرمز خاطى");
                    System.out.println("المحاولة الاخيرة    ");
                    System.out.println("ادخل الرمز مره اخرى=");
                    pass = in.nextLong();
                }

                if (pass == pass1) {
                    short chois2_1;

                    do {
                        System.out.println("لاضافه مشتفات نفطيه للمحطه ادخل الرقم [1]");
                        System.out.println("لعرض احصائيات المحطه ادخل الرقم [2]");
                        System.out.println("لتعديل السعر ادخل الرقم [3]");
                        System.out.println("لتغيير الرمز ادخل الرقم [4]");
                        short chois1_2 = in.nextShort();

                        switch (chois1_2) {
                            case 1:
                                long x[]=new long[3];
                                long x1[]=new long[3];
                                input_leatr(all_letr);
                                for (int i=0; i<3; i++){
                                    x[i] = all_letr.price_cale[i] * all_letr.letrs[i];
                                    x1[i] = all_letr.price_buy[i] * all_letr.letrs[i];
                                    all_letr.eranings[i] =  (x[i] - x1[i]);
                                }
                                break;

                            case 2:
                                out_put(all_letr);
                                break;

                            case 3:
                                chang_price(all_letr);
                                break;

                            case 4:
                                System.out.println(" الرمز هو :" + pass1);
                                System.out.println("ادخل الرمز الجديد ");
                                pass1 = in.nextLong();
                                System.out.println("تم التغيير بنجاح ");
                                break;
                        }

                        System.out.println("للعودة للقائمه الرئيسيه ادخل الرقم[1]");
                        System.out.println("للعوده الى الخلف ادخل اي رقم اخر[ ]");
                        chois2_1 = in.nextShort();

                    } while (chois2_1 != 1);
                }

            }
            chois1 = 0;
        } while (chois1 != 1);
    }

    public static void input_leatr(all all) {
        System.out.println("لادخال عدد الترات مع سعر اللتر الواحد :");
        System.out.println("للبترول ادخل الرقم [1]");
        System.out.println("للديزل ادخل الرقم [2]");
        System.out.println("للغاز ادخل الرقم [3]");
        short chois1_3 = in.nextShort();

        switch (chois1_3) {
            case 1:
                all.letrs[0] = input_l();
                all.price_buy[0] = input_s();
                all.price_cale[0] = input_p(all,chois1_3);
                break;

            case 2:
                all.letrs[1] = input_l();
                all.price_buy[1] = input_s();
                all.price_cale[1] = input_p(all,chois1_3);
                break;

            case 3:
                all.letrs[2] = input_l();
                all.price_buy[2] = input_s();
                all.price_cale[2] = input_p(all,chois1_3);
                break;
        }
    }
    public static long input_l() {
        long x_letr;

        do {
            System.out.println("ادخل عدد اللترات:");
            x_letr = in.nextLong();
            if (x_letr < 0) {
                System.err.println("خطا");
                System.out.println("حاول مره اخرى ");
            }
        } while (x_letr < 0);
        System.out.println("تمت الاضافه بنجاح ");
        return x_letr;
    }

    public static int input_p(all all,short s) {
        int c;
        do {

            System.out.println("ادخل سعر اللتر الواحد (بيع)");
            c = in.nextInt();
            if (c < 0) {
                System.err.println("خطا");
                System.out.println("حاول مره اخرى ");
            }
        } while (c < 0);
        if (c<=all.price_buy[s-1]){
            System.out.println("تنبيه ");
            System.out.println("انت الان تبيع بخساره= "+(all.price_buy[s-1]-c)+"ريال لللتر الواحد وبدون ربح  ");
            System.out.println(" يجب عليك تعديل سعر البيع لتفادي الخسائر الفادحة");
        }
        System.out.println("تمت الاضافه بنجاح ");
        return c;
    }
    public static int input_s(){
        int x;
        do {

            System.out.println("ادخل سعر اللتر الواحد (شراء)");
            x = in.nextInt();
            if (x < 0) {
                System.err.println("خطا");
                System.out.println("حاول مره اخرى ");
            }
        } while (x < 0);
        System.out.println("تمت الاضافه بنجاح ");
        return x;

    }

    public static void out_put(all all) {
        System.out.println("اسم المشتق النفطي                عدد اللترات المتبقيه               سعر اللتر الواحد        متوقع صافي الارباح   ");
        for (int i = 0; i < 3; i++)
            System.out.println(all.name[i] + "                               " + all.letrs[i] + "         " + "                    " + all.price_cale[i] + "                         "+all.eranings[i]+"          ");
    }

    public static void output_pat(all all) {
        System.out.println("اختر رقم الماده المراد تعبئتها:");
        System.out.println("للبترول ادخل [1]");
        System.out.println("للديزل ادخل الرقم[2]");
        System.out.println("للغاز ادخل الرقم[3]");
        short chois = in.nextShort();
        switch (chois) {
            case 1:
                out_put_leter(chois,all);
                break;
            case 2:
                out_put_leter(chois,all);
                break;
            case 3:
                out_put_leter(chois,all);
                break;
        }
    }

    public static void out_put_leter(short m ,all all) {
        System.out.println("     "+all.name[m-1]);
        System.out.println("سعر اللتر الواحد =" +all.price_cale[m-1]);
        System.out.println("عدد اللترات المتبقيه لديك ="+all.letrs[m-1]);
        int moany;

        if (all.letrs[m-1]==0)
            System.out.println("لايوجد "+all.name[m-1]+" عليك مراجعه الاداره! ");
        if (all.price_cale[m-1]==0)
            System.out.println("لم يتم اضافه السعر "+" لهاذا اليوم يجب عليك مراجعه الاداره");


        else if (all.price_cale[m-1]!=0&&all.letrs[m-1]!=0){
            do {

                System.out.println("ادخل مبلغ التعبئه ");
                moany = in.nextInt();
                if (moany>0){

                    int c=  iiiii(moany,m,all);
                    all.letrs[m-1]= all.letrs[m-1]-c;

                }
                System.out.println("تمت التعبئه بنجاح");
            } while (moany <= 0);



        }
    }
    public static int iiiii(int mony,short m,all all){
        int c=mony/all.price_cale[m-1];
        System.out.println("عدد اللترات المستحقه= "+c);
        for (int i=0;i<=c;i++){
            if (i <= 9){
                System.out.println("0000"+i);
                sleep(200);
            }
            if (i <= 99 && i >= 10){
                System.out.println("000"+i);
                sleep(200);
            }
            if (i <= 999 && i >= 100){
                System.out.println("00"+i);
                sleep(200);
            }
            if (i <= 999 && i >= 1000){
                System.out.println("0"+i);
                sleep(200);
            }
            if (i <= 9999 && i >= 10000){
                System.out.println(""+i);
                sleep(200);
            }
        }
        System.out.println("تمت التعبئه بنجاح");
        return c;
    }

    public static void chang_price(all all_letr){
        System.out.println("للبترول ادخل الرقم [1]");
        System.out.println("للديزل ادخل الرقم [2]");
        System.out.println("للغاز ادخل الرقم [3]");
        System.out.println("للخروج ادخل اي رقم []");
        int chose = in.nextInt();


        if (chose >= 1 && chose <=3){
            System.out.println("ادخل السعر الجديد ");
            all_letr.price_cale[chose-1] = in.nextInt();
            int cok = all_letr.price_cale[chose-1] - all_letr.price_buy[chose-1] ;
            all_letr.eranings[chose - 1] = cok * all_letr.letrs[chose - 1];
            System.out.println("تم التعدديل بنجاح");
        }
        else
            System.out.println("تم الخروج بنجاح");



    }
    public static void sleep(int milliseconds) {//دالة تاخير وقت ظهور الرسائل للمستخدم
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}