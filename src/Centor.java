
public class Centor extends Entity {
    Centor(int x, int y, Renderer renderer) {
        super(x, y,"art/guard", renderer);
        this.hp = 40;
    }
    void spearThrow(Entity enemy) throws InterruptedException {
        Entity spear = new Entity(this.x + 10,11, "art/spear",renderer);
        spear.moveX(enemy.x + enemy.spriteWidth, this.renderer);
        enemy.takeDamage(10);
        spear.x = renderer.width;
        renderer.loadElements(Element.myElements);
        renderer.Render();
    }
}
