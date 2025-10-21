package creational;

// Step 1: Builder Interface
interface Builder {
    void reset();
    void buildBasement();
    void buildWalls();
    void buildRoof();
}

// Step 2: Product (House)
class House {
    private String basement;
    private String walls;
    private String roof;

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void show() {
        System.out.println("House built with:");
        System.out.println("Basement: " + basement);
        System.out.println("Walls: " + walls);
        System.out.println("Roof: " + roof);
    }
}

// Step 3: Concrete Builders
class WoodenHouseBuilder implements Builder {
    private House house;

    public WoodenHouseBuilder() {
        this.reset();
    }

    public void reset() {
        house = new House();
    }

    public void buildBasement() {
        house.setBasement("Wooden Basement");
    }

    public void buildWalls() {
        house.setWalls("Wooden Walls");
    }

    public void buildRoof() {
        house.setRoof("Wooden Roof");
    }

    public House getResult() {
        return house;
    }
}

class ConcreteHouseBuilder implements Builder {
    private House house;

    public ConcreteHouseBuilder() {
        this.reset();
    }

    public void reset() {
        house = new House();
    }

    public void buildBasement() {
        house.setBasement("Concrete Basement");
    }

    public void buildWalls() {
        house.setWalls("Concrete Walls");
    }

    public void buildRoof() {
        house.setRoof("Concrete Roof");
    }

    public House getResult() {
        return house;
    }
}

// Step 4: Director
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void changeBuilder(Builder builder) {
        this.builder = builder;
    }

    // Example: building order (decides sequence)
    public void constructSimpleHouse() {
        builder.reset();
        builder.buildBasement();
        builder.buildWalls();
    }

    public void constructFullHouse() {
        builder.reset();
        builder.buildBasement();
        builder.buildWalls();
        builder.buildRoof();
    }
}

// Step 5: Client
class BuilderDemo{
    public static void main(String[] args) {
        // 1️⃣ Use Wooden Builder
        WoodenHouseBuilder woodenBuilder = new WoodenHouseBuilder();
        Director director = new Director(woodenBuilder);

        System.out.println("Building Wooden House:");
        director.constructFullHouse();
        House woodenHouse = woodenBuilder.getResult();
        woodenHouse.show();

        System.out.println("\n------------------------");

        // 2️⃣ Switch to Concrete Builder
        ConcreteHouseBuilder concreteBuilder = new ConcreteHouseBuilder();
        director.changeBuilder(concreteBuilder);

        System.out.println("Building Concrete House:");
        director.constructSimpleHouse();
        House concreteHouse = concreteBuilder.getResult();
        concreteHouse.show();
    }
}
