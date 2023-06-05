import java.util.Optional;

public class Car {
    String brand;
    String model;
    Engine engine;

    public Car(String brand, String model, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    public Double findEngineCapacity() {
        return Optional.ofNullable(engine)
                .map(e -> e.engineCapacity)
                .orElse(null);
    }

    public Double findEngineCapacityOnlyIfHorsePowerMoreThan(Double horsePower) {
        return Optional.ofNullable(engine)
                .filter(e -> e.horsePower > horsePower)
                .map(e -> e.engineCapacity)
                .orElse(null);
    }

    public Engine fetchEngine() {
        return engine;
    }
}
