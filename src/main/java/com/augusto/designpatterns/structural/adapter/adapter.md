# Adapter Design Patter

The adapter pattern is a structural design pattern that allows objects with incompatible interfaces to colloborate. It acts as a bridge between two incompatible interfaces by converting the interface of a class into another interface that a client expects.

### Key Components:

1. **Target:** The interface thet client expects or uses.
2. **Adapter:** A class thet implements the Target interface and wraps the Adatee to make it compatible.
3. **Adaptee:** The existing class with an incompatible interface that needs to be adapted.
4. **Client:** The class that interacts with the Target interface.

### Diagram Example:

       +-------------+                +------------+
       |   Client    |                |   Target   |
       +-------------+                +------------+
              |                             ^
              |                             |
              |                   +---------+----------+
              |                   |                    |
       +------------------+    +----------------+   +-------------+
       |     Adapter      |<---|    Adaptee     |   |  ClientCode |
       +------------------+    +----------------+   +-------------+
