# Limitations of java.util.Observer and java.util.Observable

## Limitation 1: Single Inheritance
`Observable` is a concrete class, not an interface. Java does not support multiple class inheritance, preventing classes that extend other base classes from being observables.

## Limitation 2: Cannot Change Notification Order
The notification order of observers in `Observable` is unspecified and cannot be customized.

## Limitation 3: setChanged() Encapsulation
`setChanged()` is a protected method. Callers cannot flag an object as changed without subclassing it, and forgetting to call `setChanged()` causes notification failure without throwing an error.

## Limitation 4: Pull Model Overhead
Observers must query the `Observable` instance directly to read state changes, increasing coupling and requiring additional method calls.

## Limitation 5: Deprecated Since Java 9
The API is not thread-safe, lacks generic typing support, and relies on inheritance rather than interface delegation.
