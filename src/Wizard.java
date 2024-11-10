public class Wizard extends Entity{
    int hp = 70;
    int mana = 100;


    Wizard(int x, int y, Renderer renderer) {
        super(x, y, "art/wizard.sprite",renderer);
    }


    void takeDamage(int damage) {
        hp -= damage;
    }

    void fireball() throws InterruptedException {
        Entity fireBall = new Entity(this.x + this.spriteWidth + 1, this.spriteHeight -3,"art/fireBall",this.renderer);
        fireBall.moveX(renderer.width, renderer);
    }
}
