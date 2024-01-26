import java.util.Random;
import java.util.Scanner;

public class MainSweeper {
    private int row;
    private int col;
    private int counter;

    public MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void run(){
        Scanner scanner=new Scanner(System.in);
        String[][] ctarla=new String[this.row][this.col];
        String[][] gtarla=new String[this.row][this.col];

        int mayinSayisi=(this.col*this.row)/4;
        int satirs,sutuns;
        Random rSayi=new Random();

        for(int i = 0; i < ctarla.length; i++){
            for(int j = 0; j < ctarla[i].length; j++){
                ctarla[i][j] = " - ";
                gtarla[i][j] = " - ";
            }
        }
        int x=0;
        while(x<mayinSayisi){
            int satir = rSayi.nextInt(this.row);
            int sutun = rSayi.nextInt(this.row);
            if(ctarla[satir][sutun]==" - "){
                ctarla[satir][sutun]=" * ";
                x++;
            }

        }

        int sayac2=0;
        while(true){
            int sayac=0;
            for(int i = 0; i < ctarla.length; i++){

                for(int j = 0; j < ctarla[i].length; j++){

                    System.out.print(ctarla[i][j]);

                }
                System.out.println();
            }
            System.out.println("---------------");
            for(int i = 0; i < ctarla.length; i++){

                for(int j = 0; j < ctarla[i].length; j++){

                    System.out.print(gtarla[i][j]);

                }
                System.out.println();
            }

                System.out.print("satır:");
                satirs = scanner.nextInt();

                System.out.print("sutun:");
                sutuns = scanner.nextInt();
                if(satirs<1 || sutuns<1){
                    System.out.println("geçerli sayı giriniz");
                    continue;
                }


            if(ctarla[satirs-1][sutuns-1]==" * "){
                System.out.println("game over");
                break;
            }
            else{
                for(int i=satirs-2;i<satirs+1;i++){
                    for(int j=sutuns-2;j<sutuns+1;j++){
                        if(i<0){
                            i++;
                        }
                        if(j<0){
                            j++;
                        }
                        if(i> ctarla.length-1){
                            break;
                        }
                        if(j> ctarla.length-1){
                            break;
                        }
                        if(ctarla[i][j]==" * "){
                            sayac=sayac+1;
                        }
                    }
                }
                gtarla[satirs-1][sutuns-1]=" "+sayac+" ";
                sayac2++;

            }
            if(sayac2==(ctarla.length*ctarla.length)-mayinSayisi){
                System.out.println("kazandınız");
                break;
            }


        }
    }

}
