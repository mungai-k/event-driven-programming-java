# Week 1 Self-Assessment & Summary

## Self-Assessment Answers
1. **Event**: An object representing a state change or user interaction (e.g., `ActionEvent`, `MouseEvent`).
2. **Event Source**: The UI or system component that emits the event (e.g., `JButton`, timer).
3. **Event Listener**: An interface waiting for specific events (e.g., `ActionListener`).
4. **Event Handler**: The method executing responsive code (e.g., `actionPerformed()`).
5. **Procedural vs EDP**: Procedural code dictates linear execution; EDP responds asynchronously to user actions.
6. **GUI Advantage**: User freedom to interact with UI components in arbitrary order.
7. **Event Loop & Queue**: Queue stores pending interactions; loop continuously dequeues and runs handlers.
8. **Never Block EDT**: Blocking stops repainting and interaction handling, causing GUI freezes.

## Summary
Event-Driven Programming is structured around asynchronous handling of user and system triggers. In Java Swing, all component construction and UI updates must execute on the Event Dispatch Thread (EDT). Long-running operations must execute on separate background threads to keep the UI responsive.
