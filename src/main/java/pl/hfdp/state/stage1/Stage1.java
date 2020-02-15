package pl.hfdp.state.stage1;

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

class Document {

    // The stages of the document
    static final int DRAFT = 0;
    static final int IN_REVIEW = 1;
    static final int APPROVED = 2;
    static final int REJECTED = 3;

    private int currentStage;

    private String content;

    public int getCurrentStage() {
        return currentStage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Document() {
        this.currentStage = DRAFT;
    }

    public Status addContent(String content) {
        if (currentStage == DRAFT) {
            this.content = content;
            this.currentStage = IN_REVIEW;
            return new Status();
        } else if (currentStage == IN_REVIEW) {
            return new Status(true, "The document cannot be updated if it is in IN_REVIEW state.");
        } else if (currentStage == APPROVED) {
            return new Status(true, "The document has already been approved.");
        } else {
            return new Status(true, "The document has been rejected.");
        }
    }

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
}