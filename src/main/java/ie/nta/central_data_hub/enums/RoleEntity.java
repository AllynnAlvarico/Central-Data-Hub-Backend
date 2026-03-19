package ie.nta.central_data_hub.enums;

/**
 * Represents the classification of an entity within the system.
 * Defines the role an entity plays, such as an Authority, Operator, Supplier, or Manufacturer.
 */
public enum RoleEntity {

    /**
     * Regulatory or oversight authority.
     */
    AUTHORITY(1, "AUTHORITY", "Authority"),

    /**
     * Operational transport operator.
     */
    OPERATOR(2, "OPERATOR", "Transport Operator"),

    /**
     * Equipment or service supplier.
     */
    SUPPLIER(3, "SUPPLIER", "Supplier"),

    /**
     * Vehicle or hardware manufacturer.
     */
    MANUFACTURER(4, "MANUFACTURER", "Manufacturer");

    private final int id;
    private final String roleCode;
    private final String roleName;

    RoleEntity(int id, String roleCode, String roleName) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

}
