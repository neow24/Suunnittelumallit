package proxy;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class AccessControlService {
    private static AccessControlService instance;
    private Set<Permission> permissions;

    private AccessControlService() {
        permissions = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null)
            instance = new AccessControlService();
        return instance;
    }
    
    public void allowAccess(int documentId, String username) {
        permissions.add(new Permission(documentId, username));
    }

    public boolean isAllowed(int documentId, String username) {
        return permissions.contains(new Permission(documentId, username));
    }

    private static class Permission {
        int documentId;
        String username;

        Permission(int documentId, String username) {
            this.documentId = documentId;
            this.username = username;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Permission that = (Permission) o;
            return documentId == that.documentId &&
                Objects.equals(username, that.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(documentId, username);
        }
    }
}
