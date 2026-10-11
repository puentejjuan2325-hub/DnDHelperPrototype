public abstract class Entity {
    private String name;
    private int hitPoints;
    private String status;
    private String race;

    public Entity(String name, int hitPoints, String status) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.status = status;
    }
}
