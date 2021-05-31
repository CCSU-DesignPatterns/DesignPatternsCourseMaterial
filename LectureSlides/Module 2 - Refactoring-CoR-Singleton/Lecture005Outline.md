**Class Outline**

**Lecture 005**

**Dynamic UML part 2** (group examples, summary), **Java** (best
practices, advanced concepts)

Dynamic UML – examples, summary
===============================

-   Group examples

    -   Solar calculator – state diagram

    -   Chess example – state, class, sequence

-   UML Summary

Java – best practices, advanced concepts
========================================

Best practices
--------------

-   Javadoc – package, class, method – see, author, param, return,
    throws

-   Naming conventions – class, method, attribute, constants (come back
    to creation)

-   Packages – purpose, design guidelines, naming, using

-   Generics

Review and advanced concepts
----------------------------

-   Modifiers

    -   Visibility – public, package, protected, private

    -   Class, method, and attribute – final

    -   Class and method only – abstract

        -   What does it mean to be abstract

    -   Method and attribute only – static

        -   What does it mean to be static

    -   Method only – synchronized, native

        -   What does it mean to be synchronized

    -   Attribute only – volatile, transient

        -   Why do I care??? Because it actually does matter!

        -   Constants

-   Exceptions (Chain of responsibility example, will cover soon)

    -   Purpose, why special mechanism, do ***not*** replace debugging!

    -   Sources – JVM (itself, runtime), user code

    -   Hierarchy – expectation is know these 4, reason, proper handling

        -   Throwable

            -   Error

            -   RuntimeException

            -   Exception – defined, user created

    -   Checked vs unchecked

    -   Handling – full, partial, none, unchecked

        -   Best practice – Exception, finally, stack trace

    -   Group work – multi-level, user defined – throwing and handling

        -   A, B, C

        -   Network app – sequence diagram

**All code turned in after this point *must* follow these best practices
in order to receive full credit**
