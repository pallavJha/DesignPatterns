package pl.hfdp.state.stage2;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class DocumentTest {

    private Document document;

    @Before
    public void setUp() {
        document = new Document();
    }

    @Test
    public void getStateAfterInit() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
    }

    @Test
    public void handleReviewWhenInDraft() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        Status status = document.handle(Action.REVIEW, new Input("Some Content"));
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "IN REVIEW");
        TestCase.assertFalse(status.isError());
        TestCase.assertNull(status.getMessage());
    }

    @Test
    public void handleApprovalWhenInDraft() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        Status status = document.handle(Action.APPROVE, null);
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        TestCase.assertTrue(status.isError());
    }

    @Test
    public void handleRejectionWhenInDraft() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        Status status = document.handle(Action.REJECT, null);
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        TestCase.assertTrue(status.isError());
    }

    @Test
    public void handleClosureWhenInDraft() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        Status status = document.handle(Action.CLOSED, null);
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        TestCase.assertTrue(status.isError());
    }

    @Test
    public void handleReviewWhenInReview() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        Status status = document.handle(Action.REVIEW, new Input("Some Content"));
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "IN REVIEW");
        TestCase.assertFalse(status.isError());
        TestCase.assertNull(status.getMessage());

        status = document.handle(Action.REVIEW, new Input("Some Content"));
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "IN REVIEW");
        TestCase.assertTrue(status.isError());
        TestCase.assertNotNull(status.getMessage());
    }

    @Test
    public void handleApprovalWhenInReview() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        Status status = document.handle(Action.REVIEW, new Input("Some Content"));
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "IN REVIEW");
        TestCase.assertFalse(status.isError());
        TestCase.assertNull(status.getMessage());

        status = document.handle(Action.APPROVE, null);
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "APPROVED");
        TestCase.assertFalse(status.isError());
        TestCase.assertNull(status.getMessage());
    }

    @Test
    public void handleRejectionWhenInReview() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        Status status = document.handle(Action.REVIEW, new Input("Some Content"));
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "IN REVIEW");
        TestCase.assertFalse(status.isError());
        TestCase.assertNull(status.getMessage());

        status = document.handle(Action.REJECT, null);
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "REJECTED");
        TestCase.assertFalse(status.isError());
        TestCase.assertNull(status.getMessage());
    }

    @Test
    public void handleClosureWhenInReview() {
        State state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "DRAFT");
        Status status = document.handle(Action.REVIEW, new Input("Some Content"));
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "IN REVIEW");
        TestCase.assertFalse(status.isError());
        TestCase.assertNull(status.getMessage());

        status = document.handle(Action.CLOSED, null);
        state = document.getCurrentState();
        TestCase.assertEquals(state.getType(), "IN REVIEW");
        TestCase.assertTrue(status.isError());
        TestCase.assertNotNull(status.getMessage());
    }
}