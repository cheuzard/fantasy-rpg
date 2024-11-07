public class Main {
    public static void main(String[] args) throws InterruptedException {
//      hiding the cursor

        Renderer renderer = new Renderer(170,38);
        Entity wizard = new Entity(3,1,renderer);

        int i = -1;
        int num;
        while (i++ < 5) {
            renderer.loadElements(Element.myElements);
            renderer.options.setSituation("you just want to walk");
            renderer.options.setOption1("walk to the far left");
            renderer.options.setOption2("walk to the far right");
            renderer.options.setOption3("go to the next level");
            renderer.Render();
            num = renderer.options.proposeOptions();
            switch (num){
                case 1:
                    wizard.moveX(2, renderer);
                    break;
                case 2:
                    wizard.moveX(150, renderer);
                    break;
                case 3:
                    wizard.goToNext();
                    i = 4;
                    break;
            }
        }


        renderer.close();
    }
}