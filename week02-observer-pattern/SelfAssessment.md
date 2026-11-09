# Week 2 Self-Assessment & Summary

## Self-Assessment Answers
1. **Subject Role**: Maintains observer registrations and broadcasts state updates via callbacks.
2. **Empty Observer List**: `notifyObservers()` executes its loop 0 times without throwing exceptions.
3. **`java.util.Observable` Deprecation**: Class inheritance restrictions, unhandled notification ordering, and mandatory `setChanged()` calls.
4. **Push vs Pull**: Push transfers data directly inside the update arguments; Pull forces observers to fetch state via getter methods.
5. **Modern Recommended Mechanisms**: Custom Observer pattern interfaces, `PropertyChangeListener` (for Swing/JavaBeans), and JavaFX Properties/Bindings.

## Summary
The Observer pattern establishes a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. Interface-based observer implementations promote loose coupling, high flexibility, and simplified unit testing compared to direct concrete method calls.
