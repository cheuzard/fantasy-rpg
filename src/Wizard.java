public class Wizard extends Entity{
    int hp = 70;
    int mana = 100;


    Wizard(int x, int y, Renderer renderer) {
        super(x, y, "/home/cheuzard/eclipse-workspace/fantasy-rpg/src/art/wizard.sprite",renderer);
    }


    void takeDamage(int damage) {
        hp -= damage;
    }

    void fireball() throws InterruptedException {
        Entity fireBall = new Entity(this.x + this.spriteWidth + 1, this.spriteHeight -3,"/home/cheuzard/eclipse-workspace/fantasy-rpg/src/art/fireBall" +
                "" ,this.renderer);
        fireBall.moveX(this.x + this.spriteWidth + 32, renderer);
        fireBall.moveX(renderer.width, renderer);
    }
}
