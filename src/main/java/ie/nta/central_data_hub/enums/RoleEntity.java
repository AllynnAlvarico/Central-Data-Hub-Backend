package ie.nta.central_data_hub.enums;

public enum RoleEntity {

    AUTHORITY(1, "AUTHORITY", "Authority"),
    OPERATOR(2, "OPERATOR", "Transport Operator"),
    SUPPLIER(3, "SUPPLIER", "Supplier"),
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
