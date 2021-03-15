package concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnSafe {
    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
            throw new Error(exception);
        }
    }

    public static void main(String[] args) {
        TestUnSafe test = new TestUnSafe();
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
