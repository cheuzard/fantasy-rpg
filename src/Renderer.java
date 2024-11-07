import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Renderer {
    int height;
    int width;
    char[][] screen;
    Options options = new Options();

    Renderer( int width, int height) {
        this.width = width;
        this.height = height;
        screen = new char[height][width];
        clearScreen();
        System.out.print("\033[?1049h");
    }


    void loadElements(Element[] list) {
        for (int n = 0; n < Element.numOfElements; n++) {
            int y = height - list[n].y - list[n].sprite.length;
            for (int i = 0; i < list[n].sprite.length; i++) {
                for (int j = 0; j < list[n].sprite[i].length; j++) {
                    if (!Character.isWhitespace(list[n].sprite[i][j])) {
                        if (list[n].x + j <this.width - 1 && list[n].x + j > 0){
                        screen[y+i][list[n].x + j] = list[n].sprite[i][j];
                        }
                    }
                }
            }
        }
    }

    void Render(){
        System.out.print("\033[?25l\033[2J\033[H");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(screen[y][x]);
            }
            System.out.println();
        }

        clearScreen();

    }
    private void clearScreen() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y==0 || y==height -1) {
                    if(x == 0 || x == width-1) {
                        screen[y][x] = '+';
                    }else {
                        screen[y][x] = '-';
                    }
                } else if (x==0 || x==width-1) {
                    screen[y][x] = '|';
                }else {
                    screen[y][x] = ' ';
                }
            }
        }
    }

    void close(){
        System.out.print("\033[?1049h\033[2J\033[H");
    }

    int getSelection(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(br.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    static class Options{
        String option1;
        String option2;
        String option3;
        String situation;

        Options(){}

        void setSituation(String situation){
            this.situation = situation;
        }

        void setOption1(String option1){
            this.option1 = option1;
        }
        void setOption2(String option2){
            this.option2 = option2;
        }
        void setOption3(String option3){
            this.option3 = option3;
        }

        int proposeOptions(){
            System.out.println(situation);
            System.out.println("1) "+ option1);
            System.out.println("2) "+ option2);
            System.out.println("3) "+ option3);
            System.out.print ("\033[?25h");
            return getSelection();
        }
        static int getSelection(){
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                return Integer.parseInt(br.readLine());
            }catch (Exception e){
                e.printStackTrace();
            }
            return 0;
        }
    }
}
