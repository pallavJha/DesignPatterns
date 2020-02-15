package pl.hfdp.state.stage1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentTest {

    private Document document;

    @Before
    public void before() {
        document = new Document();
    }

    @Test
    public void addContent() {
        Status status = document.addContent("Some content.");
        assertNotNull(status);
        assertFalse(status.isError());
        assertNull(status.getMessage());
        assertEquals(document.getContent(), "Some content.");
        assertEquals(document.getCurrentStage(), Document.IN_REVIEW);
    }

    @Test
    public void addContentWithInReview() {
        document.addContent("Some content.");
        Status status = document.addContent("Some content.");
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document cannot be updated if it is in IN_REVIEW state.");
    }

    @Test
    public void addContentToApprovedDoc() {
        document.addContent("Some content.");
        document.approve();
        Status status = document.addContent("Some content.");
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document has already been approved.");
    }

    @Test
    public void addContentToRejectedDoc() {
        document.addContent("Some content.");
        document.reject();
        Status status = document.addContent("Some content.");
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document has been rejected.");
    }

    @Test
    public void approve() {
        document.addContent("Some content.");
        Status status = document.approve();
        assertNotNull(status);
        assertFalse(status.isError());
        assertNull(status.getMessage());
        assertEquals(document.getContent(), "Some content.");
        assertEquals(document.getCurrentStage(), Document.APPROVED);
    }

    @Test
    public void approveInDraftStage() {
        Status status = document.approve();
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document cannot be approved if it is in DRAFT stage.");
        assertNull(document.getContent());
        assertEquals(document.getCurrentStage(), Document.DRAFT);
    }

    @Test
    public void approveInApprovedStage() {
        document.addContent("Some content.");
        document.approve();
        Status status = document.approve();
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document has already been approved.");
        assertEquals(document.getContent(), "Some content.");
        assertEquals(document.getCurrentStage(), Document.APPROVED);
    }

    @Test
    public void approveInRejectedStage() {
        document.addContent("Some content.");
        document.reject();
        Status status = document.approve();
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document cannot be approved it is has been rejected already.");
        assertEquals(document.getContent(), "Some content.");
        assertEquals(document.getCurrentStage(), Document.REJECTED);
    }

    @Test
    public void reject() {
        document.addContent("Some content.");
        Status status = document.reject();
        assertNotNull(status);
        assertFalse(status.isError());
        assertNull(status.getMessage());
        assertEquals(document.getContent(), "Some content.");
        assertEquals(document.getCurrentStage(), Document.REJECTED);
    }

    @Test
    public void rejectInDraftStage() {
        Status status = document.reject();
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document cannot be rejected if it is in DRAFT stage.");
        assertEquals(document.getCurrentStage(), Document.DRAFT);
    }

    @Test
    public void rejectInApprovedStage() {
        document.addContent("Some content.");
        document.approve();
        Status status = document.reject();
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document cannot be rejected if it has already been approved.");
        assertEquals(document.getContent(), "Some content.");
        assertEquals(document.getCurrentStage(), Document.APPROVED);
    }

    @Test
    public void rejectInRejectedStage() {
        document.addContent("Some content.");
        document.reject();
        Status status = document.reject();
        assertNotNull(status);
        assertTrue(status.isError());
        assertEquals(status.getMessage(), "The document has already been rejected.");
        assertEquals(document.getContent(), "Some content.");
        assertEquals(document.getCurrentStage(), Document.REJECTED);
    }
}