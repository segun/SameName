# SameName

African names are usually in the form **Surname Middlename Lastname**. There's usually confusion about which comes first. For instance a name like Ahmed Bayo Chike can also be written as Chike Bayo Ahmed, or any of the other combinations. In fact more often than not, you have someone with two separate IDs bearing one transformation or another of their names.

SameName is a java util that can take any name, in any combination and tell if they are the same or not. It can also tell how close (*confidence*) they are.

### In the simplest form you can use SameName like this

```java
String name1 = "akintayo olusegun";
String name2 = "oyindamola akintayo";
int confidence = 80;
boolean expResult = true;
boolean result = SameName.isSameName(name1, name2, confidence);
assertEquals(expResult, result);
```
**Confidence is a whole number between 0 and 100** 0 meaning not the same and 100 meaning absolutely the same.

### Testing for absolute Equality

```java
System.out.println("isSameName");
String name1 = "akintayo olusegun abiona";
String name2 = "olusegun abiona akintayo";
boolean expResult = true;
boolean result = SameName.isSameName(name1, name2);
assertEquals(expResult, result);
```