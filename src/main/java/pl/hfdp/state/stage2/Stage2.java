package pl.hfdp.state.stage2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class Action {
    public static Integer REVIEW = 1;
    public static Integer APPROVE = 2;
    public static Integer REJECT = 3;
    public static Integer CLOSED = 4;
}

class Input {
    private String content;

    public Input(String message) {
        this.content = message;
    }

    public String getContent() {
        return content;
    }
}

class Status {

    private boolean error;

    private String message;

    public Status() {
    }

    public Status(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}

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

class Draft extends State {

    public Draft(Document document) {
        super();
        this.on(Action.REVIEW, input -> {
            document.setContent(input.getContent());
            document.setCurrentState(new InReview(document));
            return new Status();
        });

        this.on(Action.APPROVE, input -> new Status(true, "The document cannot be approved if it is in DRAFT state."));

        this.on(Action.REJECT, input -> new Status(true, "The document cannot be rejected if it is in DRAFT state."));

        this.on(Action.CLOSED, input -> new Status(true, "The document cannot be closed if it is in DRAFT state."));
    }

    @Override
    String getType() {
        return "DRAFT";
    }
}

class InReview extends State {

    public InReview(Document document) {
        super();
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

    @Override
    String getType() {
        return "IN REVIEW";
    }
}

class Approved extends State {

    public Approved(Document document) {

    }

    @Override
    String getType() {
        return "APPROVED";
    }
}

class Rejected extends State {

    public Rejected(Document document) {

    }

    @Override
    String getType() {
        return "REJECTED";
    }
}

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