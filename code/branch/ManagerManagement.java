package branch;

import staff.Manager;

public class ManagerManagement {
    private Branch branch;

    public ManagerManagement(Branch branch) {
        this.branch = branch;
    }

    public Manager find(String managerId) {
        for (Manager manager : this.branch.managerList) {
            if (managerId.equals(manager.getId())) {
                return manager;
            }
        }
        return null;
    }

    public boolean add(Manager manager) {
        if (this.branch.managerList.size() == this.branch.getManagerQuota() ||
        this.find(manager.getId()) != null) {
            return false;
        }

        this.branch.managerList.add(manager);
        return true;
    }

    public Manager remove(String managerId) {
        Manager manager = this.find(managerId);
        if (manager == null) {
            return null;
        }

        this.branch.managerList.remove(manager);
        return manager;
    }
}
