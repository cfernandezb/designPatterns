# Builder Design Pattern

- The Builder pattern is a creational design pattern that allows you to create complex objects step by step.
- It separates the construction of an object from its representation, allowing you to create different representations of the same object.
- The Builder pattern is useful when you want to create objects with a complex configuration, where the construction process is complex and requires multiple steps.

```java
public interface Builder {
    void buildPart1();
    void buildPart2();
    Product getResult();
}
```

```java
public class ConcreteBuilder implements Builder {
    private Product product;

    public void buildPart1() {
        product.part1 = "Part 1";
    }

    public void buildPart2() {
        product.part2 = "Part 2";
    }

    public Product getResult() {
        return product;
    }
}
```