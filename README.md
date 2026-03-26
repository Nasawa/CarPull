# CarPull

An Android app built in 2014 to test a custom animated UI component system. The name's a riff on "carpool" — the app was intended as a ride-sharing setup assistant where you'd add passengers and vehicle details.

## What It Is

CarPull is really a proof of concept for `GreenColor`, a programmatic Android UI builder that renders form elements one at a time with smooth slide-in animations. Instead of defining layouts in XML, you call methods like `postString()`, `postEditTextWithLabel()`, `postNumCounterWithLabel()`, and `postButtonGroup()` to build up a screen dynamically, each element fading and sliding in on cue.

The content is a passenger setup flow ("Who is the first passenger? How big is their vehicle?"), but the real point was seeing how far you could push animated, sequential UI construction in Android without XML layouts.

## Architecture

| File | Purpose |
|------|---------|
| `MainActivity.java` | Entry point — sets up animations and calls `GreenColor` to build the UI |
| `GreenColor.java` | The animated form builder — chains together UI elements with animation |
| `GreenParams.java` | Parameter container passed between animation stages |
| `PassRunner.java` | `Runnable` that handles the actual view creation and animation for each element type |
| `HoloText.java` | Styled text view for the Holo theme |
| `HoloEdit.java` | Styled edit field for the Holo theme |

## How to Run

Open in Android Studio. Targets Android 4.x (Holo theme era). Build and run on a device or emulator.

## Notes

This was an experiment in procedural UI animation, not a finished app. The `GreenColor` component is the interesting part — `PassRunner` handles seven different UI element types (text, edit fields, number pickers, button groups, labeled variants) and applies a coordinated `AnimationSet` (fade + translate) as each one appears.
