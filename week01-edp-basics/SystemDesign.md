# Event-Driven System Design: Smart Home Controller

## Part 1: Event Sources
1. **Toggle Switch**: Lights status toggle
2. **Security Toggle**: Security system state toggle
3. **Door Sensor Button**: Simulated door entry trigger

## Part 2: Events
| Event Name | Source | Description |
|---|---|---|
| `lightToggled` | Toggle Switch | User toggled lights state |
| `securityToggled` | Security Toggle | User changed arm/disarm status |
| `doorTriggered` | Door Sensor | Door physical state opened |

## Part 3: Event Handlers
| Event | Handler Action |
|---|---|
| `lightToggled` | Toggle lights status label and append event log |
| `securityToggled` | Change system arm status and trigger alert log |
| `doorTriggered` | Check security state; trigger red visual alarm if armed |

## Part 4: Event Flow Diagram
User Click -> JComponent Event Source -> ActionEvent -> EDT Event Queue -> Event Loop -> ActionListener -> GUI Repaint / Log Update
