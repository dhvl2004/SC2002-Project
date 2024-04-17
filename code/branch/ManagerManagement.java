package branch;

import staff.Manager;

public class ManagerManagement {
    private Branch branch;

    public ManagerManagement(Branch branch) {
        this.branch = branch;
    }

    public Manager find(String managerId) {
        Manager manager = null;
        for (int i = 0; i < this.branch.managerList.size(); i++) {
            if (managerId == this.branch.managerList.get(i).getId()) {
                manager = this.branch.managerList.get(i);
                break;
            }
        }
        return manager;
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
