import java.util.HashMap;
import java.util.Map;

interface DocumentStorage {
    Document retrieveDocument(String documentId);
    void storeDocument(Document document);
}

class Document {
    private String id;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class DocumentStorageProxy implements DocumentStorage {
    private DocumentStorage realStorage;
    private Map<String, String> userPermissions;

    public DocumentStorageProxy(DocumentStorage realStorage) {
        this.realStorage = realStorage;
        this.userPermissions = new HashMap<>();
    }

    @Override
    public Document retrieveDocument(String documentId) {
        // Проверка разрешений пользователя перед доступом к документу
        if (userPermissions.containsKey(documentId)) {
            return realStorage.retrieveDocument(documentId);
        } else {
            return null;
        }
    }

    @Override
    public void storeDocument(Document document) {
        if (userHasPermission()) {
            realStorage.storeDocument(document);
        } else {
        }
    }

    private boolean userHasPermission() {
        return true;
    }
}

class ActualDocumentStorage implements DocumentStorage {
    private Map<String, Document> documents;

    public ActualDocumentStorage() {
        this.documents = new HashMap<>();
    }

    @Override
    public Document retrieveDocument(String documentId) {
        return documents.get(documentId);
    }

    @Override
    public void storeDocument(Document document) {
        documents.put(document.getId(), document);
    }
}

public class Main {
    public static void main(String[] args) {
        DocumentStorage actualStorage = new ActualDocumentStorage();

        DocumentStorage proxy = new DocumentStorageProxy(actualStorage);

        Document doc = proxy.retrieveDocument("123456");
        System.out.println(doc.getContent());
    }
}
