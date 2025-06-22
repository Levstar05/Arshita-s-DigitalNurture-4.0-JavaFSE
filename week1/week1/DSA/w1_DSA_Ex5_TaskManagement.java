public class w1_DSA_Ex5_TaskManagement {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Adding tasks
        manager.addTask(new Task(1, "Design UI", "Pending"));
        manager.addTask(new Task(2, "Implement Backend", "Pending"));
        manager.addTask(new Task(3, "Write Tests", "In Progress"));

        // Traversing tasks
        System.out.println("📋 All Tasks:");
        manager.traverseTasks();

        // Searching a task
        System.out.println("\n🔍 Searching for Task ID 2:");
        Task found = manager.searchTask(2);
        System.out.println(found != null ? found : "Task not found");

        // Deleting a task
        System.out.println("\n🗑️ Deleting Task ID 2:");
        manager.deleteTask(2);
        manager.traverseTasks();
    }
}

// 1. Task class (data)
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + taskId + "] " + taskName + " - " + status;
    }
}

// 2. Node class for linked list
class TaskNode {
    Task data;
    TaskNode next;

    public TaskNode(Task task) {
        this.data = task;
        this.next = null;
    }
}

// 3. Singly Linked List Manager
class TaskManager {
    private TaskNode head;

    // Add to end
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("✅ Added: " + task);
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("⚠️ No tasks to show.");
            return;
        }
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Task searchTask(int id) {
        TaskNode current = head;
        while (current != null) {
            if (current.data.taskId == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("⚠️ Task list is empty.");
            return;
        }

        if (head.data.taskId == id) {
            head = head.next;
            System.out.println("✅ Task ID " + id + " deleted (was head).");
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.data.taskId != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("❌ Task not found.");
        } else {
            current.next = current.next.next;
            System.out.println("✅ Task ID " + id + " deleted.");
        }
    }
}
