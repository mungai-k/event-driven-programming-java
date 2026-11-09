# Bug Fix Documentation

## Bug 1: Blocking the EDT
- **Symptom**: Window freezes for 5 seconds when clicking "Process".
- **Cause**: Executing `Thread.sleep(5000)` directly on the EDT.
- **Fix**: Wrapped task in a background `Thread` and updated GUI using `SwingUtilities.invokeLater()`.

## Bug 2: Missing Listener
- **Symptom**: Clicking "Increment" button produces no action.
- **Cause**: No `ActionListener` registered to `incrementButton`.
- **Fix**: Attached `.addActionListener(e -> ...)` to update state and label.

## Bug 3: Wrong Thread
- **Symptom**: Unstable GUI updates from background thread.
- **Cause**: Direct UI manipulation inside background loop.
- **Fix**: Wrapped `timeLabel.setText()` inside `SwingUtilities.invokeLater()`.

## Bug 4: Memory Leak
- **Symptom**: Memory consumption increases repeatedly after clear action.
- **Cause**: `createdButtons` list retained references after removing UI components.
- **Fix**: Added `createdButtons.clear()` inside the remove handler.
