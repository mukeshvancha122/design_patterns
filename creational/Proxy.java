package creational;

// Interface — defines common operations for both proxy and real registry
interface PackageRegistry {
    void downloadPackage(String packageName);
}

// Real Subject (Basement)
class RealPackageRegistry implements PackageRegistry {
    @Override
    public void downloadPackage(String packageName) {
        System.out.println("Downloading package: " + packageName + " from the main registry...");
    }
}

// Proxy (Ground Floor)
class ProxyPackageRegistry implements PackageRegistry {
    private RealPackageRegistry realRegistry;
    private String userRole;

    public ProxyPackageRegistry(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void downloadPackage(String packageName) {
        if (realRegistry == null) {
            realRegistry = new RealPackageRegistry();
        }

        // Security Check (acts as control)
        if (userRole.equalsIgnoreCase("admin") || userRole.equalsIgnoreCase("developer")) {
            System.out.println("Access granted to " + userRole);
            realRegistry.downloadPackage(packageName);
        } else {
            System.out.println("Access denied. Only developers or admins can download packages.");
        }
    }
}

// Client (Roof)
public class Proxy {
    public static void main(String[] args) {
        PackageRegistry devAccess = new ProxyPackageRegistry("developer");
        devAccess.downloadPackage("react");

        System.out.println();

        PackageRegistry guestAccess = new ProxyPackageRegistry("guest");
        guestAccess.downloadPackage("spring-boot");
    }
}
