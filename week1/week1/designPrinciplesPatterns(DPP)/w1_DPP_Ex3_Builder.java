public class w1_DPP_Ex3_Builder {
    public static void main(String[] args) {
        // Using the builder to create different computer configurations
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println("🖥️ Gaming PC: " + gamingPC);
        System.out.println("💼 Office PC: " + officePC);
    }
}

// 1. Product Class
class Computer {
    private String CPU;
    private String RAM;
    private String Storage;
    private String GraphicsCard;

    // Private constructor accepts Builder object
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.GraphicsCard = builder.GraphicsCard;
    }

    // 2. Static Nested Builder Class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String Storage;
        private String GraphicsCard;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }

        public Builder setGraphicsCard(String GraphicsCard) {
            this.GraphicsCard = GraphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "CPU: " + CPU + ", RAM: " + RAM + ", Storage: " + Storage +
               (GraphicsCard != null ? ", GraphicsCard: " + GraphicsCard : "");
    }
}
