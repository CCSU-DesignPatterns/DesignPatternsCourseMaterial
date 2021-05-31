**Design pattern:**

**Chain of responsibility**

**Type of pattern:** Behavioral

> Describes pattern of communication and responsibility between objects/classes

**Intent:**

> Avoid coupling the class making request to class servicing request. Allows dynamic chains of responsibility for servicing request that may change at run time.

**Motivation: Real examples**

> **Context sensitive help** user presses F1 for help within screen. What help is displayed may depend on a number of things. For example:

1.  Check if there is help related to the specific button that the mouse is over, if not?...

2.  Check if there is help related to that area of the screen, if not?...

3.  Check if there is help related to that screen, if not?...

4.  Check if there is help related to the previous screen, if not?...

5.  Return help for the application in general

    Key aspect here is that when help is requested which component should respond to the request for help information isn't known ahead of time. For example, what the "previous screen" is may be completely independent of the screen they are currently on but relevant to the general task they were performing. Trying to code for every possible combination is not good or potentially even possible.

    **Java Exception architecture** Handling of exceptions propagates up call stack allowing each calling component an opportunity to handle the exception. Given that there can be a huge number of potential paths to how a common method may be called having the responsibility passed up the chain of the call stack is far more flexible than it being hard coded.

    **Structure**

    ![](./media/image1.gif)

    **Consequences:**

-   Reduced coupling

-   Added flexibility

-   Receipt isn't guaranteed


