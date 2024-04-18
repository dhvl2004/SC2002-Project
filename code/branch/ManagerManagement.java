package branch;

import staff.Manager;

public class ManagerManagement {
    private Branch branch;

    public ManagerManagement(Branch branch) {
        this.branch = branch;
    }

    public Manager getManager(String managerId) {
        for (Manager manager : this.branch.getManagerList()) {
            if (managerId.equals(manager.getId())) {
                return manager;
            }
        }
        return null;
    }

    public boolean addManager(Manager manager) {
        if (this.branch.managerList.size() == this.branch.getManagerQuota() ||
                getManager(manager.getId()) != null) {
            System.out.println("Cannot add manager. Manager quota reached or manager already exists.");
            return false;
        }

        this.branch.managerList.add(manager);
        System.out.println("Manager added: " + manager.getName());
        return true;
    }

    public Manager removeManager(String managerId) {
        Manager manager = getManager(managerId);
        if (manager == null) {
            System.out.println("Manager with ID " + managerId + " not found.");
            return null;
        }

        this.branch.managerList.remove(manager);
        System.out.println("Manager removed: " + manager.getName());
        return manager;
    }
}
