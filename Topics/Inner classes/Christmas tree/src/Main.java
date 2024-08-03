class ChristmasTree {

    String color;

    public ChristmasTree(String color) {
        this.color = color;
    }

    void putTreeTopper(String color) {
        TreeTopper treeTopper = new TreeTopper(color);
        treeTopper.sparkle();
    }

    class TreeTopper {

        String color;

        public TreeTopper(String color) {
            this.color = color;
        }

        void sparkle() {
            System.out.println("Sparkling " + this.color + " tree topper looks stunning with " + ChristmasTree.this.color + " Christmas tree!");
        }
    }
}

class CreateHoliday {

    public static void main(String[] args) {

        ChristmasTree christmasTree = new ChristmasTree("green");
        christmasTree.putTreeTopper("silver");
    }
}