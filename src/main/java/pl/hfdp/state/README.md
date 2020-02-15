In this tutorial we'll be learning **State Design Pattern**.

> Note: Make sure to go through the code comments as well. It'll help you understand the concept better.

We'll be creating a very simple Document Manager while learning the State Design Pattern. A document can be be in 
different states, like,
- DRAFT: When a document is created or when it is not set for reviews and changes are still going on.
- IN REVIEW: When a document is set for review.
- APPROVED: When a document is approved.
- REJECTED: When a document is rejected.

And, managing these states for a document will be an essential feature of our Document Manager. The transition in the 
states of the document depends upon the action that are taken on the document. For example, it will move into approve
state when it's current state is `IN REVIEW`. I've created this diagram based on the sequence of the actions taken on
the document.

<!-- Add Diagram here -->

This diagram tells us that we have to create handlers in the document that'll take care of the actions taken on the 
document. For example, when a document is created then it should move to `DRAFT` state. Here `creation` of the document
is the action and, obviously, `DRAFT` is the state. Likewise, the document move to `IN REVIEW` stage when the current 
state is `DRAFT` and the user has completed editing the document.

Those were the examples of the Happy Path 😜. What'll happen when the document is moved to `APPROVED` state if the 
current state is `DRAFT`. Well, it shouldn't be allowed and we'll have to handle all such cases as well. Let's start
building our Document Manager.

First, we'll be creating constants for our variables.
```java
// The stages of the document
static final int DRAFT = 0;
static final int IN_REVIEW = 1;
static final int APPROVED = 2;
static final int REJECTED = 3;
```

We'll be saving our current stage here:
```java
// stores the current stage
private int currentStage;

// the content of the document 
private String content;
```

There are 4 actions that we'll have to handle:
- Creation: It will be taken care of by the constructor of the document.
```java
public Document() {
    this.currentState = DRAFT;
}
```
- Moving from Draft To In Review State: We'll make a method `addContent()` for that.
```java
public Status addContent(String content) {
    if (currentState == DRAFT) {
        // Update the content of the document
        this.setContent(content);
        // move to next stage
        this.currentState = IN_REVIEW;
        // return successful status
        return new Status();
    } else if (currentState == IN_REVIEW) {
        // cannot add content if the current state is IN REVIEW
        return new Status(true, "The document cannot be updated if it is in IN_REVIEW state.");
    } else if (currentState == APPROVED) {
        // again, we cannot add content to an approved document
        return new Status(true, "The document has already been approved.");
    } else {
        // same as the previous case
        return new Status(true, "The document has been rejected.");
    }
}
```
- Moving from In Review to Approved State: The method `approve()` should handle it.
```java
public Status approve() {
    if (currentStage == DRAFT) {
        return new Status(true, "The document cannot be approved if it is in DRAFT stage.");
    } else if (currentStage == IN_REVIEW) {
        currentStage = APPROVED;
        return new Status();
    } else if (currentStage == APPROVED) {
        return new Status(true, "The document has already been approved.");
    } else {
        return new Status(true, "The document cannot be approved it is has been rejected already.");
    }
}
```
- Moving from In Review to Rejected State: The method `reject()` should handle it.
```java
public Status reject() {
    if (currentStage == DRAFT) {
        return new Status(true, "The document cannot be rejected if it is in DRAFT stage.");
    } else if (currentStage == IN_REVIEW) {
        currentStage = REJECTED;
        return new Status();
    } else if (currentStage == APPROVED) {
        return new Status(true, "The document cannot be rejected if it has already been approved.");
    } else {
        return new Status(true, "The document has already been rejected.");
    }
}
```

We'll it looks like we've handled all of the cases. But out world is not utopian and there are some new requirements that
we've to take care of.
The clients have asked for a new state, `Closed`, and a new action that can be performed on `Rejected` state which
converts the document to `DRAFT` state.

<!-- Insert Image Here-->

If we would try to accommodate the new changes to our old code then that would not look good. It will be a maintenance
nightmare. Adding one new state will require us to change all the methods so that we can properly handle it. And it's the
same with adding a new action because doing so will also require us to change all the methods that we have.

So how to proceed?

**Encapsulate what varies**, we're ignoring this principle. 

Also, the actions are currently, being handled by the document, however, it should have been handled by the state of the
document instead.

So let's try to follow these steps:
1. Let's create an `abstract class` for `State`. This interface will provide the **behaviours** to handle the actions.
2. Then we'll be creating concrete implementations for each of the States.
3. Our document will have a `State` that will represent the current state of the document.
4. The task for handling the actions will be delegated to the state by the document.

This our new State abstract class:
```java
abstract class State {

    // this method returns the type of the State
    // like, DRAFT, IN REVIEW or APPROVED
    abstract String getType();

    // This map will contain the mapping between actions to handler.
    // For example, one of the entry in map for the state DRAFT could be
    // (REVIEW, Save the content and move to IN REVIEW state)
    private Map<Integer, Function<Input, Status>> actionToHandler = new HashMap<>();

    public void on(int action, Function<Input, Status> handler) {
        actionToHandler.put(action, handler);
    }

    public Status handle(int action, Input input) {
        return actionToHandler.get(action).apply(input);
    }
}
```

And the implementation for the `DRAFT` state could be
```java
class Draft extends State {
    
    @Override
    String getType() {
        return "DRAFT";
    }

    public Draft(Document document) {
        this.on(Action.REVIEW, input -> {
            document.setContent(input.getContent());
            document.setCurrentState(new InReview(document));
            return new Status();
        });

        this.on(Action.APPROVE, input -> new Status(true, "The document cannot be approved if it is in DRAFT state."));

        this.on(Action.REJECT, input -> new Status(true, "The document cannot be rejected if it is in DRAFT state."));

        this.on(Action.CLOSED, input -> new Status(true, "The document cannot be closed if it is in DRAFT state."));
    }
}
```

It can be observed that we've created handlers for all the types of the actions.
Using the same way we can create the `IN REVIEW` state.

```java
class InReview extends State {

    @Override
    String getType() {
        return "IN REVIEW";
    }
      
    public InReview(Document document) {
        this.on(Action.REVIEW, input -> {
            return new Status(true, "The document is already in IN REVIEW state.");
        });
        this.on(Action.APPROVE, input -> {
            document.setCurrentState(new Approved(document));
            return new Status();
        });
        this.on(Action.REJECT, input -> {
            document.setCurrentState(new Rejected(document));
            return new Status();
        });
        this.on(Action.CLOSED, input -> new Status(true, "The document cannot be closed if it is in IN REVIEW state."));
    }
}
```

And now let's create the `Document` class.

```java
class Document {

    // it contains the document's text 
    private String content;

    // this attribute holds the current state of the document
    private State currentState;

    // Whenever a new Document is created, the current State is set to Draft
    public Document() {
        this.currentState = new Draft(this);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    // Whenever any action is performed, it is then delegated to the current state.
    public Status handle(int action, Input input) {
        return this.currentState.handle(action, input);
    }
}
```

Let check if our code is working fine:
```java
Document document = new Document();

State state = document.getCurrentState();
assertEquals(state.getType(), "DRAFT");

Status status = document.handle(Action.REVIEW, new Input("Some Content"));
state = document.getCurrentState();
assertEquals(state.getType(), "IN REVIEW");
assertFalse(status.isError());
assertNull(status.getMessage());
```

Let's review what we've done:
1. We moved the behaviour of state into its own class.
2. Code is less messy, but there more classes.
3. Addition of new State is not going to alter the code of the other States that makes them closed for modification.

And this is **State Design Pattern**.




