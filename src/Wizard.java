public class Wizard extends Entity{
    int mana = 100;


    Wizard(int x, int y, Renderer renderer) {
        super(x, y, "art/wizard.sprite",renderer);
        this.hp = 70;
    }




    void fireball(Entity enemy) throws InterruptedException {
        Entity fireBall = new Entity(this.x + this.spriteWidth + 1, this.spriteHeight -3,"art/fireBall",this.renderer);
//        fireBall.moveX(this.x + this.spriteWidth + 32, renderer);
        fireBall.moveX(enemy.x - fireBall.spriteWidth, renderer);
        enemy.takeDamage(10);
        fireBall.x = renderer.width;
        renderer.loadElements(Element.myElements);
        renderer.Render();
    }
}
