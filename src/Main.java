public class Main {
    public static void main(String[] args) throws InterruptedException {
//      hiding the cursor

        Renderer renderer = new Renderer(170,38);
        Wizard wizard = new Wizard(3,1,renderer);
        Centor guard = new Centor(140,1,renderer);

        int i = -1;
        int num;
        while (i++ < 5) {
            renderer.loadElements(Element.myElements);
            renderer.options.setSituation( "your hp:" + wizard.hp + " enemy hp: " + guard.hp+"\nyou just want to walk");
            renderer.options.setOption1("walk to the far left");
            renderer.options.setOption2("cast a fireball");
            renderer.options.setOption3("go to the next level");
            renderer.Render();
            num = renderer.options.proposeOptions();
            switch (num){
                case 1:
                    wizard.moveX(2, renderer);
                    break;
                case 2:
                    wizard.fireball(guard);
                    Thread.sleep(2000);
                    guard.spearThrow(wizard);
                    break;
                case 3:
                    wizard.goToNext();
                    break;
            }
        }


        renderer.close();
    }
}