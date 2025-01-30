public class MyInt {
    private final int value;

    // Constructor
    public MyInt(int value) {
        this.value = value;
    }

    // Returns the int value
    public int intValue() {
        return value;
    }

    // Returns the short value
    public short shortValue() {
        return (short) value;
    }

    // Returns the long value
    public long longValue() {
        return (long) value;
    }

    // Returns the double value
    public double doubleValue() {
        return (double) value;
    }

    // Returns the float value
    public float floatValue() {
        return (float) value;
    }

    // Overriding equals method to compare objects properly
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyInt myInt = (MyInt) obj;
        return value == myInt.value;
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    // Overriding toString method
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    // Main method to test the class
    public static void main(String[] args) {
        MyInt num1 = new MyInt(42);
        MyInt num2 = new MyInt(42);
        MyInt num3 = new MyInt(100);

        System.out.println("num1 intValue: " + num1.intValue());
        System.out.println("num1 shortValue: " + num1.shortValue());
        System.out.println("num1 longValue: " + num1.longValue());
        System.out.println("num1 doubleValue: " + num1.doubleValue());
        System.out.println("num1 floatValue: " + num1.floatValue());
        
        System.out.println("num1 equals num2: " + num1.equals(num2)); // true
        System.out.println("num1 equals num3: " + num1.equals(num3)); // false
        
        System.out.println("num1 hashCode: " + num1.hashCode());
        System.out.println("num1 toString: " + num1.toString());
    }
}
