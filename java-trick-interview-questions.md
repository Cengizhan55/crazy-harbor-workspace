

## 1. What Happens If You Override a Private Method?

Question:

Can we override a private method in Java?

Explanation:

No, private methods cannot be overridden because they are not visible to subclasses. However, if you define a method with the same name in a subclass, it is considered method hiding, not overriding.

Example:
