# Activity 1: EDP Component Scavenger Hunt

| System | Event Source | Event | Listener | Handler / Action |
|---|---|---|---|---|
| ATM Machine | Keypad Button | Button Pressed | ATM Software | Verify PIN entry |
| ATM Machine | Card Slot | Card Inserted | Card Reader | Read card chip/stripe data |
| ATM Machine | Cash Dispenser | Cash Taken | Sensor | Finalize transaction & log |
| Microwave Oven | Door Sensor | Door Opened | Control Panel | Halt magnetron heating |
| Microwave Oven | Start Button | Button Pressed | Timer Loop | Begin countdown & start motor |
| Traffic Light System | In-Road Sensor | Vehicle Detected | Intersection Controller | Schedule green light phase |
| Video Game Gameplay | Keyboard/Controller | Spacebar Pressed | Game Engine | Trigger character jump action |
| Elevator Operation | Floor Button | Call Request Pressed | Elevator Controller | Move cab to target floor |

## Self-Check Responses
1. **Event Source vs Event Listener**: An Event Source generates the event object upon a trigger (e.g., button), whereas an Event Listener listens for that event and dispatches the corresponding handler logic.
2. **One Source, Multiple Listeners**: Yes. A "Save" button click can trigger a listener that writes to a database, and another listener that updates a UI status bar.
3. **One Listener, Multiple Sources**: Yes. A shared `ActionListener` can manage click events from multiple toolbar buttons by checking `e.getSource()`.
