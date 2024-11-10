public class Entity extends Element {
    String spritePath;
    Renderer renderer;


    Entity(int x, int y, String spritePath,Renderer renderer) {
        super();
        this.x = x;
        this.y = y;
        this.renderer = renderer;
        loadSprite(spritePath);
        myElements[numOfElements] = this;
        numOfElements++;
    }

    void moveX(int x, Renderer renderer) throws InterruptedException {
        if (Math.abs(x - this.x)/5 > 0){
            int step = Math.min(Math.abs(x - this.x)/5,14);
            int fpm = Math.abs(x - this.x)/step;
            if (x - this.x > 0){
                for (int i = 0; i < fpm; i++) {
                    this.x = i == fpm - 1 ? x: (this.x += step) ;
                    renderer.loadElements(Element.myElements);
                    renderer.Render();
                    Thread.sleep(150);
                }
            }else if (x - this.x < 0){
                for (int i = 0; i < fpm; i++) {
                    this.x = i == fpm - 1 ? x: (this.x -= step) ;
                    renderer.loadElements(Element.myElements);
                    renderer.Render();
                    Thread.sleep(150);
                }
            }
        }
    }
    void goToNext() throws InterruptedException {
        this.moveX(170 - 5 -this.spriteWidth, renderer);
        this.moveX(170, renderer);
    }

//    private boolean spaceCheck(int limit, int step){
//        if (step < 0){
//            return this.x + step > 0;
//        }else if (step > 0){
//            return this.x + this.spriteWidth+ step < limit;
//        }
//        return true;
//    }
}
