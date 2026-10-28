# Quiz 9: Connecting XML Layouts to Java Logic

## Question 1

**Problem in activity_main.xml:**

The TextView is missing the `android:id` attribute.

The Java code calls `findViewById(R.id.txtWelcome)` to look up the TextView, but the XML layout has no `android:id="@+id/txtWelcome"` declared on the `<TextView>` element. Without an ID, Android cannot generate the corresponding `R.id.txtWelcome` reference, and `findViewById` will return `null`, causing a NullPointerException at runtime.

**Fix:** Add the following attribute to the TextView in XML:

```xml
android:id="@+id/txtWelcome"
```

---

## Question 2

After fixing the ID issue, the Java code applies three visual / behavioral modifications to the TextView at runtime:

1. **Text color is changed to red** — `txtWelcome.setTextColor(Color.RED)` sets the text colour to solid red, overriding whatever colour was specified in the XML layout.

2. **Text size is increased to 24** — `txtWelcome.setTextSize(24)` changes the font size from the XML default (18sp) to 24 (scaled pixels).

3. **Text content is converted to uppercase** — `txtWelcome.setText(txtWelcome.getText().toString().toUpperCase())` reads the existing text ("Welcome to COMPX202"), converts it to all capital letters, and writes it back, so the displayed text becomes "WELCOME TO COMPX202".
